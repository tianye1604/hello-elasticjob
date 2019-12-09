package com.tianye.helloejob.executor;


/**
 * Created by tianshujian
 * Create Date: 2019/12/9 20:43
 * Description: ${DESCRIPTION}
 */
public enum  ThreadPoolEnum{
    DEFAULT_THREADPOOL("DEFAULT_THREADPOOL","默认线程池"),
    ELASTICJOB_THREADPOOL("ELASTICJOB_THREADPOOL","定时任务线程")

    ;
    private String name;
    private String desc;

    ThreadPoolEnum(final String name, final String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }}
