package com.liurl.peanut.module.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liurl.peanut.R
import com.liurl.peanut.base.BaseWidgetFragment
import com.liurl.peanut.constant.Params
import kotlinx.android.synthetic.main.item_drop_options.*

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class DropOptionsFragment:BaseWidgetFragment(), OptionsModuleContract.View {
    override lateinit var presenter: OptionsModuleContract.Presenter
    private lateinit var datas: OptionsEntity
    private lateinit var param: String
    private var rootView: View? = null

    companion object {
        fun newInstance(param: String?): DropOptionsFragment {
            val fragment = DropOptionsFragment()
            val args = Bundle()
            args.putString(Params.ARG_PARAM, param)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            param = arguments!!.getString(Params.ARG_PARAM)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.item_drop_options, container, false)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadData(param)
    }

    override fun onDestroy() {
        super.onDestroy()
        OptionsModelImpl.destroyInstance()
    }

    override fun initModule(entity: OptionsEntity) {
        datas = entity
        if (entity.title.isEmpty()) tv_drop_options_title.visibility = View.GONE else tv_drop_options_title.text = entity.title
        if (entity.value.isEmpty()) tv_drop_options_value.text = "" else tv_drop_options_value.text = entity.value
    }
}