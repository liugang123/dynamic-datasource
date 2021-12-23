package com.example.route.datasource.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 注解切入点
 *
 * @author liugang
 * @create 2021/12/23
 */
public class DynamicDataSourceAnnotationPointcut implements Pointcut {

    private final Class<? extends Annotation> annotationType;

    public DynamicDataSourceAnnotationPointcut(Class<? extends Annotation> annotationType) {
        this.annotationType = annotationType;
    }

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new AnnotationMethodMatcher(annotationType);
    }

    private static class AnnotationMethodMatcher extends StaticMethodMatcher {
        private final Class<? extends Annotation> annotationType;

        public AnnotationMethodMatcher(Class<? extends Annotation> annotationType) {
            this.annotationType = annotationType;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            if (matchesMethod(method)) {
                return true;
            }
            // Proxy classes never have annotations on their redeclared methods.
            if (Proxy.isProxyClass(targetClass)) {
                return false;
            }
            // The method may be on an interface, so let's check on the target class as well.
            Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);
            return (specificMethod != method && matchesMethod(specificMethod));
        }

        private boolean matchesMethod(Method method) {
            return AnnotatedElementUtils.hasAnnotation(method, this.annotationType);
        }
    }

}
