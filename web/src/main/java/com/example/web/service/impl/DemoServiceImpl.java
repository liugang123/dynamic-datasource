package com.example.web.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.request.context.BasicRequestContext;
import com.example.route.datasource.enums.DataSourceTypeEnum;
import com.example.route.datasource.toolkit.DynamicDataSourceContextHolder;
import com.example.web.dao.UserDAO;
import com.example.web.dao.po.UserPO;
import com.example.web.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liugang
 * @create 2021/12/21
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public String test(String param) {
        // 数据源
        DataSourceTypeEnum dataSource = DataSourceTypeEnum.getEnumByName(BasicRequestContext.datasource());
        DynamicDataSourceContextHolder.setDataSource(dataSource);

        // 执行查询
        UserPO userPO = userDAO.getUserById("1001");
        log.info("userPO:{}", JSONUtil.toJsonStr(userPO));

        // 请求上下文
        String device = BasicRequestContext.device(), platform = BasicRequestContext.platform(), version = BasicRequestContext.version();
        log.info("device:{},platform:{},version:{}", device, platform, version);
        return param;
    }

}
