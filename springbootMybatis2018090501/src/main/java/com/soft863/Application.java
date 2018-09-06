package com.soft863;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//标记为springboot启动类
@ComponentScan//扫描注解，默认扫描所在包及子包
@EnableTransactionManagement//启用事务
//@EnableScheduling//启动任务调度
@MapperScan(value="com.soft863.dao")//扫描dao层接口
@EnableCaching//启用mybatis二级缓存Redis，在需要缓存的dao方法上加注解
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    /**
     * 为使用外部tomcat
     * 继承SpringBootServletInitializer,重写方法
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
