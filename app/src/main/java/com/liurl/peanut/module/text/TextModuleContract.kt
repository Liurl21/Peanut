package com.liurl.peanut.module.text

import com.liurl.peanut.base.BasePresenter
import com.liurl.peanut.base.BaseView

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */
interface TextModuleContract {
    interface View: BaseView<Presenter> {
        fun initModule(entity: TextEntity)
    }

    interface Presenter: BasePresenter {
        fun loadData(mParam: String)
        fun update(entity: TextEntity)
    }
}