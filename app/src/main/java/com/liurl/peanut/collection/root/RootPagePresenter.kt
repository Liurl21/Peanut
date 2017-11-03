package com.liurl.peanut.collection.root

import android.util.Log
import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.collection.entity.RootPageRequestResult

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */
class RootPagePresenter(
    private val mModel: RootPageModelImpl,
    private val mView: RootPageContract.View
): RootPageContract.Presenter {

    init {
        mView.presenter = this
    }

    override fun start() {
    }

    override fun loadData(mParam: String) {
        mModel.getData(mParam, object : LoadDataCallback<RootPageRequestResult> {
            override fun onDataLoaded(data: RootPageRequestResult) {
                mView.insertModule(data)
            }

            override fun onDataNotAvailable(e: Throwable) {
                Log.i("testlog", e.toString())
            }
        })
    }
}