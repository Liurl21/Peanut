package com.liurl.peanut.module.image

import com.liurl.peanut.base.BaseWidgetFragment

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class ImageFragment: BaseWidgetFragment(), ImageModuleContract.View {
    override lateinit var presenter: ImageModuleContract.Presenter

    override fun initModule(entity: ImageEntity) {

    }
}