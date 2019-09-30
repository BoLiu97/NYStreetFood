package com.example.nystreetfood


import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import kotlinx.android.synthetic.main.fragment_style_list_main.*
import kotlinx.android.synthetic.main.fragment_style_lists.view.*
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*


/**
 * A simple [Fragment] subclass.
 */
class StyleListMainFragment : Fragment() {
    class Style{
        var Name:String? = null
        var Image:Int? = null
        constructor(Name:String,Image:Int){
            this.Image=Image
            this.Name=Name
        }
    }
    var listOfStyles = ArrayList<Style>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_style_list_main, container, false)

        //gridView.setAdapter(StyleAdapter(listOfStyles))




    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOfStyles.add(
            Style("Bar / Lounge",
                R.mipmap.bar)
        )
        listOfStyles.add(
            Style("Cafe / Deli",
                R.mipmap.cafe)
        )
        listOfStyles.add(
            Style("Catering",
                R.mipmap.catering)
        )
        listOfStyles.add(
            Style("Coffee",
                R.mipmap.coffee)
        )
        listOfStyles.add(
            Style("Consumables",
                R.mipmap.consumables)
        )
        listOfStyles.add(
            Style("Full Serve",
                R.mipmap.fullservice)
        )
        listOfStyles.add(
            Style("Quick Serve",
                R.mipmap.quickservice)
        )
        //gvListStyle.adapter=StyleAdapter(listOfStyles)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).toolbar.title = "Style List"

        val bundle = Bundle()
        gvListStyle.adapter = StyleAdapter(listOfStyles){

            bundle.putString("jump", "StyleScreen")
            bundle.putString("style",it)
            findNavController().navigate(R.id.action_styleListMainFragment_to_listRest,bundle)
        }

    }
    class StyleAdapter(val listOfStyle:ArrayList<Style>,val click: (String)->Unit):
        BaseAdapter() {
        //,val click: (String)->Unit

        override fun getView(p0: Int, p1: View?, p2: ViewGroup? ): View {
            val style = this.listOfStyle[p0]
            var styleView =
                LayoutInflater.from(p2?.context).inflate(R.layout.fragment_style_lists, p2, false)
            styleView.IV_style.setImageResource(style.Image!!)
            styleView.idItem.text=style.Name
            styleView.IV_style.setOnClickListener {
               click(style.Name!!)
            }
            //styleView.idItem.text = style.Name!!
            /*

            */
            return styleView

        }

        override fun getItem(p0: Int): Any {
            return listOfStyle[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfStyle.size

        }

    }

}
