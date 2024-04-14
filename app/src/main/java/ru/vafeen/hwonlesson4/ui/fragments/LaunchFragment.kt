package ru.vafeen.hwonlesson4.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import ru.vafeen.hwonlesson4.R
import ru.vafeen.hwonlesson4.databinding.LaunchBinding
import ru.vafeen.hwonlesson4.noui.logExecutor
import ru.vafeen.hwonlesson4.ui.launch.Launch
import ru.vafeen.hwonlesson4.ui.launch.LaunchPutGet


class LaunchFragment : Fragment(R.layout.launch) {

    private lateinit var binding: LaunchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LaunchBinding.inflate(layoutInflater)

        val data = arguments?.getSerializable(LaunchPutGet.LaunchKey.key) as? Launch

        logExecutor(mes = "data = ${data}") // сюда приходят данные!!

        binding.apply {

            if (data != null) {
                name.text = data.name

                model.text = data.model

                start.text = data.dateStart

                icon.setImageResource(data.image)
            }
        }

        return inflater.inflate(R.layout.launch, container, false)
    }

}
