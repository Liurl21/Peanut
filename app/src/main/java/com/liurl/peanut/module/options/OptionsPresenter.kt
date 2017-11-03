package com.liurl.peanut.module.options

import com.liurl.peanut.module.text.TextModuleContract
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class OptionsPresenter(
        private var mModel: OptionsModelImpl,
        private var mView: TextModuleContract.View
): TextModuleContract.Presenter {
    init {
        mView.presenter = this
    }

    override fun start() {
    }

    override fun update(entity: TextEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadData(mParam: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}