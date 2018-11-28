package thread1;

import java.util.concurrent.CountDownLatch;

/**
 * @Describe:
 * @Author: Yvan Young
 * @Date: 2018/11/28 12:07
 * @Version 1.0
 */
public class TicketDemo {
    public static void main(String[] args) {
        int threadNums = 3;
        CountDownLatch latch = new CountDownLatch(threadNums);
        Ticket ticket = new Ticket(latch);
        for (int i=1; i<=threadNums; i++) {
            new Thread(ticket, i + "号窗口").start();
        }
        try {
            latch.await();
            System.out.println("票卖完了，请明天再来");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
