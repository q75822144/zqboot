package com.zqboot.constant;

/**
 * Created by zhouquan on 2018/4/11.
 */
public enum DataSourceType {
    write("write", "主库"),
    read("read", "从库");
    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
