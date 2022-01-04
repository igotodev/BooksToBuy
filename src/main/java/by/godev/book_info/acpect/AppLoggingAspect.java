package by.godev.book_info.acpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class AppLoggingAspect {

    @Around("execution(public * by.godev.book_info.controller.*.*(..))")
    public Object allControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.printf("%s start (%s) method\n", dateStringForLogging(), methodName);
        Object methodResult = joinPoint.proceed();

        return methodResult;
    }

    private String dateStringForLogging() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
        return simpleDateFormat.format(date);
    }
}
