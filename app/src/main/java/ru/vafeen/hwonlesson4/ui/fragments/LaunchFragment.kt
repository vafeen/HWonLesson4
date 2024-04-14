package ru.vafeen.hwonlesson4.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vafeen.hwonlesson4.R
import ru.vafeen.hwonlesson4.databinding.LaunchBinding


class LaunchFragment : Fragment(R.layout.launch) {

    lateinit var binding: LaunchBinding
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LaunchBinding.inflate(layoutInflater)

        return inflater.inflate(R.layout.launch, container, false)
    }

    fun setContent(){

    }
}