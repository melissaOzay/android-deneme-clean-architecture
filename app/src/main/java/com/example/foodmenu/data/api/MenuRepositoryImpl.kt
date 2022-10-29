package com.example.foodmenu.data.api

import com.example.foodmenu.data.entities.MenuData
import com.example.foodmenu.data.repository.MenuRepository
import com.example.foodmenu.domain.repository.MenuInterface
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

class MenuRepositoryImpl @Inject constructor(private val apiService: RestApi): MenuRepository {

    override fun loadData(menuInterface: MenuInterface) {
        apiService.getUser().enqueue(object :Callback<List<MenuData>>{
            override fun onResponse(
                call: Call<List<MenuData>>,
                response: Response<List<MenuData>>
            ) {
                if (response.isSuccessful) {
                    menuInterface.success(response.body()!!)
                }

            }

            override fun onFailure(call: Call<List<MenuData>>, t: Throwable) {
                menuInterface.fail(t.localizedMessage!!)
            }

        })
    }
}