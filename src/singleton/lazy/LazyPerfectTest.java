package singleton.lazy;

import java.util.concurrent.CountDownLatch;

public class LazyPerfectTest {

    /**
     * 模拟并发情况，检验LazyDemoPerfect这种实现方法是否线程安全
     * 从输出的结果中看到只存在一个LazyDemoPerfect的实例（未见不同内存地址），也就是其是线程安全的
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
                LazyDemoPerfect instance = LazyDemoPerfect.getInstance();
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
