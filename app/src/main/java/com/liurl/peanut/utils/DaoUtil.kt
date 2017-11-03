package com.liurl.peanut.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.liurl.peanut.gen.DaoMaster
import com.liurl.peanut.gen.DaoSession
import com.liurl.peanut.gen.SourceDao

/**
 * @author liuruilin
 * @data 2017/10/27
 * @describe
 */
object DaoUtil {
    private var daoSession: DaoSession? = null
    private var database: SQLiteDatabase? = null

    /**
     * 初始化数据库
     * 建议放在Application中执行
     */
    fun initDataBase(context: Context) {
        //通过DaoMaster的内部类DevOpenHelper，可得到一个SQLiteOpenHelper对象。
        val devOpenHelper = DaoMaster.DevOpenHelper(context, "collection.db", null) //数据库名称
        database = devOpenHelper.writableDatabase
        val daoMaster = DaoMaster(database)
        daoSession = daoMaster.newSession()
    }

    fun getDaoSession(): DaoSession? {
        return daoSession
    }

    fun getDatabase(): SQLiteDatabase? {
        return database
    }

    fun getSourceDao(): SourceDao {
        return daoSession!!.sourceDao
    }


//    fun getCompanyDao(): CompanyDao {
//        return daoSession!!.getCompanyDao()
//    }
//
//    fun getCompanyQuery(): QueryBuilder<Company> {
//        return daoSession!!.getCompanyDao().queryBuilder()
//    }
//
//    fun getEmployeeDao(): EmployeeDao {
//        return daoSession!!.getEmployeeDao()
//    }
//
//    fun getEmployeeQuery(): QueryBuilder<Employee> {
//        return daoSession!!.getEmployeeDao().queryBuilder()
//    }

}