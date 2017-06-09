package com.kotlindemo

import android.content.Context
import android.util.Log


import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest

import java.util.HashMap

/**
 * Created by agc-android on 18/1/17.
 */

class ApiController {

    var apiResponseListener: ApiResponseListener? = null
    var context: Context? = null
    var stringRequest: StringRequest? = null

    public constructor(context: Context) {
        this.context = context
        this.apiResponseListener = context as ApiResponseListener

    }

    fun actionCallWebService(url: String, params: HashMap<String, String>) {
        stringRequest = object : StringRequest(Request.Method.POST, url,

                Response.Listener<String> { response ->

                    apiResponseListener!!.onSuccessResponse(response, params)
                    Log.e("multiple", "time")
                },
                Response.ErrorListener { error ->

                    apiResponseListener!!.onErrorResponse(error, params)

                }) {
            override fun getParams(): Map<String, String> {
                return params
            }
        }
        stringRequest!!.retryPolicy = DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        MyApplication.getInstace().addToRequestQueue(stringRequest!!)

    }


}
