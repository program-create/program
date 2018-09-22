package com.qfedu.common.quartz;

import com.qfedu.common.redis.RedisUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author Amos
 * @Date 2018/9/19 0019 17:33
 */
public class QuartzForDelSignFlag implements Job {

    @Override
    public void execute (JobExecutionContext jobExecutionContext) throws JobExecutionException {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.del("signFlag");
    }
}
