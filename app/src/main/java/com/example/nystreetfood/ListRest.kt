package com.example.nystreetfood


import java.nio.file.Paths
import java.nio.file.Files
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opencsv.CSVReader
import kotlinx.android.synthetic.main.fragment_list_rest.*
import kotlinx.android.synthetic.main.fragment_rest_list_sub.view.*
import kotlinx.android.synthetic.main.fragment_saved_rest_main.*
import java.io.FileReader
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 */
class ListRest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_rest, container, false)
        /*
        var recyclerView = myFragmentView.findViewById(R.id.rest_list_recyclerView) as RecyclerView

        val restData = readRestData()
        recyclerView!!.layoutManager = LinearLayoutManager(this.context)
        recyclerView!!.adapter= RecyclerViewAdapter(restData)


        return myFragmentView

         */
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val restData = readRestData()

        val bundle = Bundle()
        view.findViewById<RecyclerView>(R.id.rest_list_recyclerView)
            .layoutManager = LinearLayoutManager(context)

        view.findViewById<RecyclerView>(R.id.rest_list_recyclerView)
            .adapter = RecyclerViewAdapter(restData){
            bundle.putString("Name",it.restName)
            findNavController().navigate(R.id.action_listRest_to_detailRestFragment,bundle)
        }
    }






    fun readRestData():ArrayList<Rest> {
        var listOfRest = ArrayList<Rest>()
        try {


            val initialRest = resources.openRawResource(R.raw.times_square_food_beverage_locations)
            val reader = initialRest.bufferedReader()
            var line = reader.readLine()
            var styleChoose = arguments?.getString("style").toString()
            //var subin = arguments?.getString("subindu").toString()
            var jumpClass = arguments?.getString("jump").toString()

            if (jumpClass == "FoodScreen"){
                while (line != null) {
                    var Line = line.toString()
                    //val nextLine = Line.split(",").toTypedArray()
                    val nextLine: List<String> = Line.split(",")
                    //print(  nextLine)
                    if (styleChoose == nextLine.elementAt(2)) {
                        listOfRest.add(
                            Rest(
                                nextLine.elementAt(0),
                                nextLine.elementAt(1),
                                nextLine.elementAt(2),
                                nextLine.elementAt(3),
                                nextLine.elementAt(4),
                                nextLine.elementAt(5),
                                nextLine.elementAt(6),
                                0

                            )
                        )
                    }
                    line = reader.readLine()
                }

        }else if(jumpClass=="StyleScreen"){
                while (line != null) {
                    var Line = line.toString()
                    //val nextLine = Line.split(",").toTypedArray()
                    val nextLine: List<String> = Line.split(",")
                    //print(  nextLine)

                    if (styleChoose == nextLine.elementAt(1)) {
                        listOfRest.add(
                            Rest(
                                nextLine.elementAt(0),
                                nextLine.elementAt(1),
                                nextLine.elementAt(2),
                                nextLine.elementAt(3),
                                nextLine.elementAt(4),
                                nextLine.elementAt(5),
                                nextLine.elementAt(6),
                                0

                            )
                        )
                    }

                    line = reader.readLine()
                }
            }else {
                while (line != null) {
                    var Line = line.toString()
                    //val nextLine = Line.split(",").toTypedArray()
                    val nextLine: List<String> = Line.split(",")
                    //print(  nextLine)

                    listOfRest.add(
                        Rest(
                            nextLine.elementAt(0),
                            nextLine.elementAt(1),
                            nextLine.elementAt(2),
                            nextLine.elementAt(3),
                            nextLine.elementAt(4),
                            nextLine.elementAt(5),
                            nextLine.elementAt(6),
                            0

                        )
                    )

                    line = reader.readLine()
                }
            }
            arguments?.putString("jump", "")
        } catch (e: IllegalStateException) {
            return listOfRest
        }
        return listOfRest
    }


    class RecyclerViewAdapter(

        val restData: ArrayList<Rest>,
        val clickListener: (Rest) -> Unit
    ) :
        RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {//Inherit RecyclerView.Adapter. The Adapter holds a list of RecyclerViewHolder

        //In this method, inflate xml into a View object
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RecyclerViewHolder {
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
        override fun onBindViewHolder(holder:
                                      RecyclerViewHolder, position: Int) {
            holder.bind(restData.get(position),clickListener)
            /*
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
            */
        }
        //The class to hold the items
        class RecyclerViewHolder(val viewItem: View) :
            RecyclerView.ViewHolder(viewItem) {

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
            /*
                       init {
                           viewItem.setOnClickListener {

                           //val intent = Intent(viewItem.context, DetailRestFragment::class.java)
                               //viewItem.context.startActivity(intent)

                           }
                       }
                        */

        }
    }


}

