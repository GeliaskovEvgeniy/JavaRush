package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread
{
    static AtomicInteger i = new AtomicInteger(0);

    public MyThread() {
        i.getAndIncrement();
        if (i.compareAndSet(MAX_PRIORITY, MIN_PRIORITY));
        this.setPriority(i.get());
    }

    public MyThread(Runnable target) {
        super(target);
        i.getAndIncrement();
        if (i.compareAndSet(MAX_PRIORITY, MIN_PRIORITY));
        this.setPriority(i.get());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        i.getAndIncrement();
        if (i.get() >= group.getMaxPriority())
        {
            this.setPriority(group.getMaxPriority());
            if (i.compareAndSet(MAX_PRIORITY,0));
        }else {
            this.setPriority(i.get());}
    }

    public MyThread(String name) {
        super(name);
        i.getAndIncrement();
        if (i.compareAndSet(MAX_PRIORITY, MIN_PRIORITY));
        this.setPriority(i.get());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group,name);
        i.getAndIncrement();
        if (i.get() >= group.getMaxPriority())
        {
            this.setPriority(group.getMaxPriority());
            if (i.compareAndSet(MAX_PRIORITY,0));
        }else {
        this.setPriority(i.get());}
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        i.getAndIncrement();
        if (i.compareAndSet(MAX_PRIORITY, MIN_PRIORITY));
        this.setPriority(i.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        i.getAndIncrement();
        if (i.get() >= group.getMaxPriority())
        {
            this.setPriority(group.getMaxPriority());
            if (i.compareAndSet(MAX_PRIORITY,0));
        }else {
            this.setPriority(i.get());}
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        i.getAndIncrement();
        if (i.get() >= group.getMaxPriority())
        {
            this.setPriority(group.getMaxPriority());
            if (i.compareAndSet(MAX_PRIORITY,0));
        }else {
            this.setPriority(i.get());}
    }


}
