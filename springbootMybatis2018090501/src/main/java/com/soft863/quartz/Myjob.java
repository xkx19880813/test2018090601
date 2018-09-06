package com.soft863.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component//对象注入
public class Myjob {

    @Scheduled(cron="0/5 * * * * *")//任务调度克隆表达式：秒，分钟，小时，日期，月份，星期，年份
    //*指任意时刻，可在任何位置，？只在日期星期是占位符，-指范围，“，”列表的值枚举，“/”x/y,x初始值，y步长
    //不用调用，到时见自动执行
    public void test(){

        System.out.println("-----------任务调度---------");

    }
}
