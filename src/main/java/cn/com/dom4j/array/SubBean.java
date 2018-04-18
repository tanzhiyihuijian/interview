package cn.com.dom4j.array;

import cn.com.dom4j.access.ProtectedBean;

public class SubBean extends ProtectedBean {


    public String getName() {
        return "hello " + super.getName();
    }


}
