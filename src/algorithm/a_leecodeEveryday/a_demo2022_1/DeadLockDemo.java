package algorithm.a_leecodeEveryday.a_demo2022_1;

public class DeadLockDemo {
    public static void main(String[] args) {

    }
    public static void deadLock(){
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(()->{
            synchronized (obj1){}
        }).start();
    }
}
