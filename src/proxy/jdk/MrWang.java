package proxy.jdk;

/**
 * @author 应森亮
 * @date 2019/12/02
 * @desc People接口实现类，其中增加了work()方法以及一个name字段。
 */
public class MrWang implements People {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("这里是 eat()方法内部");
        System.out.println("我叫" + name);
        System.out.println("我喜欢吃肉");
    }

    @Override
    public void sleep(String hours) {
        System.out.println("这里是 sleep()方法内部");
        System.out.println("我每天睡：" + hours + "小时");
    }

    public void work(){
        System.out.println("这里是MrWang独有的work方法内部");
        System.out.println("MrWang喜欢工作");
    }

}
