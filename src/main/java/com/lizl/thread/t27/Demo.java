package com.lizl.thread.t27;

import java.util.concurrent.locks.StampedLock;

/**
 * @author lizl
 * @date 2018/5/23 15:37
 */
public class Demo {

    private int balance;
    private StampedLock lock = new StampedLock();

    public void conditionReadWrite(int value) {
       long stamp = lock.readLock();
        while (balance > 0){
            long writeStamp = lock.tryConvertToWriteLock(stamp);
            if(writeStamp != 0){
                //成功转换为写锁
                stamp = writeStamp;
            }else {
                //没有转换为写锁，这里首先手工释放读锁 然后在拿到写锁
                lock.unlockRead(stamp);

                stamp = lock.writeLock();
            }
        }


    }

    public void optimisticRead(){
        long stamp = lock.tryOptimisticRead();

        int c = balance;

        if(lock.validate(stamp)){
            long readStamp = lock.readLock();
            c = balance;
            stamp = readStamp;
        }

        lock.unlockRead(stamp);
    }

    public void read(){
        long stamp = lock.readLock();
        int c = balance;

        lock.unlockRead(stamp);
    }

    public void write(int value){
        long stamp = lock.writeLock();
        balance += value;

        lock.unlockWrite(stamp);
    }

}
