package com.kotlindemo

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.android.volley.VolleyError
import com.google.gson.Gson
import java.util.HashMap
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), ApiResponseListener {

    private var context: Context? = null
    private var apiController: ApiController? = null
    private var params: HashMap<String, String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        params = HashMap()
        params!!.put("data", "data")
        apiController = ApiController(context!!)
        apiController!!.actionCallWebService("http://54.235.114.63:8080/belice/events", params!!)


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val params = hashMapOf<String, String>()
        params.put("Chetan", "ram")
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", View.OnClickListener { Toast.makeText(this, "click", Toast.LENGTH_LONG).show() }).show()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", "data")
            startActivity(intent)
        }
        val s = ArrayList<Data>()
        s.add(Data(1, "Chetan"))
        s.add(Data(2, "Ram"))
        var str = Gson().toJson(s)
        Log.e("str", str)
        var lists = listOf<String>("1", "2", "3", "4", "5", "6")
        for (list in lists) {
            Log.i("list of ", list)
        }
        for (i in 0 until lists.size) {
            Log.d("i is", "" + i)
            for (i in lists.size - 1 downTo 0 step 1) {

                Log.d("i is", "" + i)
            }
        }
        var x:String = getDigits(11)
        Log.d("x",x)


    }

    fun getDigits(i: Int): String {
        if (i < 9) {
            return "0"+i
        } else {
            return ""+i
        }

    }

    public class Task : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String {
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
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
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    override fun onSuccessResponse(response: String, hashMap: HashMap<String, String>) {
    }

    override fun onErrorResponse(error: VolleyError, hashMap: HashMap<String, String>) {
    }

}
