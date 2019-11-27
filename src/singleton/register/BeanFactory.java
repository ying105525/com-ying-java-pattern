package singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例
 * Spring中的做法。
 */
public class BeanFactory {
    /**
     * 私有构造方法
     */
    private BeanFactory() {
    }

//    静态map，ConcurrentHashMap支持并发的线程安全
    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    /**
     * 用Map去保存对于的bean以及其实例
     * 如果没有就通过反射的方式获取一个，如果有就返回
     * @param className 类名
     * @return 对象实例
     */
    public static Object getBeanByName(String className){
        if(!ioc.containsKey(className)){
            Object bean = null;
            try{
                  bean = Class.forName(className).newInstance();
            }catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return bean;
        }else {
            return ioc.get(className);
        }

    }

}
