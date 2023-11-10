package com.bezkoder.spring.datajpa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@SpringBootConfiguration
@ContextConfiguration
class SpringBootDataJpaApplicationTests {

	
  private static  Logger log = LoggerFactory.getLogger(SpringBootDataJpaApplicationTests.class);
	
	 
  @Test
  void contextLoads() {
		
		log.info("+-------------- <SpringBootDataJpaApplicationTests.contextLoads> -----------------------+" );
	}
  
  @Test
  void contextLoads2() {
		
		log.info("+-------------- <SpringBootDataJpaApplicationTests.contextLoads2> -----------------------+" );
		
  }
 
 
	SpringBootDataJpaApplicationTests() 
	{
		
		System.out.print("SpringBootDataJpaApplicationTests ");
		
	}
 
}
