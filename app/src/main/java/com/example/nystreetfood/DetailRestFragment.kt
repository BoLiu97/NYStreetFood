package com.example.nystreetfood


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class DetailRestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_rest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun readRestData():ArrayList<Rest> {
        var listOfRest = ArrayList<Rest>()
        try {


            val initialRest = resources.openRawResource(R.raw.times_square_food_beverage_locations)
            val reader = initialRest.bufferedReader()
            var line = reader.readLine()

            //var subin = arguments?.getString("subindu").toString()


                while (line != null) {
                    var Line = line.toString()
                    //val nextLine = Line.split(",").toTypedArray()
                    var nameChoose = arguments?.getString("Name").toString()
                    val nextLine: List<String> = Line.split(",")
                    //print(  nextLine)
                    if (nameChoose == "FoodScreen"){
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
        } catch (e: IllegalStateException) {
            return listOfRest
        }
        return listOfRest
    }
}
