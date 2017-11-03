package com.liurl.peanut.module.options

import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.module.text.TextModuleContract
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class OptionsPresenter(
        private var mModel: OptionsModelImpl,
        private var mView: OptionsModuleContract.View
): OptionsModuleContract.Presenter {
    init {
        mView.presenter = this
    }

    override fun start() {
    }

    override fun update(entity: OptionsEntity) {

    }

    override fun loadData(mParam: String) {
        mModel.analyseData(mParam, object : LoadDataCallback<OptionsEntity> {
            override fun onDataLoaded(data: OptionsEntity) {
                mView.initModule(data)
            }

            override fun onDataNotAvailable(e: Throwable) {
            }
        })
    }
}