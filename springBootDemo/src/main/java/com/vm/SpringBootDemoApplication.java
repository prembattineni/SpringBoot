package com.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vm.dao.IProductDao;
import com.vm.entity.Product;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	@Autowired
	IProductDao iProductDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception{   //to print in command line
		System.out.println("first spring boot application");
		Product product=new Product(10,"laptop","electronics",40000);
	    iProductDao.save(product);
	    System.out.println(product);
	}
}