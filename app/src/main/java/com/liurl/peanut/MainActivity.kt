package com.liurl.peanut

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.liurl.peanut.entity.Source
import com.liurl.peanut.entity.TextBean
import com.liurl.peanut.gen.SourceDao
import com.liurl.peanut.utils.DaoUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var sourceDao: SourceDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        sourceDao = DaoUtil.getDaoSession()!!.sourceDao
        fab.setOnClickListener {
            sourceDao.deleteAll()
            insert()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private fun insert() {
        var source = Source()
        source.isList = true
        source.key = "title01"
        source.rankId = 1
        source.type = "single_text"
        source.uuid = "1233211"
        source.isShow = true

        var data = TextBean()
        data.value = et_title.text.toString()
        data.title = "标题"
        data.hint = "问题简单描述"
        source.data = data.toString()

        var source2 = Source()
        source2.isList = true
        source2.key = "title02"
        source2.rankId = 2
        source2.type = "single_text"
        source2.uuid = "1233211"
        source2.isShow = true

        var data2 = TextBean()
        data2.value = et_content.text.toString()
        data2.title = "问题修改及改进意见"
        data2.hint = "请描述您遇到的问题"
        source2.data = data2.toString()

        sourceDao.insert(source)
        sourceDao.insert(source2)

        query()
    }

    private fun query() {
        if (null != sourceDao) {
            Log.i("collect", sourceDao.queryBuilder().where(SourceDao.Properties.Uuid.eq("1233211")).list()[0].uuid.toString())
        }

        generateJson("1233211")
    }

    private fun generateJson(uuid: String) {
        var sourceList = sourceDao.queryBuilder().where(SourceDao.Properties.Uuid.eq(uuid)).list()
        var dataArray = JSONArray()
        for (source in sourceList) {
            dataArray.put(source.data)
        }

        var dataJson = JSONObject()
        dataJson.put("data", dataArray)

        data_text.text = dataJson.toString().replace("\\", "")
    }
}
