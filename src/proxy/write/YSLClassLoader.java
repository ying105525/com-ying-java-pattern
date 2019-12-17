package proxy.write;

import java.io.File;

/**
 * @author 应森亮
 * @date 2019/12/08
 * @desc 自定义的类加载器
 */
public class YSLClassLoader extends ClassLoader {

    private File classPathFile;

    /**
     * 构造器
     * 获取当前路径并作为classPathFile的入参进行初始化
     */
    public YSLClassLoader() {
        String classPath = YSLClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = YSLClassLoader.class.getPackage().getName() + "." + name;

        if(classPathFile!=null){
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
        }
        return super.findClass(name);
    }
}
