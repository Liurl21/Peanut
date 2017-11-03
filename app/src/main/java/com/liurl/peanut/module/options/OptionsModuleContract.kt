package com.liurl.peanut.module.options

import com.liurl.peanut.base.BasePresenter
import com.liurl.peanut.base.BaseView

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
interface OptionsModuleContract {
    interface View: BaseView<Presenter> {
        fun initModule(entity: OptionsEntity)
    }

    interface Presenter: BasePresenter {
        fun loadData(mParam: String)
        fun update(entity: OptionsEntity)
    }
}