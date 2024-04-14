package ru.vafeen.hwonlesson4


import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson4.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson4.databinding.LaunchBinding
import ru.vafeen.hwonlesson4.noui.logExecutor
import ru.vafeen.hwonlesson4.ui.TabRowNaming
import ru.vafeen.hwonlesson4.ui.UpComingItem
import ru.vafeen.hwonlesson4.ui.fragments.UpComingItemFragment
import ru.vafeen.hwonlesson4.ui.fragments.UpComingLaunchFragment
import ru.vafeen.hwonlesson4.ui.launch.Launch
import ru.vafeen.hwonlesson4.ui.launch.LaunchPutGet


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var bindingLaunchBinding: LaunchBinding


    private val ids = listOf(
        R.id.upComingFragmentLaunchDate,
        R.id.upComingFragmentLaunchSite,
        R.id.upComingFragmentCountDown
    )

    private val upComingItems = listOf(
        UpComingItem(
            title = "LAUNCH DATE",
            text = "Thu Oct 17 5:30:00 2019"
        ),
        UpComingItem(
            title = "LAUNCH SITE",
            text = "Cape Canaveral Air Force Station Space \nLaunch Complex 40"
        ),
        UpComingItem(
            title = "COUNT DOWN",
            "5 Hrs 30 mins more...",
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)

        bindingLaunchBinding = LaunchBinding.inflate(layoutInflater)

        setContentView(bindingMainActivity.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.upComingFragmentLaunch, UpComingLaunchFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(
                        LaunchPutGet.LaunchKey.key,
                        Launch(
                            name = "Artur",
                            model = "Vafin",
                            dateStart = "today",
                            image = R.drawable.falcon09
                        )
                    )
                }
            })
            .commit()



        supportFragmentManager.beginTransaction()
            .let {
                for (index in 0..ids.lastIndex) {
                    it.replace(ids[index], UpComingItemFragment().apply {
                        arguments = Bundle().apply {
                            putSerializable(
                                LaunchPutGet.ItemKey.key,
                                upComingItems[index]
                            )
                        }
                    })
                }
                it
            }.commit()

        content()
    }

    private fun switchTabs(current: TabRowNaming) {
//        logExecutor(mes = "switchColors")

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