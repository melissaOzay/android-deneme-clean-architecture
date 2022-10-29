package com.example.foodmenu.domain.usecase

import com.example.foodmenu.data.entities.MenuData
import com.example.foodmenu.data.repository.MenuRepository
import com.example.foodmenu.domain.repository.MenuInterface
import javax.inject.Inject

class MenuUseCase  @Inject constructor(
    private val menuRepository: MenuRepository){
    fun loadData(menuInterface: MenuInterface) =
        menuRepository.loadData(menuInterface)


}