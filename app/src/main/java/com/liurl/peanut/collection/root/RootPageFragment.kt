package com.liurl.peanut.collection.root

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.liurl.peanut.R
import com.liurl.peanut.base.BaseWidgetFragment
import com.liurl.peanut.collection.entity.RootPageRequestResult
import com.liurl.peanut.constant.Params.ARG_PARAM
import com.liurl.peanut.constant.Params.SU_ROOT_ID
import com.liurl.peanut.module.image.ImageFragment
import com.liurl.peanut.module.image.ImageModelImpl
import com.liurl.peanut.module.image.ImagePresenter
import com.liurl.peanut.module.options.DropOptionsFragment
import com.liurl.peanut.module.options.OptionsModelImpl
import com.liurl.peanut.module.options.OptionsPresenter
import com.liurl.peanut.module.text.MultiTextFragment
import com.liurl.peanut.module.text.TextModelImpl
import com.liurl.peanut.module.text.SingleTextFragment
import com.liurl.peanut.module.text.TextPresenter
import kotlinx.android.synthetic.main.fragment_root.*
import java.util.*

/**
 * @author liuruilin
 * @data 2017/11/1
 * @describe
 */
class RootPageFragment : BaseWidgetFragment(), RootPageContract.View {
    private val TAG = "root_page"

    /** 最上层跟跟标签ID */
    private var suRootID: Int = 0

    /** 单个页签的数据 */
    private lateinit var mParam: String

    private var rootView: View? = null
    private var fm: FragmentManager? = null

    override lateinit var presenter: RootPageContract.Presenter

    companion object {
        fun newInstance(suRootID: Int, param: String): RootPageFragment {
            val fragment = RootPageFragment()
            val args = Bundle()
            args.putInt(SU_ROOT_ID, suRootID)
            args.putString(ARG_PARAM, param)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            suRootID = arguments!!.getInt(SU_ROOT_ID)
            mParam = arguments!!.getString(ARG_PARAM)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fm = fragmentManager
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_root, container, false)
            presenter.loadData(mParam)
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        RootPageModelImpl.destroyInstance()
    }

    /**
     * 插入组件模块
     */
    override fun insertModule(result: RootPageRequestResult) {
        val random = Random()
        for (i in 0 until result.datas.size) {
            var fragment: Fragment? = null
            val entity = result.datas[i]
            when (entity.type) {
                "single_text" -> {
                    fragment = SingleTextFragment.newInstance(entity.data)
                    TextPresenter(TextModelImpl.getInstance(), fragment)
                }

                "multi_text" -> {
                    fragment = MultiTextFragment.newInstance(entity.data)
                    TextPresenter(TextModelImpl.getInstance(), fragment)
                }

                "drop_options" -> {
                    fragment = DropOptionsFragment.newInstance(entity.data)
                    OptionsPresenter(OptionsModelImpl.getInstance(), fragment)
                }

                "upload_images" -> {
                    fragment = ImageFragment.newInstance(entity.data)
                    ImagePresenter(ImageModelImpl.getInstance(), fragment)
                }

                else -> Log.i(TAG, entity.type + ">>>>>> is unknown module!")
            }

            if (fragment != null) {
                val layout = FrameLayout(ctx)
                val params = AppBarLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                layout.layoutParams = params
                val id = random.nextInt(Integer.MAX_VALUE)
                layout.id = id
                ll_root_container.addView(layout)
                val ft = fm!!.beginTransaction()
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ft.replace(layout.id, fragment)
                ft.commitNow()
            }
        }
    }
}