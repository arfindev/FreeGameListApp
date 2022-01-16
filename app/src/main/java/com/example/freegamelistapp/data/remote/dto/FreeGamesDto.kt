package com.example.freegamelistapp.data.remote.dto


import com.example.freegamelistapp.data.remote.FreeGamesApi
import com.example.freegamelistapp.domain.model.FreeGames
import com.google.gson.annotations.SerializedName

data class FreeGamesDto(
    @SerializedName("developer")
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String,
    @SerializedName("game_url")
    val gameUrl: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
)

fun FreeGamesDto.toFreeGames(): FreeGames {
    return FreeGames(
        id = id,
        thumbnail = thumbnail,
        title = title
    )
}