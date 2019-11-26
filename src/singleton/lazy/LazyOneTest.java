package singleton.lazy;

import java.util.concurrent.CountDownLatch;

public class LazyOneTest {

    /**
     * 模拟并发情况，检验懒汉模式单例第一种实现方法是否线程安全
     * 从输出的结果中看到可能出现多个不同的LazyDemoOne的实例（不同内存地址），也就是其是线程不安全的
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int count = 10000;
//        定义计数器
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                latch.countDown();
                LazyDemoOne instance = LazyDemoOne.getInstanece();
                System.out.println(System.currentTimeMillis() + ": " + instance);
            }).start();
        }
        try {
            latch.await();
            System.out.println("计数结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
