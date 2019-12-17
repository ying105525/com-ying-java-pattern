package proxy.write;

import java.lang.reflect.Method;

/**
 * @author 应森亮
 * @date 2019/12/03
 * @desc 自定义动态代理接口
 */
public interface YSLInvocationHandler {
    /**
     * invoke 方法，作为动态代理调用被代理对象的方法入口
     * @param proxy 代理
     * @param method 方法
     * @param args 方法入参
     * @return 需要返回的对象
     * @throws Throwable 抛出异常
     */
    Object invoke(Object proxy, Method method,Object[] args) throws  Throwable;
}
