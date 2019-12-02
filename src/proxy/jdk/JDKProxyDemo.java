package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 应森亮
 * @date 2019/12/02
 * @desc
 */
public class JDKProxyDemo implements InvocationHandler {

//    被代理对象
    private People people;


    public Object getInstance(People people){
        this.people = people;
        Class<?> clazz = people.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     * 动态代理调用被代理对象方法的地方
     * @param proxy 代理
     * @param method 方法
     * @param args 方法参数
     * @return 返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是代理Demo的invoke方法内部");

        method.invoke(this.people,args);

        System.out.println("调用被代理对象的方法结束");
        return null;
    }
}
