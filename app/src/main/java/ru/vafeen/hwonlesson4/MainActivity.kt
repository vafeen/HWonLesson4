package ru.vafeen.hwonlesson4


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson4.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson4.noui.logExecutor
import ru.vafeen.hwonlesson4.ui.TabRowNaming


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.upcoming.setOnClickListener {
            switchColorsInTabs(TabRowNaming.Upcoming)
        }

        binding.launchers.setOnClickListener {
            switchColorsInTabs(TabRowNaming.Launchers)
        }

        binding.rockets.setOnClickListener {
            switchColorsInTabs(TabRowNaming.Rockets)

        }
        content()
    }

    private fun switchColorsInTabs(current: TabRowNaming) {
        logExecutor(mes = "switchColors")

        when (current) {
            TabRowNaming.Upcoming -> {
                binding.upcoming.setTextColor(resources.getColor(R.color.red))
                binding.launchers.setTextColor(resources.getColor(R.color.black))
                binding.rockets.setTextColor(resources.getColor(R.color.black))
            }

            TabRowNaming.Launchers -> {

                binding.upcoming.setTextColor(resources.getColor(R.color.black))
                binding.launchers.setTextColor(resources.getColor(R.color.red))
                binding.rockets.setTextColor(resources.getColor(R.color.black))

            }

            TabRowNaming.Rockets -> {
                binding.upcoming.setTextColor(resources.getColor(R.color.black))
                binding.launchers.setTextColor(resources.getColor(R.color.black))
                binding.rockets.setTextColor(resources.getColor(R.color.red))
            }


        }
    }

    private fun content() {

//        val listView = findViewById<View>(R.id.myListView) as ListView
//        val adapter = MyAdapter(this, myData)
//        listView.setAdapter(adapter)

        binding.apply {

        }

    }


}