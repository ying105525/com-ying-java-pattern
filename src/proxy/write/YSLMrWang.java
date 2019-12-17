package proxy.write;

import proxy.jdk.People;

import java.lang.reflect.Method;

/**
 * @author 应森亮
 * @date 2019/12/07
 * @desc YSLMrWang实现自定义的YSLInvocationHandler接口
 */
public class YSLMrWang implements YSLInvocationHandler {


    private People people;

    public Object getInstance(People people){
        this.people = people;
        Class<?> clazz = people.getClass();
        return null;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是实现体YSLMrWang 的invoke方法内部");
        method.invoke(this.people,args);
        System.out.println("实现体YSLMrWang 的invoke方法调用结束");
        return null;
    }
}
