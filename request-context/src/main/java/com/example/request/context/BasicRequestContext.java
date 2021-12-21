package com.example.request.context;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 上下文请求对象
 *
 * @author liugang
 * @create 2021/12/16
 */
public class BasicRequestContext {

    public static final String REQUEST_PLATFORM = "platform";
    public static final String REQUEST_VERSION = "version";
    public static final String REQUEST_DEVICE = "device";

    private static ThreadLocal<Map<String, Object>> paramsThreadLocal = new TransmittableThreadLocal();

    private static Map<String, Object> paramsMap() {
        Map<String, Object> map = paramsThreadLocal.get();
        if (Objects.isNull(map)) {
            map = new HashMap<>();
            paramsThreadLocal.set(map);
        }
        return map;
    }

    public static Object get(String key) {
        return paramsMap().get(key);
    }

    public static void set(String key, Object value) {
        paramsMap().put(key, value);
    }

    public static void clear() {
        paramsThreadLocal.remove();
    }

    /**
     * 版本
     *
     * @return
     */
    public static String version() {
        Object version = paramsMap().get(REQUEST_VERSION);
        if (Objects.nonNull(version)) {
            return String.valueOf(version);
        }
        return null;
    }

    /**
     * 设备
     *
     * @return
     */
    public static String device() {
        Object device = paramsMap().get(REQUEST_DEVICE);
        if (Objects.nonNull(device)) {
            return String.valueOf(device);
        }
        return null;
    }

    /**
     * 平台
     *
     * @return
     */
    public static String platform() {
        Object platform = paramsMap().get(REQUEST_PLATFORM);
        if (Objects.nonNull(platform)) {
            return String.valueOf(platform);
        }
        return null;
    }
}
