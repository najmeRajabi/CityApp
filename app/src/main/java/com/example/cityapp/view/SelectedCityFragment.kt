package com.example.cityapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
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
        vModel.selectedCityList.observe(requireActivity()){
            adapter.submitList(it)
        }
        binding.recyclerCitySelected.adapter = adapter

        enableSwipe(adapter , binding.recyclerCitySelected)
    }
    fun removeItem(position: Int, adapter: CityAdapter) {
        adapter.apply {
//            vModel.selectedCityList.value.removeAt(position)
            notifyItemRemoved(position)
            vModel.deSelectCity(position)
//            notifyItemRangeChanged(position, imageModelArrayList.size)
        }
    }


    private fun enableSwipe(adapter: CityAdapter , recyclerView: RecyclerView) {
        val simpleItemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition

                    if (direction == ItemTouchHelper.RIGHT) {

                        removeItem(position,adapter)

                    }

                }

//                override fun onChildDraw(
//                    c: Canvas,
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    dX: Float,
//                    dY: Float,
//                    actionState: Int,
//                    isCurrentlyActive: Boolean
//                ) {
//
//                    val icon: Bitmap
//                    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//
//                        val itemView = viewHolder.itemView
//                        val height = itemView.bottom.toFloat() - itemView.top.toFloat()
//                        val width = height / 3
//
//                        if (dX > 0) {
//                            p.color = Color.parseColor("#388E3C")
//                            val background =
//                                RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
//                            c.drawRect(background, p)
//                            icon = BitmapFactory.decodeResource(resources, R.drawable.delete)
//                            val icon_dest = RectF(
//                                itemView.left.toFloat() + width,
//                                itemView.top.toFloat() + width,
//                                itemView.left.toFloat() + 2 * width,
//                                itemView.bottom.toFloat() - width
//                            )
//                            c.drawBitmap(icon, null, icon_dest, p)
//                        } else {
//                            p.color = Color.parseColor("#D32F2F")
//                            val background = RectF(
//                                itemView.right.toFloat() + dX,
//                                itemView.top.toFloat(),
//                                itemView.right.toFloat(),
//                                itemView.bottom.toFloat()
//                            )
//                            c.drawRect(background, p)
//                            icon = BitmapFactory.decodeResource(resources, R.drawable.delete)
//                            val icon_dest = RectF(
//                                itemView.right.toFloat() - 2 * width,
//                                itemView.top.toFloat() + width,
//                                itemView.right.toFloat() - width,
//                                itemView.bottom.toFloat() - width
//                            )
//                            c.drawBitmap(icon, null, icon_dest, p)
//                        }
//                    }
//                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
//                }
            }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

//    private fun populateList(): ArrayList<City> {
//
//        val list = ArrayList<City>()
//
//        for (i in 0..7) {
//            val imageModel = City()
//            imageModel.setNames(myImageNameList[i])
//            list.add(imageModel)
//        }
//
//        return list
//    }
//}

}