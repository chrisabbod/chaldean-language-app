package com.example.chaldean_language_app.data.utils

import android.content.Context
import com.example.chaldean_language_app.data.model.LessonData
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

object Utils {

    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        val json: String?
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun parseJSON(jsonString: String?): LessonData {
        return Gson().fromJson(jsonString, LessonData::class.java)
    }
}