package com.kroslinks.itunealbumsearch.utility

import android.content.Context
import java.io.IOException

class Util {

    companion object {
        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }

        fun splitDate(inputDate:String?): String? {
            return inputDate!!.split("T")[0]!!
        }
    }
}