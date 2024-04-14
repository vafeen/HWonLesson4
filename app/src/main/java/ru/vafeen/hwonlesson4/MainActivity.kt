package ru.vafeen.hwonlesson4


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson4.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson4.databinding.LaunchBinding
import ru.vafeen.hwonlesson4.noui.logExecutor
import ru.vafeen.hwonlesson4.ui.TabRowNaming


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var bindingLaunchBinding: LaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)

        bindingLaunchBinding = LaunchBinding.inflate(layoutInflater)



        setContentView(bindingMainActivity.root)

        content()
    }

    private fun switchColorsInTabs(current: TabRowNaming) {
        logExecutor(mes = "switchColors")

        when (current) {
            TabRowNaming.Upcoming -> {
                bindingMainActivity.upcoming.setTextColor(resources.getColor(R.color.red))
                bindingMainActivity.launchers.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.rockets.setTextColor(resources.getColor(R.color.black))
            }

            TabRowNaming.Launchers -> {

                bindingMainActivity.upcoming.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.launchers.setTextColor(resources.getColor(R.color.red))
                bindingMainActivity.rockets.setTextColor(resources.getColor(R.color.black))

            }

            TabRowNaming.Rockets -> {
                bindingMainActivity.upcoming.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.launchers.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.rockets.setTextColor(resources.getColor(R.color.red))
            }


        }
    }

    private fun content() {

//        val listView = findViewById<View>(R.id.myListView) as ListView
//        val adapter = MyAdapter(this, myData)
//        listView.setAdapter(adapter)

        bindingMainActivity.apply {
            upcoming.setOnClickListener {
                switchColorsInTabs(TabRowNaming.Upcoming)
            }

            launchers.setOnClickListener {
                switchColorsInTabs(TabRowNaming.Launchers)
            }

            rockets.setOnClickListener {
                switchColorsInTabs(TabRowNaming.Rockets)

            }
        }

    }


}