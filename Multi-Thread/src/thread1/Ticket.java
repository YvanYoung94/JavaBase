package thread1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Describe:
 * @Author: Yvan Young
 * @Date: 2018/11/28 12:03
 * @Version 1.0
 */
public class Ticket implements Runnable {
    private static int num = 100;
    private static Lock lock = new ReentrantLock();
    private CountDownLatch latch;

    public Ticket(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (num <= 0) {
                    latch.countDown();
                    break;
                }
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了标号为" + num + "的票");
                num--;
            } finally {
                lock.unlock();
            }
        }
    }
}
