package com.example.route.datasource.aop;

import com.example.route.datasource.annotation.DataSource;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;

/**
 * 注解切面定义
 *
 * @author liugang
 * @create 2021/12/23
 */
public class DynamicDataSourceAnnotationAdvisor extends AbstractPointcutAdvisor {

    private final Pointcut pointcut;

    private final Advice advice;

    public DynamicDataSourceAnnotationAdvisor(Advice advice) {
        this.advice = advice;
        this.pointcut = new DynamicDataSourceAnnotationPointcut(DataSource.class);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
