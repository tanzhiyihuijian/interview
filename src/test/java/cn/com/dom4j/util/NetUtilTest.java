package cn.com.dom4j.util;

import org.junit.Test;

import java.net.URLDecoder;
import java.util.Base64;

public class NetUtilTest {

    @Test
    public void get() throws Exception {

        String url = "http://api.map.baidu.com/location/ip";
        String params = "ak=F454f8a5efe5e577997931cc01de3974&ip=120.134.33.9";

        String s = NetUtil.get(url + "?" + params);
        System.out.println(s);

        System.out.println("-------------------------------------------------");
        s = NetUtil.post(url, params);
        System.out.println(s);


        String province = "\\u5317\\u4eac\\u5e02\\u5317\\u4eac\\u5e02";

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(province);

        System.out.println(new String(decode));


    }

}