package com.example.foodmenu

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoodMenuApplication  : Application(){
    //Bu olmazsa dagger hilt hata verir.
}