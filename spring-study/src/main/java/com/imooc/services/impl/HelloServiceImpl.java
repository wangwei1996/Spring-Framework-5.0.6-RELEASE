package com.imooc.services.impl;

import com.imooc.services.HelloService;

public class HelloServiceImpl implements HelloService {
	@Override
	public void sayHello() {
		System.out.println("I am HelloService , sayHello");
	}

	@Override
	public void sayHelloServiceThrowException() {
		throw new IllegalArgumentException("I am HelloService , sayHelloServiceThrowException");
	}
}
