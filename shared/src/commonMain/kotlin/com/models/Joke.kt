package com.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Joke(
    @SerialName("error") val error: Boolean,
    @SerialName("category") val category: String,
    @SerialName("type") val type: String,
    @SerialName("setup") val setup: String? = null,
    @SerialName("delivery") val delivery: String? = null,
    @SerialName("joke") val joke: String? = null,
    @SerialName("flags") val flags: JokeFlags,
    @SerialName("id") val id: Int,
    @SerialName("safe") val safe: Boolean,
    @SerialName("lang") val lang: String,
)
@Serializable
data class JokeFlags(
    @SerialName("nsfw") val nsfw: Boolean,
    @SerialName("religious") val religious: Boolean,
    @SerialName("political") val political: Boolean,
    @SerialName("racist") val racist: Boolean,
    @SerialName("sexist") val sexist: Boolean,
    @SerialName("explicit") val explicit: Boolean
)