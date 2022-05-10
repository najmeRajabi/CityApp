package com.example.cityapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cityapp.R
import com.example.cityapp.adapters.City
import com.example.cityapp.adapters.CityAdapter
import com.example.cityapp.databinding.FragmentHomeBinding
import com.example.cityapp.repository.CityViewModel

class HomeFragment : Fragment() {


    val vModel: CityViewModel by activityViewModels()
    lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_home,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        binding.fabGoToNext.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_selectedCityFragment)
        }
    }

    private fun initViews() {

        val adapter = CityAdapter {
            Toast.makeText(requireContext(),"hello", Toast.LENGTH_SHORT).show()
            vModel.selectItem(it)
        }
        vModel.cityList.observe(requireActivity()){
            adapter.submitList(it)
        }
        binding.recyclerCity.adapter = adapter

        vModel.hideBtnNextPage.observe(requireActivity()){
            if (it) {
                binding.fabGoToNext.visibility = View.GONE
            }else{
                binding.fabGoToNext.visibility = View.VISIBLE
            }
        }
    }

}