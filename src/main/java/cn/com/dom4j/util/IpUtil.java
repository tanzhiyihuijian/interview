package cn.com.dom4j.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP相关工具类
 */
public class IpUtil {


    public static String getIp(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (isNotIp(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if (isNotIp(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (isNotIp(ip))
            ip = request.getRemoteAddr();

        return ip;
    }

    private static boolean isNotIp(String ip) {
        return ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase(ip, "unknown");
    }



}
