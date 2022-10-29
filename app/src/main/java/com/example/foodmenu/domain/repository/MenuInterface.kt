package com.example.foodmenu.domain.repository

import com.example.foodmenu.data.entities.MenuData

interface MenuInterface {
    fun success(userList: List<MenuData>)
    fun fail(message: String)
}