package ru.vafeen.hwonlesson4.ui.fragments.launcherslist.launch

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Launch(

    val name: String,

    val model: String,

    val dateStart: String,

    @DrawableRes val image: Int

) : Serializable {

}
