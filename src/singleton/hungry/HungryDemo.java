package singleton.hungry;


/**
 * 饿汉式单例，默认就没有实例对象，一开始就new一个对象，并且作为静态成员变量。
 */
public class HungryDemo {
    public HungryDemo() {
    }

//    静态常量instance，保证了该类只有一个实例对象。
    private static final HungryDemo instance = new HungryDemo();

//    获取静态常量。
    public static HungryDemo getInstance(){
        System.out.println(System.currentTimeMillis() + ":" + instance);
        return instance;
    }
}
