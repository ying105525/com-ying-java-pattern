package proxy.jdk;

/**
 * @author 应森亮
 * @date 2019/12/03
 * @desc
 */
public class DemoTest {

    /**
     * 通过JDK动态代理获取接口对象，调用具体实现类的实现方法
     * @param args 参数
     * 1、拿到被代理对象的引用，并且反射获取获取到它的所有的接口。
     * 2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
     * 3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
     * 4、编译新生成的Java代码.class
     * 5、再重新加载到JVM中运行
     * 以上这个过程就叫字节码重组
     *
     * JDK中有个规范，只要要是$开头的一般都是自动生成的
     */
    public static void main(String[] args) {
        People people = (People) new JDKProxyDemo().getInstance(new MrWang());
//        System.out.println(people.getClass());
        people.sleep("8");
    }
}
