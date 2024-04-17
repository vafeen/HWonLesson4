package ru.vafeen.hwonlesson4.ui.fragments.rocketslist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vafeen.hwonlesson4.R
import ru.vafeen.hwonlesson4.ui.rocket.Rocket

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.ViewHolder>() {

    var rockets: List<Rocket> = listOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rocketIcon: ImageView = itemView.findViewById(R.id.rocketicon)

        val rocketName: TextView = itemView.findViewById(R.id.rocketname)

        val rocketIsActive: Button = itemView.findViewById(R.id.rocketisactive)

        fun bind(rocket: Rocket) {
            rocketName.text = rocket.name
            if (rocket.active) {
                rocketIsActive.text = "Active"

                rocketIsActive.setBackgroundColor(Color.GREEN)
            } else {
                rocketIsActive.text = "Inavtive"

                rocketIsActive.setBackgroundColor(Color.RED)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rocket,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = rockets.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rockets[position])

        holder.rocketIcon.setImageResource(rockets[position].image)

    }
}