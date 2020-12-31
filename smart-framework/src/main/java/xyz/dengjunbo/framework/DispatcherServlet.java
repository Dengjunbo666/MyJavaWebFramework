package xyz.dengjunbo.framework;

import xyz.dengjunbo.framework.bean.Data;
import xyz.dengjunbo.framework.bean.Handler;
import xyz.dengjunbo.framework.bean.Param;
import xyz.dengjunbo.framework.bean.View;
import xyz.dengjunbo.framework.helper.*;
import xyz.dengjunbo.framework.util.JsonUtil;
import xyz.dengjunbo.framework.util.ReflectionUtil;
import xyz.dengjunbo.framework.util.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 请求转发器
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
       //初始化相关Help类
        HelperLoader.init();
        //获取servletContext对象（用于注册Servlet）
        ServletContext servletContext = config.getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
        UploadHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletHelper.init(request,response);
        try {
            //获取请求方法与请求路径
            String requestMethod = request.getMethod().toLowerCase();
            String requestPath = request.getPathInfo();
            if (requestPath.equals("/favicon.ico")){
                return;
            }
            //获取Action处理器
            Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
            if (handler != null){
                //获取Controller 类及其Bean实例
                Class<?>controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);

                Param param;
                if (UploadHelper.isMultipart(request)){
                    param = UploadHelper.createParam(request);
                }else {
                    param = RequestHelper.createParam(request);
                }
                Object result;
                Method actionMethod = handler.getActionMethod();
                if (param.isEmpty()){
                    result = ReflectionUtil.invokeMethod(controllerBean,actionMethod);
                }else {
                    result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
                }
                if (result instanceof  View){
                    handleViewResult((View)result,request,response);
                }else if (result instanceof Data){
                    handleDataResult((Data)result,response);
                }

            }
        }finally {
            ServletHelper.destroy();
        }

    }
    private void handleViewResult(View view,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String path = view.getPath();
        if (StringUtil.isNotEmpty(path)){
            if (path.startsWith("/")){
                response.sendRedirect(request.getContextPath()+path);
            }else {
                Map<String,Object>model = view.getModel();
                for (Map.Entry<String,Object>entry:model.entrySet()){
                    request.setAttribute(entry.getKey(),entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(request,response);
            }
        }
    }
    private void handleDataResult(Data data,HttpServletResponse response) throws IOException {
        Object model = data.getModel();
        if (model != null){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
