package com.example.foodmenu.data.repository

import com.example.foodmenu.domain.repository.MenuInterface

interface MenuRepository {
    fun loadData(userListInterface: MenuInterface)
}