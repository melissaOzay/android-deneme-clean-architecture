package com.example.foodmenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmenu.R
import com.example.foodmenu.adapter.HomeAdapter
import com.example.foodmenu.data.entities.MenuData
import com.example.foodmenu.view_model.HomeVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomeVM::class.java]
    }
    private val recyclerViewAdapter by lazy {
        HomeAdapter()
    }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        requireActivity().getWindow()
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        recyclerView = view.rv
        recyclerView.adapter=recyclerViewAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        return view

    }
    override fun onStart() {
        super.onStart()
        homeViewModel.loadData()
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.loadData()
    }
    private fun loadData() {
        homeViewModel.MenuInfo.observe(this) {
            recyclerViewAdapter.setData(it as ArrayList<MenuData>)

        }

        homeViewModel.fail.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }

}