package com.example.cityapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.cityapp.R
import com.example.cityapp.adapters.City
import com.example.cityapp.adapters.CityAdapter
import com.example.cityapp.databinding.FragmentSelectedCityBinding
import com.example.cityapp.repository.CityViewModel

class SelectedCityFragment : Fragment() {

    lateinit var binding: FragmentSelectedCityBinding
    val vModel : CityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,
        R.layout.fragment_selected_city, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        val adapter = CityAdapter {
            Toast.makeText(requireContext(),"hello city", Toast.LENGTH_SHORT).show()
        }
//        adapter.submitList(listOf(
//            City(1 , "isfahan" ),
//            City(2 , "shiraz" ),
//            City(3 , "mashhad" )
//        ))
        vModel.selectedCityList.observe(requireActivity()){
            adapter.submitList(it)
        }
        binding.recyclerCitySelected.adapter = adapter
    }

}