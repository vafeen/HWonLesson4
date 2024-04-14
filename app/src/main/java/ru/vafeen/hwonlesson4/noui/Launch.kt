package ru.vafeen.hwonlesson4.noui

import androidx.annotation.DrawableRes

data class Launch(
    val name: String,
    val model: String,
    val dateStart: String,
    @DrawableRes val image: Int
)