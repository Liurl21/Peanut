package com.liurl.peanut.collection

import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.collection.entity.CollectionEntity

/**
 * ****************************************************
 * @author jameswong
 * created on: 17/10/25 下午5:08
 * e-mail: PassionateWsj@outlook.com
 * name:
 * desc:
 * ****************************************************
 */
class CollectionPresenter(
        private val mModel: CollectionModelImpl,
        private val mView: CollectionContract.View
) : CollectionContract.Presenter {
    init {
        mView.presenter = this
    }

    override fun start() {
    }

    override fun loadData(url: String) {
        mModel.getData(url,object : LoadDataCallback<CollectionEntity> {
            override fun onDataLoaded(entity: CollectionEntity) {
                mView.initRootView(entity)
            }

            override fun onDataNotAvailable(e: Throwable) {
            }
        })
    }
}