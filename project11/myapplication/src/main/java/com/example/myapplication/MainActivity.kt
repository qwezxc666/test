package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun getFood(id: Int?) {
        HttpUtil.get("/prod-api/api/takeout/product/list?sellerId=${Tool.seller.id}&categoryId=$id", object : MyCallback(requireActivity(), FoodData::class.java) {
            override fun onFinish(obj: Any?) {
                val data = obj as FoodData
                data.data?.let {
                    _binding.rv.adapter = object : RecyclerView.Adapter<ItemFoodVH>() {
                        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFoodVH {
                            return ItemFoodVH(ItemFoodBinding.inflate(LayoutInflater.from(requireContext()), parent, false))
                        }

                        override fun onBindViewHolder(holder: ItemFoodVH, position: Int) {
                            holder.binding.apply {
                                val dataModel = it[position]
                                imageView4.loadImgFromNet(dataModel.imgUrl)
                                textView4.text = dataModel.name
                                textView5.text = "月销量:${dataModel.saleQuantity}    好评率:${dataModel.favorRate}%"
                                textView29.text = "￥${dataModel.price}"

                                val num = Tool.FOOD_MAP[dataModel]
                                tvNum.text = if (num == null) "0" else "$num"
                                ivRemove.visibility = if (!tvNum.text.equals("0")) View.VISIBLE else View.INVISIBLE

                                ivAdd.setOnClickListener {
                                    val int = Tool.FOOD_MAP[dataModel]
                                    if (int != null) {
                                        val value: Int = int + 1
                                        tvNum.text = "$value"
                                        Tool.FOOD_MAP[dataModel] = value
                                    } else {
                                        tvNum.text = "1"
                                        Tool.FOOD_MAP[dataModel] = 1
                                    }
                                    (requireActivity() as SellerActivity).refresh()
                                    notifyDataSetChanged()
                                }

                                ivRemove.setOnClickListener {
                                    val int = Tool.FOOD_MAP[dataModel]
                                    if (int != null && int > 1) {
                                        val value: Int = int - 1
                                        tvNum.text = "$value"
                                        Tool.FOOD_MAP[dataModel] = value
                                    } else {
                                        tvNum.text = "0"
                                        Tool.FOOD_MAP[dataModel] = 0
                                        Tool.FOOD_MAP.remove(dataModel)
                                    }
                                    (requireActivity() as SellerActivity).refresh()
                                    notifyDataSetChanged()
                                }
                            }
                        }

                        override fun getItemCount() = it.size
                    }

                }
            }
        })
    }
}
