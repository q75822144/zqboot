package com.zqboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zqboot.interfaces.*.dao")
@EnableScheduling
@ServletComponentScan
public class ZqbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZqbootApplication.class, args);
	}
}
