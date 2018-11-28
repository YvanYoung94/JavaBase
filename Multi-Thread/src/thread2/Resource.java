package thread2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: Yvan Young
 * @Date: 2018/11/28 12:31
 * @Version 1.0
 */
public class Resource {
    private List<Double> list = new ArrayList<>();


    public synchronized void set(){
        if (list.size()>=20) {
            try {
                System.out.println("仓库满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double num = Math.ceil(Math.random() * 100);
        System.out.println(Thread.currentThread().getName() + "生成了：" + num);
        list.add(num);
        this.notify();
    }
    public synchronized void get(){
        if (list.size() == 0) {
            try {
                System.out.println("卖完了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "消费了----------：" + list.get(0));
        list.remove(0);
        this.notify();
    }
}

class Produce implements Runnable {
    private Resource resource;

    public Produce(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.set();
        }
    }
}

class Consume implements Runnable {
    private Resource resource;

    public Consume(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.get();
        }
    }
}
