package com.liurl.peanut.collection

import com.liurl.peanut.collection.callback.LoadDataCallback

/**
 * @author liuruilin
 * @data 2017/10/31
 * @describe
 */
interface CollectionModel<out T> {
    fun getData(url: String, callback: LoadDataCallback<T>)
}