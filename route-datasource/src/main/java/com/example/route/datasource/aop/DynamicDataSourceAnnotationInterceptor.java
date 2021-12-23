package com.example.route.datasource.aop;

import com.example.route.datasource.enums.DataSourceTypeEnum;
import com.example.route.datasource.toolkit.DataSourceClassUtil;
import com.example.route.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 注解切入逻辑
 *
 * @author liugang
 * @create 2021/12/23
 */
@Slf4j
public class DynamicDataSourceAnnotationInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 从注解解析数据源
        String datasource = DataSourceClassUtil.computeDatasource(invocation.getMethod(), invocation.getThis());
        DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.getEnumByName(datasource);
        DynamicDataSourceContextHolder.setDataSource(dataSourceTypeEnum);
        log.info("注解拦截器，设置数据源，datasource:{}", datasource);

        try {
            return invocation.proceed();
        } finally {
            log.info("注解拦截器，清除本地线程变量");
            DynamicDataSourceContextHolder.clear();
        }
    }
}
