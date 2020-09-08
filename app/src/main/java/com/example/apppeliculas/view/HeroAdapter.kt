package com.example.apppeliculas.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.apppeliculas.R
import com.example.apppeliculas.model.Hero
import com.example.apppeliculas.model.db.HeroMini
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*
//Parte del callback el notifier
class HeroAdapter(private var heroDataset: MutableList<HeroMini>/*val notifier: NotifyClick*/) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view)
    }
    val heroSelected = MutableLiveData<HeroMini>()

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        Log.d("Adapter", "${heroDataset.get(position)}")
        holder.textTitle.text = heroDataset.get(position).name
        /*holder.textBiography.text = heroDataset.get(position).biography*/

        Picasso.get()
            .load(heroDataset.get(position).images_sm)
            .into(holder.imageHero);
        holder.buttonHero.setOnClickListener{
            Log.d("ViewHolder", "${heroDataset.get(position)}")
            //Parte del callback
            //notifier.notifyClick(heroDataset.get(position))
            heroSelected.value = heroDataset.get(position)


        }
    }

    override fun getItemCount(): Int {
        return heroDataset.size
    }



    fun updateItems(it: List<HeroMini>) {
        heroDataset.clear()
        heroDataset.addAll(it)
        notifyDataSetChanged()
    }

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView.textViewTitle
        var imageHero = itemView.imageView
        var buttonHero = itemView.button
        /*var textBiography = itemView.textViewBiography*/
    }
}
