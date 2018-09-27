package com.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;



@Aspect
@Component
@Slf4j
public class LogAnnotationAspect {
	
	 @Pointcut("execution(* com.modular.*.*.*(..))")
	 public void webLog() {
		 System.out.println("开启AOP注解");
	 }
	 
	 @Before("webLog()")
	 public void dobefore(JoinPoint joinPoint) {
		 	log.info("前置通知：");                     //info ,debug ,warn ,erro四种级别，这里我们注入info级别
	 
	        //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	 
	        log.info("URL:" + request.getRequestURL().toString());         // 想那个url发的请求
	        log.info("METHOD:" + request.getMethod());
	        log.info("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "."
	                + joinPoint.getSignature().getName());                     // 请求的是哪个类，哪种方法
	        log.info("ARGS:" + Arrays.toString(joinPoint.getArgs()));     // 方法本传了哪些参数
	 }
	
}
