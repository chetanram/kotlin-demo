package com.kotlindemo

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.text.TextUtils
import android.util.Log


import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

import java.util.HashMap

/**
 * Created by agc-android on 18/1/17.
 */

class MyApplication : MultiDexApplication() {
    private var queue: RequestQueue? = null
    private var queueSuggestion: RequestQueue? = null

    private var context: Context? = null
    private val params: HashMap<String, String>? = null

    override fun onCreate() {
        super.onCreate()
        context = this
        instance = this


    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /*if(Common.httpclient==null)
            {
                Common.httpclient=new DefaultHttpClient();
                ClientConnectionManager mgr = Common.httpclient.getConnectionManager();

                HttpParams params = Common.httpclient.getParams();

                Common.httpclient = new DefaultHttpClient(new ThreadSafeClientConnManager(params,

                        mgr.getSchemeRegistry()), params);
                CookieStore cookieStore = new BasicCookieStore();
                Common.httpclient.setCookieStore( cookieStore );
            }
            HttpStack httpStack = new HttpClientStack( Common.httpclient );*/ val requestQueue: RequestQueue
        get() {


            if (queue == null) {
                queue = Volley.newRequestQueue(applicationContext)
            }

            return queue!!
        }

    /*if(Common.httpclientCalendar==null)
            {
                Common.httpclientCalendar=new DefaultHttpClient();
                ClientConnectionManager mgr = Common.httpclientCalendar.getConnectionManager();

                HttpParams params = Common.httpclientCalendar.getParams();

                Common.httpclientCalendar = new DefaultHttpClient(new ThreadSafeClientConnManager(params,

                        mgr.getSchemeRegistry()), params);
                CookieStore cookieStore = new BasicCookieStore();
                Common.httpclientCalendar.setCookieStore( cookieStore );
            }
            HttpStack httpStack = new HttpClientStack( Common.httpclientCalendar );*/ val requestQueueSuggestion: RequestQueue
        get() {


            if (queueSuggestion == null) {
                queueSuggestion = Volley.newRequestQueue(applicationContext)
            }

            return queueSuggestion!!
        }

    fun <T> addToRequestQueue(req: com.android.volley.Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue.add(req)
    }

    fun <T> addToRequestQueue(req: com.android.volley.Request<T>) {
        req.tag = TAG
        requestQueue.add(req)
    }

    fun <T> addToRequestQueueSuggestion(req: com.android.volley.Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueueSuggestion.add(req)
    }

    fun <T> addToRequestQueueSuggestion(req: com.android.volley.Request<T>) {
        req.tag = TAG
        requestQueueSuggestion.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        if (queue != null) {
            queue!!.cancelAll(tag)
        }
    }

    fun cancelPendingRequestsSuggestion(tag: Any) {
        if (queueSuggestion != null) {
            queueSuggestion!!.cancelAll(tag)
        }
    }

    fun stopQueue() {
        if (queue != null) {
            queue!!.stop()
        }
    }

    companion object {

        val TAG = MyApplication::class.java
                .simpleName
        @get:Synchronized var instance: MyApplication? = null
        fun getInstace(): MyApplication {
            return instance!!
        }


    }


}
