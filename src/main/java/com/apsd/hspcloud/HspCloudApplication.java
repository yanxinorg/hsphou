package com.apsd.hspcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.apsd.hspcloud.mapper","com.apsd.hspcloud.dao"})

public class HspCloudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HspCloudApplication.class, args);

	}
}
