package com.tianye.helloejob.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianshujian
 * Create Date: 2019/12/9 20:11
 * Description: ${DESCRIPTION}
 */
public class NamedThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final boolean daemon;

    NamedThreadFactory(ThreadPoolEnum threadPoolEnum) {
        namePrefix = threadPoolEnum.getDesc() + "-thread-";
        daemon = false;

    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread( r, namePrefix + threadNumber.getAndIncrement());
        t.setDaemon(daemon);
        return t;
    }
}
