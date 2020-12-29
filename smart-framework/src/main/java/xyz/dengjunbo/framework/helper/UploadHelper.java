package xyz.dengjunbo.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件上传助手类
 */
public final class UploadHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadHelper.class);
    /**
     * Apache Commons FileUpload 提供的 Servlet 文件上传对象
     */
    private static ServletFileUpload  servletFileUpload;
}
