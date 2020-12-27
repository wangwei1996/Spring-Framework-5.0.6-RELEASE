package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStu {
	/**
	 * 切入点定义
	 * (* com.imooc.services..*.*(..))
	 * 第一个“*”代表方法的返回值,与后面的内容使用空格进行分隔
	 * com.imooc.services代表包名,services后面的两点表示子包
	 * 第二个“*”表示类
	 * 第三个“*”表示类中的方法
	 * (..)表示方法的参数，这里表示的是所有的参数
	 * <p>
	 * 即： 将包com.imooc.services及其子包下的任何类的下的任何参数以及任何返回值的方法都作为切入点
	 */
	@Pointcut("execution(* com.imooc.services..*.*(..))")
	public void embed() {
	}

	@Before(value = "embed()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("I am execution(* com.imooc.services..*.*(..)) --->beforeAdvice");
	}

	@After(value = "embed()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("I am execution(* com.imooc.services..*.*(..)) --->afterAdvice");
	}

	@AfterReturning(value = "embed()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("I am execution(* com.imooc.services..*.*(..)) --->afterReturning");
	}

	@AfterThrowing(value = "embed()")
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("I am execution(* com.imooc.services..*.*(..)) --->afterThrowing");
	}

	@Around(value = "embed()")
	public Object aroundAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("execution(* com.imooc.services..*.*(..)) --->aroundAdvice--->proceed方法执行之前");
		Object returnVal = null;
		try {
			returnVal = ((ProceedingJoinPoint) joinPoint).proceed();
		} catch (Throwable throwable) {
			System.out.println("((ProceedingJoinPoint) joinPoint).proceed()  出现异常");
			throw throwable;
		}
		System.out.println("execution(* com.imooc.services..*.*(..)) --->aroundAdvice--->proceed方法执行之后");
		return returnVal;
	}
}
