package com.example.foodmenu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmenu.R
import com.example.foodmenu.data.entities.MenuData
import com.bumptech.glide.Glide

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.CompanyViewHolder>() {
    private var menuData = arrayListOf<MenuData>()

    fun setData(menuData: ArrayList<MenuData>) {
        this.menuData = menuData
        menuData.reverse()
        notifyDataSetChanged()
    }
    class CompanyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img=view.findViewById<ImageView>(R.id.imageView)
        val name=view.findViewById<TextView>(R.id.tv_name)
        val dsc=view.findViewById<TextView>(R.id.tv_dsc)
        val country=view.findViewById<TextView>(R.id.tv_country)

        fun bindItems(item:MenuData){
            name.text=item.name
            dsc.text=item.dsc
            country.text=item.country

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeAdapter.CompanyViewHolder {
        val binding = LayoutInflater.from(parent.context)
        val view = binding.inflate(R.layout.home_item, parent, false)
        return CompanyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.CompanyViewHolder, position: Int) {
        holder.bindItems(menuData.get(position))
        Glide.with(holder.img)
            .load("https://ig-food-menus.herokuapp.com/")
            .circleCrop()
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return menuData.count()
    }
}