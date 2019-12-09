package com.tianye.helloejob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * Created by tianshujian
 * Create Date: 2019/12/6 14:52
 * Description: ${DESCRIPTION}
 */
public class MyElasticJobListener implements ElasticJobListener {

    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println();
        System.out.println("===>{} JOB BEGIN <=== " );
    }


    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("===>{} JOB END <===");
        System.out.println();
    }
}
