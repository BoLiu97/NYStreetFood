package com.example.nystreetfood


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_rest.*
=======
>>>>>>> parent of eb875f4... only favourite part left

/**
 * A simple [Fragment] subclass.
 */
class SavedRestMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_rest_main, container, false)
    }

<<<<<<< HEAD
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).toolbar.title = "Favourite"
        val restData = readRestData()

        val bundle = Bundle()
        view.findViewById<RecyclerView>(R.id.food_screen_recyclerView)
            .layoutManager = LinearLayoutManager(context)

        rest_list_recyclerView.adapter = ListRest.RecyclerViewAdapter(restData) {
            bundle.putString("rest_name", it.restName)
            bundle.putString("rest_subInd", it.subIndus)
            bundle.putString("rest_subSub", it.subSub)
            bundle.putString("rest_add", it.address)
            bundle.putString("rest_phone", it.phone)
            bundle.putString("rest_web", it.website)
            bundle.putString("rest_post", it.postcode)
            bundle.putInt("rest_rate", it.rating!!)


            findNavController().navigate(R.id.action_listRest_to_detailRestFragment, bundle)
        }
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
            holder.bind(restData.get(position), clickListener)
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


        }
    }
=======
>>>>>>> parent of eb875f4... only favourite part left


}


