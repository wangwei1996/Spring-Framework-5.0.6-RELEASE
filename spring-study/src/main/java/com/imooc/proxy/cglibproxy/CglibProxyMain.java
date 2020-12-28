package com.imooc.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLIB代理实践一下
 */
public class CglibProxyMain {
	public static void main(String[] args) {

		AliPayment o = (AliPayment) Enhancer.create(AliPayment.class, new StuMethodInterceptor());
		o.pay();

	}
}
