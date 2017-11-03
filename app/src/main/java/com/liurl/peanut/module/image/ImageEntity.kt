package com.liurl.peanut.module.image

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class ImageEntity {
    /**
     * title : 页面截图(最多3张)
     * sub_title :
     * hint :
     * limit : 3
     * value : ["",""]
     */
    var title: String = ""
    var sub_title: String = ""
    var hint: String = ""
    var limit: Int = 0
    var value: List<String>? = null
}