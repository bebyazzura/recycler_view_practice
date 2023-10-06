package com.bebyaww.recycler_view_practice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bebyaww.recycler_view_practice.databinding.ItemRowBinding


class ListHeroAdapter(
    private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){
    class ListViewHolder(var binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)

        try {
            val nulString: String? = null
            nulString!!.length //akan memunculkan NPE (Null Pointer Exception)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.binding.ivHeroes.setImageResource(photo)
        holder.binding.tvTitle.text = name
        holder.binding.tvDescription.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(
                holder.itemView.context,
                "You click this!" + listHero[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}