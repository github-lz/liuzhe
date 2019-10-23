
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicReference;

import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(100,1);
    public static void main(String args[])
    {
//        AtomicReference<String> atomicReference = new AtomicReference<>("A");

//        System.out.println(atomicReference.compareAndSet("A", "B")+"\t"+atomicReference.get());
//        System.out.println(atomicReference.compareAndSet("B", "A")+"\t"+atomicReference.get());

//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(atomicReference.compareAndSet("A", "B")+"\t"+atomicReference.get());
//            System.out.println(atomicReference.compareAndSet("B", "A")+"\t"+atomicReference.get());
//        },"t1").start();
//
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(atomicReference.compareAndSet("A", "B")+"\t"+atomicReference.get());
//        },"t2").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 101, stamp , atomicStampedReference.getStamp() + 1)+"\t值："+atomicStampedReference.getReference());
            System.out.println(atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+"\t值: "+atomicStampedReference.getReference());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(100, 200, stamp, atomicStampedReference.getStamp() + 1)+"\t值："+atomicStampedReference.getReference());
        },"t4").start();
    }
}
