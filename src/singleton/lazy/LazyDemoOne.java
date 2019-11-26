package singleton.lazy;

public class LazyDemoOne {
    public LazyDemoOne() {
    }

    //   静态块，公共内存区域
    private static LazyDemoOne lazyDemoOne = null;

    /**
     * 先判断lazyDemoOne是否为null，
     * 再择机选择初始化，并保存到公共内存区域中
     * @return lazyDemoOne
     * 看似线程安全，其实是线程不安全的。
     */
    public static LazyDemoOne getInstanece() {
//        可能同时会有多个线程进入到if语句块中进行初始化。
        if (lazyDemoOne == null) {
            lazyDemoOne = new LazyDemoOne();
        }
        return lazyDemoOne;
    }
}
