package com.example.rxjavawithretrofitandrecyclerview.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithretrofitandrecyclerview.R
import com.example.rxjavawithretrofitandrecyclerview.common.inflate
import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel
import kotlinx.android.synthetic.main.starwars_cardview.view.*

class StarWarsAdapter(private val starWarsModel: StarWarsModel): RecyclerView.Adapter<StarWarsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsViewHolder {
        val view: View = parent.inflate(R.layout.starwars_cardview, false)
        return StarWarsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return starWarsModel.results.size
    }

    override fun onBindViewHolder(holder: StarWarsViewHolder, position: Int) {

        holder.tvName.text = starWarsModel.results[position].name
        holder.tvHeight.text = String.format("%.2f", (starWarsModel.results[position].height)* 0.0328084) + " FT"
        holder.tvMass.text = starWarsModel.results[position].mass.toString() + " KG"
    }
}

class StarWarsViewHolder (view: View): RecyclerView.ViewHolder(view){

    val tvName = view.tv_name
    val tvHeight = view.tv_height
    val tvMass = view.tv_mass
}
