package com.it.shw.oom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.it.shw.oom.mapper")
@SpringBootApplication
public class SpringBootMybatisOomDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisOomDemoApplication.class, args);
	}

}
