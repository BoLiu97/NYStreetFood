package com.example.nystreetfood


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_welcome.*




/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).toolbar.title = "Home"
        allStr.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_listRest)
        }
        fdStyle.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_styleListMainFragment)
        }
        fd.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_foodScreenMainFragment)
        }
        LKdraw.setOnClickListener{
            val bundle= Bundle();
            val restData = readRestData()

            bundle.putString("rest_name",restData[0].restName)
            bundle.putString("rest_subInd",restData[0].subIndus)
            bundle.putString("rest_subSub",restData[0].subSub)
            bundle.putString("rest_add",restData[0].address)
            bundle.putString("rest_phone",restData[0].phone)
            bundle.putString("rest_web",restData[0].website)
            bundle.putString("rest_post",restData[0].postcode)
            bundle.putInt("rest_rate",restData[0].rating!!)

            findNavController().navigate(R.id.action_welcomeFragment_to_detailRestFragment,bundle)
        }
    }
    fun readRestData():ArrayList<Rest> {
        var listOfRest = ArrayList<Rest>()
        try {

            var num = (1..332).random()
            val initialRest = resources.openRawResource(R.raw.times_square_food_beverage_locations)
            val reader = initialRest.bufferedReader()
            var line = reader.readLine()
            //var subin = arguments?.getString("subindu").toString()
            for (i in 0 until num ) {
                line = reader.readLine()
            }
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
        } catch (e: IllegalStateException) {
            return listOfRest
        }
        return listOfRest
    }


}
