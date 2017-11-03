package com.liurl.peanut.base

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.liurl.peanut.PeanutApplication.globalContext

/**
 * @author liuruilin
 * @data 2017/10/31
 * @describe
 */
open class BaseWidgetFragment: Fragment() {
    var act: FragmentActivity? = activity
    var ctx: Context = globalContext
}