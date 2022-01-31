/**
 * Created by smit on 29/1/22.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

class Memory1 implements Runnable{
    int[][] a=new int[10][10];
//    Memory1(){
//        Arrays.fill(a,0);
//    }

    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println("Thread1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Memory2 implements Runnable {
    int[][] a=new int[100][1000];
//    Memory2(){
//        Arrays.fill(a,100000);
//    }

    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println("Thread2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Memory3 implements Runnable{
    int[][] a=new int[10000][10000];
    //    Memory3(){
//        Arrays.fill(a,10000000);
//    }
    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println("Thread3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadClassTest implements Runnable{
    Lock lock=new ReentrantLock();
    int count=0;
    @Override
    public void run() {
        lock.lock();
        count++;
        System.out.println("Count: "+count);

        lock.unlock();

    }
}
public class visualVMMemoryTest {
    public static void main(String[] args) {
        Runnable refMemory=new Memory1();
        Runnable ref=new ThreadClassTest();
        while(true){
//            Thread thread=new Thread(ref);
//            thread.start();
//            Thread thread2=new Thread(ref);
//            thread2.start();
            Thread thread1=new Thread(refMemory);
            Thread thread2=new Thread(new Memory2());
            Thread thread3=new Thread(new Memory3());
            thread1.start();
            thread2.start();
            thread3.start();
        }

    }
}