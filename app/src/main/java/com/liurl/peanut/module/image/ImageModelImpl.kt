package com.liurl.peanut.module.image

import com.liurl.peanut.collection.callback.LoadDataCallback
import com.liurl.peanut.module.ModuleModel
import com.liurl.peanut.module.options.OptionsModelImpl
import com.liurl.peanut.module.text.TextEntity

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class ImageModelImpl: ModuleModel<ImageEntity> {

    companion object {
        private var INSTANCE: ImageModelImpl? = null
        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(): ImageModelImpl {
            return INSTANCE ?: ImageModelImpl()
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

    override fun analyseData(params: String, callback: LoadDataCallback<ImageEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertDb(entity: TextEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}