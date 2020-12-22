import xyz.dengjunbo.framework.proxy.Student;

public class test {
    public static void main(String[] args) {
//        BeforeProxy beforeProxy = new BeforeProxy();
//        AfterProxy afterProxy = new AfterProxy();
//        List<Proxy> proxyList = new ArrayList<Proxy>();
//        proxyList.add(afterProxy);
//        proxyList.add(beforeProxy);
//        Student student = ProxyManager.createProxy(Student.class, proxyList);
        Student student = new Student();
        student.sayHello();
    }
}
