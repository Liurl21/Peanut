package com.liurl.peanut.module.options

import com.alibaba.fastjson.JSONObject
import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.module.ModuleModel
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class OptionsModelImpl: ModuleModel<OptionsEntity> {

    companion object {
        private var INSTANCE: OptionsModelImpl? = null
        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(): OptionsModelImpl {
            return INSTANCE ?: OptionsModelImpl()
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

    override fun analyseData(params: String, callback: LoadDataCallback<OptionsEntity>) {
        var data = JSONObject.parseObject(params, OptionsEntity::class.java)
        callback.onDataLoaded(data)
    }

    override fun insertDb(entity: TextEntity) {

    }
}