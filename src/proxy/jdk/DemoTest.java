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
     */
    public static void main(String[] args) {
        People people = (People) new JDKProxyDemo().getInstance(new MrWang());
//        System.out.println(people.getClass());
        people.sleep("8");
    }
}
