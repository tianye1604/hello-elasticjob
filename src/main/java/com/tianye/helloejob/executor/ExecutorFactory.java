package com.tianye.helloejob.executor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianshujian
 * Create Date: 2019/12/9 20:00
 * Description: 线程池工厂
 */
public class ExecutorFactory {
    private static final Map<String, ThreadPoolExecutor> executorMap = new ConcurrentHashMap<>();

    static {
        executorMap.put(ThreadPoolEnum.DEFAULT_THREADPOOL.getName(),getThreadPool(ThreadPoolEnum.DEFAULT_THREADPOOL, Runtime.getRuntime().availableProcessors() * 2, 100, 30000, 10000));
        executorMap.put(ThreadPoolEnum.ELASTICJOB_THREADPOOL.getName(),getThreadPool(ThreadPoolEnum.ELASTICJOB_THREADPOOL, 2,30,30000, 1000));
    }
    /**
     * 实例化线程池枚举
     * @param threadPoolEnum 线程池信息
     * @param corePoolSize 核心线程数
     * @param maxPoolSize 最大线程数
     * @param keepAliveMilSec 空闲线程最大存活时间（ms）
     * @param queueSize 阻塞任务队列
     */
    private static ThreadPoolExecutor getThreadPool(ThreadPoolEnum threadPoolEnum, int corePoolSize, int maxPoolSize, int keepAliveMilSec, int queueSize){
        return new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveMilSec,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(queueSize),
                new NamedThreadFactory(threadPoolEnum),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    /**
     * 根据线程池枚举，获取线程池
     * @param threadPoolEnum
     * @return
     */
    public static ThreadPoolExecutor getThreadPoolExecutor(ThreadPoolEnum threadPoolEnum){
        ThreadPoolExecutor executor = executorMap.get(threadPoolEnum.getName());
        return executor == null ? executorMap.get(ThreadPoolEnum.DEFAULT_THREADPOOL.getName()) : executor;
    }


}
