package com.liurl.peanut.module;

import java.util.List;

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */

public class Temporary {

    /**
     * title : 问题类型
     * sub_title : 选择你要反馈的问题类型
     * hint :
     * options : ["显示错误","数据错误","应用闪退"]
     * value : 显示错误
     */

    private String title;
    private String sub_title;
    private String hint;
    private String value;
    private List<String> options;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
