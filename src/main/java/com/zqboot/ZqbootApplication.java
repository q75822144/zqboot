package com.zqboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zqboot.interfaces.*.dao")
public class ZqbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZqbootApplication.class, args);
	}
}
