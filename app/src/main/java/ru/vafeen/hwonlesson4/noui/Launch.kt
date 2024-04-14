package ru.vafeen.hwonlesson4.noui

import androidx.annotation.LayoutRes

data class Launch(
    val name: String,
    val model: String,
    val dateStart: String,
    @LayoutRes val image: Int
)