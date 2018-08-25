package top.qifansfc.study_springboot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aop注解
@Aspect
@Component
public class LogAspect {
    @Before("execution(public * top.qifansfc.study_springboot.controller.UserController.getUserById(..))")
    public void before(){
        System.out.println("-------------hello 方法执行前-------------");
    }

    @After("execution(public * top.qifansfc.study_springboot.controller.UserController.getUserById(..))")
    public void after(){
        System.out.println("-------------hello 方法执行后-------------");
    }
}
