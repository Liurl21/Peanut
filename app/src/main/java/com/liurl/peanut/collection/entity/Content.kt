package com.liurl.peanut.collection.entity

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */

class Content {
    /**
     * type : single_text
     * key : test_01
     * is_show : 1
     * is_list : 1
     * is_filter : 0
     * is_must : 1
     * data : {"element_type":"","title":"问题反馈标题","sub_title":"","hint":"问题简单描述","value":""}
     */
    var type: String? = null
    var key: String? = null
    var is_show: Int = 0
    var is_list: Int = 0
    var is_filter: Int = 0
    var is_must: Int = 0
    var data: String? = null
}
