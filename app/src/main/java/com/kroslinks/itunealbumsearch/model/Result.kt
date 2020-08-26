package com.kroslinks.itunealbumsearch.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("artistId")
    val artistId: Int,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artistViewUrl")
    val artistViewUrl: String,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String,
    @SerializedName("artworkUrl30")
    val artworkUrl30: String,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String,
    @SerializedName("collectionArtistId")
    val collectionArtistId: Int,
    @SerializedName("collectionArtistName")
    val collectionArtistName: String,
    @SerializedName("collectionArtistViewUrl")
    val collectionArtistViewUrl: String,
    @SerializedName("collectionCensoredName")
    val collectionCensoredName: String,
    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String,
    @SerializedName("collectionHdPrice")
    val collectionHdPrice: Double,
    @SerializedName("collectionId")
    val collectionId: Int,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("collectionPrice")
    val collectionPrice: Double,
    @SerializedName("collectionViewUrl")
    val collectionViewUrl: String,
    @SerializedName("contentAdvisoryRating")
    val contentAdvisoryRating: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("discCount")
    val discCount: Int,
    @SerializedName("discNumber")
    val discNumber: Int,
    @SerializedName("hasITunesExtras")
    val hasITunesExtras: Boolean,
    @SerializedName("isStreamable")
    val isStreamable: Boolean,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("previewUrl")
    val previewUrl: String,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("trackCensoredName")
    val trackCensoredName: String,
    @SerializedName("trackCount")
    val trackCount: Int,
    @SerializedName("trackExplicitness")
    val trackExplicitness: String,
    @SerializedName("trackHdPrice")
    val trackHdPrice: Double,
    @SerializedName("trackHdRentalPrice")
    val trackHdRentalPrice: Double,
    @SerializedName("trackId")
    val trackId: Int,
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("trackNumber")
    val trackNumber: Int,
    @SerializedName("trackPrice")
    val trackPrice: Double,
    @SerializedName("trackRentalPrice")
    val trackRentalPrice: Double,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String,
    @SerializedName("wrapperType")
    val wrapperType: String,
    var isSelected: Boolean = false
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readInt(),
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readDouble(),
        source.readInt(),
        source.readString() ?: "",
        source.readDouble() ?: 0.0,
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readInt(),
        source.readInt(),
        1 == source.readInt(),
        1 == source.readInt(),
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readString() ?: "",
        source.readInt(),
        source.readString() ?: "",
        source.readDouble() ?: 0.0,
        source.readDouble() ?: 0.0,
        source.readInt(),
        source.readString() ?: "",
        source.readInt(),
        source.readDouble(),
        source.readDouble(),
        source.readInt(),
        source.readString() ?: "",
        source.readString() ?: "",
        1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(artistId)
        writeString(artistName)
        writeString(artistViewUrl)
        writeString(artworkUrl100)
        writeString(artworkUrl30)
        writeString(artworkUrl60)
        writeInt(collectionArtistId)
        writeString(collectionArtistName)
        writeString(collectionArtistViewUrl)
        writeString(collectionCensoredName)
        writeString(collectionExplicitness)
        writeDouble(collectionHdPrice)
        writeInt(collectionId)
        writeString(collectionName)
        writeDouble(collectionPrice)
        writeString(collectionViewUrl)
        writeString(contentAdvisoryRating)
        writeString(country)
        writeString(currency)
        writeInt(discCount)
        writeInt(discNumber)
        writeInt((if (hasITunesExtras) 1 else 0))
        writeInt((if (isStreamable) 1 else 0))
        writeString(kind)
        writeString(longDescription)
        writeString(previewUrl)
        writeString(primaryGenreName)
        writeString(releaseDate)
        writeString(shortDescription)
        writeString(trackCensoredName)
        writeInt(trackCount)
        writeString(trackExplicitness)
        writeDouble(trackHdPrice)
        writeDouble(trackHdRentalPrice)
        writeInt(trackId)
        writeString(trackName)
        writeInt(trackNumber)
        writeDouble(trackPrice)
        writeDouble(trackRentalPrice)
        writeInt(trackTimeMillis)
        writeString(trackViewUrl)
        writeString(wrapperType)
        writeInt((if (isSelected) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Result> = object : Parcelable.Creator<Result> {
            override fun createFromParcel(source: Parcel): Result = Result(source)
            override fun newArray(size: Int): Array<Result?> = arrayOfNulls(size)
        }
    }
}