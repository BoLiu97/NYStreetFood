package com.example.nystreetfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_rest_list_sub.view.*


    class RecyclerViewAdapter(

        val restData: ArrayList<Rest>

    ) ://Adapter class
    //
        RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {//Inherit RecyclerView.Adapter. The Adapter holds a list of RecyclerViewHolder

        //In this method, inflate xml into a View object
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val viewItem =
                LayoutInflater.from(parent?.context)
                    .inflate(R.layout.fragment_rest_list_sub, parent, false)
            return RecyclerViewHolder(viewItem)
        }

        //How many objects in this list
        override fun getItemCount(): Int {
            return restData.size
        }

        //What happens when the items are added to the list
        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            //holder.bind(restData.get(position),clickListener)
            val restTitle = restData.get(position)
            holder?.viewItem?.idItem?.text = restTitle.restName
            holder?.viewItem?.sub?.text = restTitle.subSub
            holder?.viewItem?.IV_style.setImageResource(
                when (restTitle.subIndus) {
                    "Bar / Lounge" -> R.mipmap.bar
                    "Cafe / Deli" -> R.mipmap.cafe
                    "Catering" -> R.mipmap.catering
                    "Coffee" -> R.mipmap.coffee
                    "Consumables" -> R.mipmap.consumables
                    "Full Serve" -> R.mipmap.fullservice
                    "Quick Serve" -> R.mipmap.quickservice
                    else -> R.mipmap.food
                }
            )
        }


        //The class to hold the items
        class RecyclerViewHolder(val viewItem: View) :
            RecyclerView.ViewHolder(viewItem) {
            init {
                viewItem.setOnClickListener {

                    //val intent = Intent(viewItem.context, DetailRestFragment::class.java)
                    //viewItem.context.startActivity(intent)

                }
            }


            /*
            fun bind(rest: Rest, clickListener: (Rest) -> Unit) {
                viewItem.findViewById<ImageView>(R.id.IV_style)
                    .setImageResource(
                        when (rest.subIndus) {
                            "Bar / Lounge" -> R.mipmap.bar
                            "Cafe / Deli" -> R.mipmap.cafe
                            "Catering" -> R.mipmap.catering
                            "Coffee" -> R.mipmap.coffee
                            "Consumables" -> R.mipmap.consumables
                            "Full Serve" -> R.mipmap.fullservice
                            "Quick Serve" -> R.mipmap.quickservice
                            else -> R.mipmap.food
                        }
                    )
                viewItem.findViewById<TextView>(R.id.idItem).text = rest.restName
                viewItem.findViewById<TextView>(R.id.sub).text = rest.subIndus
                viewItem.setOnClickListener {
                    clickListener(rest)}
            }

             */
        }
    }
