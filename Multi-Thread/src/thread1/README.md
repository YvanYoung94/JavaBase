##### 多线程的案例-买电影票 ：三个窗口，卖100张票

​	**将 100张票设置为成员变量，在多线程买票的情况下，产生了两个问题：**

​	1：出现了重复票

​	2：出现了负数（不存在的票）

​	**分析多线程情况下，产生脏数据的原因：**

​	1：多线程情况下

​	2：有共享的数据的操作情况(操作了成员变量）

​	3：在run方法有非原子性操作

​	**解决办法：**

​	对非原子性操作 ，加把锁，让非原子性操作，变成原子性操作	

​	synchronized关键字。

​	**同步方法的格式：**

​	synchronized 返回值类型  方法名(参数列表){

​		代码块

​	}





​	**总结一下锁的问题：**

​	同步代码块： 锁可以 任意对象，只要保证唯一即可，（Object, this, 类型.class)

​	同步方法：

​	非静态的方法  ：this

​	静态的方法：类名.class

##### 多线程--主线程在子线程运行完以后运行

​	CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。