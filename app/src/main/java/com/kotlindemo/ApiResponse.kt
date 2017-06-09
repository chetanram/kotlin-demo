package com.kotlindemo

/**
 * Created by chetan on 29/5/17.
 */
interface ApiResponse {
    fun onSuccess(response: String, params: HashMap<String, String>)
    fun onError(response: String, params: HashMap<String, String>)
}