package com.tianye.helloejob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tianshujian
 * Create Date: 2019/12/6 14:50
 * Description: ${DESCRIPTION}
 */
@Component
public class SimpleDemoJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {


        System.out.println(String.format("------【%s】Thread ID: %s, %s,任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "当前任务名称: %s.当前任务参数 %s",
                Thread.currentThread().getName(),
                Thread.currentThread().getId(),
                new SimpleDateFormat("HH:mm:ss").format(new Date()),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()

        ));
        System.out.println("任务"+shardingContext.getShardingItem()+"执行中.....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务"+shardingContext.getShardingItem()+"执行结束");
    }
}
