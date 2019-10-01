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
            findNavController().navigate(R.id.action_welcomeFragment_to_detailRestFragment)
        }
    }
}
