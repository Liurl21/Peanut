package com.liurl.peanut.module;

import java.util.List;

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */

public class Temporary {

    /**
     * title : 页面截图(最多3张)
     * sub_title :
     * hint :
     * limit : 3
     * value : ["",""]
     */

    private String title;
    private String sub_title;
    private String hint;
    private int limit;
    private List<String> value;

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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
