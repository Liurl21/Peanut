package com.liurl.peanut.module.image

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liurl.peanut.R
import com.liurl.peanut.base.BaseWidgetFragment
import com.liurl.peanut.constant.Params
import com.liurl.peanut.constant.Params.REQUEST_CODE_CHOOSE
import kotlinx.android.synthetic.main.module_image.*

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class ImageFragment: BaseWidgetFragment(), ImageModuleContract.View, ImageDisplayAdapter.ImageItemClickListener {
    override lateinit var presenter: ImageModuleContract.Presenter
    lateinit var param: String
    lateinit var rootView: View
    lateinit var datas: ImageEntity
    lateinit var adapter: ImageDisplayAdapter
    var mSelected: List<Uri>? = null

    companion object {
        fun newInstance(param: String?): ImageFragment {
            val fragment = ImageFragment()
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
            rootView = inflater.inflate(R.layout.module_image, container, false)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(act)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_image_display.layoutManager = linearLayoutManager
    }

    override fun initModule(entity: ImageEntity) {
        datas = entity
        rv_image_display.adapter = ImageDisplayAdapter(act!!, this, entity.limit)
    }

    override fun addImage(maxNum: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteImage(pos: Int) {
        adapter.deleteImageWithPos(pos)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
//            mSelected = Matisse.obtainResult(data)
            adapter.setData(mSelected)
        }
    }
}