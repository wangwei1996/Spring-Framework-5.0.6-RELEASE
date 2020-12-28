package com.imooc.proxy.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StuMethodInterceptor implements MethodInterceptor {

	/**
	 * @param o           被代理的对象
	 * @param method      当前执行的方法(被代理对象的)
	 * @param args        方法执行所需的参数
	 * @param methodProxy 动态代理方法实例
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object returnVal = null;
		System.out.println("CGLIB 代理方法执行之前");
		returnVal = methodProxy.invokeSuper(o, args);
		System.out.println("CGLIB 代理方法执行之前");

		return returnVal;
	}
}
