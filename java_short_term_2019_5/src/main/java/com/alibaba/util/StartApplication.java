package com.alibaba.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//和SSM中一样，扫描了这个包的controller、service
@SpringBootApplication(scanBasePackages= {"com.alibaba.controller","com.alibaba.service.impl"})
//开启springboot的默认配置
@EnableAutoConfiguration
//配置mapper层的扫描
@MapperScan(basePackages="com.alibaba.mapper")
public class StartApplication {
	public static void main(String[] args) {
		//springboot启动器
	SpringApplication.run(StartApplication.class, args);
	}
}
