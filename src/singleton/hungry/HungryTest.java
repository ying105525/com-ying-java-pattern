package singleton.hungry;

import java.util.concurrent.CountDownLatch;

public class HungryTest {

    /**
     * 模拟并发情况，检验饿汉模式单例是否线程安全
     * 从输出的结果中看到时间在变化，但是HungryDemo实例还是同一个内存地址，也就是同一个类对象，证明其线程安全。
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int count = 100;
//        定义计数器
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                latch.countDown();
                HungryDemo.getInstance();
            }).start();
        }
        try {
            System.out.println("当前计数为： " + latch.getCount());
            latch.await();
            System.out.println("计数结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
