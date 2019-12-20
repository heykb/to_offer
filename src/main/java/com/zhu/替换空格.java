package com.zhu;

public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s","%20");
    }
}
