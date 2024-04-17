package ru.vafeen.hwonlesson4.ui.fragments.rocketslist.rocket

import androidx.annotation.DrawableRes

data class Rocket(

    val name: String,

    val active: Boolean,

    @DrawableRes val image: Int
)