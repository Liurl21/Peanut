package com.liurl.peanut.collection

import android.content.Context
import android.util.Log
import com.alibaba.fastjson.JSONReader
import com.liurl.peanut.PeanutApplication.globalContext
import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.collection.entity.CollectionEntity
import com.liurl.peanut.collection.entity.Content
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.*
import java.util.ArrayList

/**
 * @author liuruilin
 * @data 2017/10/31
 * @describe
 */
class CollectionModelImpl: CollectionModel<CollectionEntity> {
    companion object {
        private val TAG = CollectionModelImpl::class.java.simpleName

        private var INSTANCE: CollectionModelImpl? = null
        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(): CollectionModelImpl {
            return INSTANCE ?: CollectionModelImpl()
                    .apply { INSTANCE = this }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun getData(url: String, callback: LoadDataCallback<CollectionEntity>) {
        Observable.just("")
                .subscribeOn(Schedulers.io())
                .map {
                    val response: String?
                    response = getJsonData(globalContext)
                    
                    val stringReader = StringReader(response)
                    val reader = JSONReader(stringReader)
//                    reader.startObject()
                    reader.startObject()
                    val entity = CollectionEntity()
                    entity.data = ArrayList()
                    Log.i(TAG, "analysisDataReaderTime2:")

                    while (reader.hasNext()) {
                        val key = reader.readString()
                        when (key) {
                            "bannerName" -> {
                                entity.name = reader.readObject().toString()
                                Log.i(TAG, "name:")
                            }

                            "parts" -> {
                                Log.i(TAG, "dataStart:")
                                reader.startArray()

                                while (reader.hasNext()) {
                                    reader.startObject()
                                    val data = CollectionEntity.PageData()
                                    while (reader.hasNext()) {
                                        val dataKey = reader.readString()
                                        when (dataKey) {
                                            "content" -> data.content = reader.readObject().toString()

                                            "title" -> data.title = reader.readObject().toString()
                                        }
                                    }
                                    reader.endObject()
                                    entity.data!!.add(data)
                                }
                                reader.endArray()
                                Log.i(TAG, "dataEnd:")
                            }
                        }
                    }
                    reader.endObject()
                    Log.i(TAG, "analysisDataEndTime:")
                    entity
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<CollectionEntity>() {
                    override fun onCompleted() {
                    }

                    override fun onNext(t: CollectionEntity?) {
//                        t ?:callback.onDataLoaded(t)
                        t?.let { callback.onDataLoaded(it) }

                    }

                    override fun onError(e: Throwable?) {
                        callback.onDataNotAvailable(e!!)
                    }

                })
    }

    /**
     * 加载 模板一 本地 json 测试数据的方法
     * @param context
     * @return
     */
    private fun getJsonData(context: Context): String {
        var inputStream: InputStream? = null
        var reader: BufferedReader? = null
        var sb: StringBuilder? = null
        try {
            inputStream = context.resources.assets.open("collection.json")
            //            is = context.getResources().getAssets().open("temple-v1.json");
            reader = BufferedReader(InputStreamReader(inputStream!!))
            sb = StringBuilder()
            var line: String?
            while (true) {
                line = reader.readLine()
                if (line != null) sb.append(line + "\n") else break

            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                if (reader != null) {
                    reader.close()
                }
                if (inputStream != null) {
                    inputStream.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return sb!!.toString()
    }
}