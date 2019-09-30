package com.example.nystreetfood


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_detail_rest.*
import org.w3c.dom.Text
import android.R.attr.button
import android.content.pm.PackageManager
import android.provider.SyncStateContract
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.jar.Manifest as Manifest1


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
        (activity as AppCompatActivity).toolbar.title = "Restaurant Detail"

        val life = arguments?.getString("rest_name")
        view.findViewById<TextView>(R.id.TV_name).text=
            arguments?.getString("rest_name")
        view.findViewById<TextView>(R.id.TV_style).text=
            arguments?.getString("rest_subSub")
        view.findViewById<TextView>(R.id.TV_address).text=
            arguments?.getString("rest_add")
        view.findViewById<ImageView>(R.id.FV_food).setImageResource(
            when ( arguments?.getString("rest_subInd")){
            "Bar / Lounge" -> R.mipmap.bar_banner
            "Cafe / Deli"-> R.mipmap.cafe_banner
            "Catering"->R.mipmap.catering_banner
            "Coffee"->R.mipmap.coffee_banner
            "Consumables"->R.mipmap.consumables_banner
            "Full Serve"->R.mipmap.fullservice_banner
            "Quick Serve"->R.mipmap.quickservice_banner
            else->R.mipmap.bar_banner
        })
        /*
        view.findViewById<RatingBar>(R.id.rating).numStars=
            arguments?.getString("rest_rate")

         */
        if(arguments?.getString("rest_web").equals("")){
            bt_website.visibility = View.GONE
        }else {
            view.findViewById<Button>(R.id.bt_website).text =
                ("Website")
            val websiteNM = arguments?.getString("rest_web")

            val websiteAU ="http://"
            var sv =StringBuilder()
            //var (websiteNM?.contains(websiteAU)) :Boolean? =null
            if(  websiteNM?.isEmpty()==false && websiteNM.contains(websiteAU)==false){
                sv.append(websiteAU).append(websiteNM).append("/")
                val websitell = sv.toString()
                bt_website.setOnClickListener {
                    val openURL =
                        Intent(Intent.ACTION_VIEW, Uri.parse(websitell))
                    startActivity(openURL)
                }
            }else {
                bt_website.setOnClickListener {
                    val openURL =
                        Intent(Intent.ACTION_VIEW, Uri.parse(websiteNM))
                    startActivity(openURL)
                }
            }

        }
        if(arguments?.getString("rest_phone").equals("")){
            bt_phone.visibility = View.GONE
        }else {
            view.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.bt_phone).text =
                ("Call to them")
            val phoneStr = arguments?.getString("rest_phone")
            val phoneNum = phoneStr?.toIntOrNull()
            bt_phone.setOnClickListener {

                val openURL =
                    Intent(Intent.ACTION_DIAL)
                openURL.data=(Uri.parse("tel:"+phoneNum))
                startActivity(openURL)
            }

        }

    }


}
