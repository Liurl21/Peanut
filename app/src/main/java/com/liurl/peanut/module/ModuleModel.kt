package com.liurl.peanut.module

import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/2
 * @describe
 */
interface ModuleModel<T> {
    fun analyseData(params: String, callback: LoadDataCallback<T>)
    fun insertDb(entity: TextEntity)
}