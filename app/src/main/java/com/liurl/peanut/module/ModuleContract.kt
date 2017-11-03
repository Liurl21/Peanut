package com.liurl.peanut.module

import com.liurl.peanut.base.BasePresenter
import com.liurl.peanut.base.BaseView
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */
interface ModuleContract {
    interface View: BaseView<Presenter> {
        fun initModule(entity: TextEntity)
    }

    interface Presenter: BasePresenter {
        fun loadData(mParam: String)
        fun update(entity: TextEntity)
    }
}