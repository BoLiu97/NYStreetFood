package com.example.nystreetfood


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ListRest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var myFragmentView = inflater.inflate(R.layout.fragment_list_rest, container, false)
        var recyclerView = myFragmentView.findViewById(R.id.rest_list_recyclerView) as RecyclerView
        val initialRest = resources.openRawResource(R.raw.times_square_food_beverage_locations)
            .bufferedReader()
            .use { it.readText() }

        val restToShow = Rest.readRestData("R.raw.times_square_food_beverage_locations")
        //val stockArray = Rest.parseStockJson(jsonString)
        recyclerView.setAdapter(RecyclerViewAdapter(restToShow))
        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerViewAdapter(Resttoshow) { rest:Rest -> recyclerViewItemSelected(stock) }
        stock_recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
            setHasFixedSize(true)
        }
        return myFragmentView
    }

    lateinit var viewAdapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager
    fun recyclerViewItemSelected(rest: Rest) {
        val intent = Intent(this, DetailRestFragment::class.java)
        intent.putExtra("symbol", stock.symbol)
        startActivity(intent)
    }

    class RecyclerViewAdapter(val restData: Array<Rest>) ://Adapter class
    //, val clickListener: (Rest) -> Unit
        RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {//Inherit RecyclerView.Adapter. The Adapter holds a list of RecyclerViewHolder

        //In this method, inflate xml into a View object
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val viewItem =
                LayoutInflater.from(parent.context).inflate(R.layout.fragment_rest_list_sub, parent, false)
            return RecyclerViewHolder(viewItem)
        }

        //How many objects in this list
        override fun getItemCount(): Int {
            return restData.size
        }

        //What happens when the items are added to the list
        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.bind(restData[position], clickListener)
        }


        //The class to hold the items
        class RecyclerViewHolder(val viewItem: View) :
            RecyclerView.ViewHolder(viewItem) {
            fun bind(rest: Rest, clickListener: (Rest) -> Unit) {
                viewItem.findViewById<ImageView>(R.id.IV_style)
                    .setImageResource(when(rest.subIndus){
                        "Bar / Lounge"->R.mipmap.bar
                        "Cafe / Deli" ->R.mipmap.cafe
                        "Catering"->R.mipmap.catering
                        "Coffee"->R.mipmap.coffee
                        "Consumables"->R.mipmap.consumables
                        "Full Serve"->R.mipmap.fullservice
                        "Quick Serve"->R.mipmap.quickservice
                        else->R.mipmap.food
                    })
                viewItem.findViewById<TextView>(R.id.idItem).text = rest.restName
                viewItem.findViewById<TextView>(R.id.sub).text = rest.subIndus
                viewItem.setOnClickListener { clickListener(rest) }
            }
        }
    }
}

private fun String.toTypedArray(): Any {

}
