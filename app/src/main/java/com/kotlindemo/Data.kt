package com.kotlindemo

import android.util.Log

/**
 * Created by chetan on 29/5/17.
 */
open class Data {
    var id = 0
    var name = ""

    constructor(){

    }
    constructor(id: Int, name: String){
        this.id = id
        this.name = name
//        Log.e("data","id:$id and name:$name")
    }



}