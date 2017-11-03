package com.liurl.peanut.collection.root

import com.liurl.peanut.base.BasePresenter
import com.liurl.peanut.base.BaseView
import com.liurl.peanut.collection.entity.Content
import com.liurl.peanut.collection.entity.RootPageRequestResult

/**
 * ****************************************************
 * @author jameswong
 * created on: 17/10/24 下午3:03
 * e-mail: PassionateWsj@outlook.com
 * name:
 * desc:
 * ****************************************************
 */
interface RootPageContract {
    interface View : BaseView<Presenter> {
        // 展示数据
        fun insertModule(result: RootPageRequestResult)
    }

    interface Presenter : BasePresenter {
        // 加载数据
        fun loadData(mParam: String)
    }
}