package ru.vafeen.hwonlesson4


import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.vafeen.hwonlesson4.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson4.databinding.LaunchBinding
import ru.vafeen.hwonlesson4.ui.launch.Launch
import ru.vafeen.hwonlesson4.noui.logExecutor
import ru.vafeen.hwonlesson4.ui.TabRowNaming
import ru.vafeen.hwonlesson4.ui.fragments.LaunchFragment
import ru.vafeen.hwonlesson4.ui.launch.LaunchPutGet


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var bindingLaunchBinding: LaunchBinding

    private val launchFragment = LaunchFragment().apply {
        arguments = Bundle().apply {
            putSerializable(
                LaunchPutGet.LaunchKey.key, Launch(
                    name = "Artur",
                    model = "Vafin",
                    dateStart = "today",
                    image = R.drawable.falcon09
                )
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)

        bindingLaunchBinding = LaunchBinding.inflate(layoutInflater)

        setContentView(bindingMainActivity.root)



        replaceFragmentOn(launchFragment)


        content()
    }

    private fun switchTabs(current: TabRowNaming) {
        logExecutor(mes = "switchColors")

        when (current) {
            TabRowNaming.Upcoming -> {
                bindingMainActivity.apply {
                    upcoming.setTextColor(resources.getColor(R.color.red))

                    launchers.setTextColor(resources.getColor(R.color.black))

                    rockets.setTextColor(resources.getColor(R.color.black))

                }
                bindingLaunchBinding.changeVisibility(View.VISIBLE)


            }


            TabRowNaming.Launchers -> {

                bindingMainActivity.upcoming.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.launchers.setTextColor(resources.getColor(R.color.red))
                bindingMainActivity.rockets.setTextColor(resources.getColor(R.color.black))

                bindingLaunchBinding.changeVisibility(View.GONE)

            }

            TabRowNaming.Rockets -> {
                bindingMainActivity.upcoming.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.launchers.setTextColor(resources.getColor(R.color.black))
                bindingMainActivity.rockets.setTextColor(resources.getColor(R.color.red))

                bindingLaunchBinding.changeVisibility(View.GONE)

            }


        }
    }

    private fun LaunchBinding.changeVisibility(visibility: Int) {
        apply {
            icon.visibility = visibility

            name.visibility = visibility

            start.visibility = visibility

            launch.visibility = visibility
        }
    }

    private fun replaceFragmentOn(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()


    }


    private fun content() {

//        val listView = findViewById<View>(R.id.myListView) as ListView
//        val adapter = MyAdapter(this, myData)
//        listView.setAdapter(adapter)
        switchTabs(TabRowNaming.Upcoming)

        bindingMainActivity.apply {
            upcoming.setOnClickListener {
                switchTabs(TabRowNaming.Upcoming)
            }

            launchers.setOnClickListener {
                switchTabs(TabRowNaming.Launchers)
            }

            rockets.setOnClickListener {
                switchTabs(TabRowNaming.Rockets)

            }
        }

    }


}