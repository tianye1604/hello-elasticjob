package com.tianye.helloejob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;

/**
 * Created by tianshujian
 * Create Date: 2019/12/9 17:38
 * Description: ${DESCRIPTION}
 */
public class MyDistributeOnceElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    public MyDistributeOnceElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        System.out.println("-----------------------------------------------------");
        System.out.println("分布式监听器开始："+System.currentTimeMillis());
        System.out.println("-----------------------------------------------------");

    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        System.out.println("-----------------------------------------------------");
        System.out.println("分布式监听器结束时间："+System.currentTimeMillis());
        System.out.println("-----------------------------------------------------");
    }
}
