package com.liurl.peanut.module.options

/**
 * @author liuruilin
 * @data 2017/11/2
 * @describe
 */
class OptionsEntity {
    /**
     * title : 问题类型
     * sub_title : 选择你要反馈的问题类型
     * hint :
     * options : ["显示错误","数据错误","应用闪退"]
     * value : 显示错误
     */
    var element_type = ""
    var title: String = ""
    var sub_title: String = ""
    var hint: String = ""
    var value: String = ""
    var options: List<String>? = null
}