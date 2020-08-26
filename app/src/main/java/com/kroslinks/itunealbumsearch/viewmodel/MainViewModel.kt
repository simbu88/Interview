package com.kroslinks.itunealbumsearch.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kroslinks.itunealbumsearch.model.AlbumResponse
import com.kroslinks.itunealbumsearch.utility.Util

class MainViewModel(application: Application): AndroidViewModel(application) {

    var albumResponeMutableLiveData =MutableLiveData<AlbumResponse>()

    fun getAlbumList(): MutableLiveData<AlbumResponse> {

        val jsonFileString = Util.getJsonDataFromAsset(getApplication(), "album.json")
        val gson = Gson()
        val parseAlbumResponse = object : TypeToken<AlbumResponse>() {}.type
        var albumResponse: AlbumResponse = gson.fromJson(jsonFileString, parseAlbumResponse)
        albumResponeMutableLiveData.postValue(albumResponse)

        return albumResponeMutableLiveData
    }

}