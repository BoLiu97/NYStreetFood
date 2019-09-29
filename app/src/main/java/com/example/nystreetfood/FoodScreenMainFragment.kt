package com.example.nystreetfood
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_food_screen.*
import kotlinx.android.synthetic.main.fragment_food_screen_main.*
import kotlinx.android.synthetic.main.fragment_food_screen_main.american_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.chinese_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.dessert_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.fast_food_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.french_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.italian_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.japanese_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.mexican_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.pizza_food
import kotlinx.android.synthetic.main.fragment_food_screen_main.steakhouse_food

/**
 * A simple [Fragment] subclass.
 */
class FoodScreenMainFragment : Fragment(),View.OnClickListener{

    override fun onClick(p0: View?) {
        val intent = Intent(activity, ListActivity::class.java)
        val subSub = when (p0?.id) {
            american_food.id -> "American"
            chinese_food.id -> "Chinese"
            dessert_food.id -> "Dessert"
            fast_food_food.id -> "Fast Food"
            french_food.id -> "French"
            italian_food.id -> "Italian"
            japanese_food.id -> "Japanese"
            mexican_food.id -> "Mexican"
            pizza_food.id -> "Pizza"
            steakhouse_food.id -> "Steakhouse"
            else -> "Other"
        }
        intent.putExtra("subSub", subSub)
        startActivity(intent)
    }


    //Adapter for the recycler view. It takes an array of stocks to be presented in the recycler view, and a lambda function as the click callback
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_screen_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        american_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        chinese_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        dessert_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        fast_food_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        french_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        italian_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        japanese_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        mexican_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }

        pizza_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }
        steakhouse_food.setOnClickListener {
            findNavController().navigate(R.id.action_foodScreenMainFragment_to_listRest)
        }
    }




}
