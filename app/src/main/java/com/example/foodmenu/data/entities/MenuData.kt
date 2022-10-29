package com.example.foodmenu.data.entities

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class MenuData(@SerializedName("id") var id:String?,
                    @SerializedName("img") var img:String?,
                    @SerializedName("name") var name:String?,
                    @SerializedName("dsc") var dsc:String?,
                    @SerializedName("price") var price:Float,
                    @SerializedName("rate") var rate:Int,
                    @SerializedName("country") var country:String?
                   )
