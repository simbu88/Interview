package com.kroslinks.itunealbumsearch.model


import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)