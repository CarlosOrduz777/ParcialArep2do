package com.server.proxy;

import java.util.concurrent.locks.ReentrantLock;

public class RoundImpement extends RoundRobin{

    private int counter = 0;
    private final ReentrantLock lock;

    public RoundImpement() {
        lock = new ReentrantLock();
    }



    @Override
    public String getIp() {
        lock.lock();
        try {
            String ip = ipList.get(counter);
            counter += 1;
            if (counter == ipList.size()) {
                counter = 0;
            }
            return ip;
        } finally {
            lock.unlock();
        }
    }
}
