package com.liurl.peanut.collection

import com.liurl.peanut.base.BasePresenter
import com.liurl.peanut.base.BaseView
import com.liurl.peanut.collection.entity.CollectionEntity

/**
 * @author liuruilin
 * @data 2017/10/31
 * @describe
 */
interface CollectionContract {
    interface View: BaseView<Presenter> {
        fun initRootView(entity: CollectionEntity)
    }

    interface Presenter: BasePresenter {
        fun loadData(url: String)
    }
}