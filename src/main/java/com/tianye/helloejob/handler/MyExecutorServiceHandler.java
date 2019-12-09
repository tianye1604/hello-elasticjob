package com.tianye.helloejob.handler;

import com.dangdang.ddframe.job.executor.handler.ExecutorServiceHandler;
import com.tianye.helloejob.executor.ExecutorFactory;
import com.tianye.helloejob.executor.ThreadPoolEnum;

import java.util.concurrent.ExecutorService;

/**
 * Created by tianshujian
 * Create Date: 2019/12/9 18:26
 * Description: ${DESCRIPTION}
 */
public class MyExecutorServiceHandler implements ExecutorServiceHandler {
    @Override
    public ExecutorService createExecutorService(String jobName) {
        return ExecutorFactory.getThreadPoolExecutor(ThreadPoolEnum.ELASTICJOB_THREADPOOL);

    }
}
