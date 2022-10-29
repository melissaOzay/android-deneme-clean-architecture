package com.example.foodmenu.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodmenu.data.entities.MenuData
import com.example.foodmenu.domain.repository.MenuInterface
import com.example.foodmenu.domain.usecase.MenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(val menuUseCase: MenuUseCase) : ViewModel() {

    val MenuInfo = MutableLiveData<List<MenuData>>()
    val fail = MutableLiveData<String>()
    fun loadData() {
        menuUseCase.loadData(object : MenuInterface {
            override fun success(userList: List<MenuData>) {
                MenuInfo.postValue(userList)
            }

            override fun fail(message: String) {
                fail.postValue(message)
            }

        })
    }

}









