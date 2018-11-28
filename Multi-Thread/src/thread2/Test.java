package thread2;

/**
 * @Describe:
 * @Author: Yvan Young
 * @Date: 2018/11/28 13:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Resource r = new Resource();

        Produce p = new Produce(r);
        Consume c = new Consume(r);

        Thread t0 = new Thread(p, "Produce 1");
        Thread t1 = new Thread(p, "Produce 2");
        Thread t2 = new Thread(c, "Consume 1");
        Thread t3 = new Thread(c, "Consume 2");

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
