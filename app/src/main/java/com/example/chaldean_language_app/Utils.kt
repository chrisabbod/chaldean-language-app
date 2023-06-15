package com.example.chaldean_language_app

import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

object Utils {

    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun parseJSON(jsonString: String?): Lesson {
        return Gson().fromJson(jsonString, Lesson::class.java)
    }
}