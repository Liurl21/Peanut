package com.liurl.peanut.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author liuruilin
 * @data 2017/10/27
 * @describe 信息采集模板 -> 组件采集信息存储表
 */
@Entity
public class Source {
    /**
     * 每份信息都有一个唯一的标识 uuid
     */
    String uuid;

    /**
     * 单个组件对应数据库字段的 key 值
     */
    String key;

    /**
     * 组件用来解析渲染的配置信息
     */
    String data;

    /**
     * 组件的类型
     */
    String type;

    /**
     * 组件是否默认显示
     */
    Boolean isShow;

    /**
     * 组件是否为列表展示字段
     */
    Boolean isList;

    /**
     * 组件显示顺序id
     */
    int rankId;

    @Generated(hash = 896203226)
    public Source(String uuid, String key, String data, String type, Boolean isShow,
            Boolean isList, int rankId) {
        this.uuid = uuid;
        this.key = key;
        this.data = data;
        this.type = type;
        this.isShow = isShow;
        this.isList = isList;
        this.rankId = rankId;
    }

    @Generated(hash = 615387317)
    public Source() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsList() {
        return this.isList;
    }

    public void setIsList(Boolean isList) {
        this.isList = isList;
    }

    public int getRankId() {
        return this.rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }
}
