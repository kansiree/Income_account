package com.example.print.income_account


import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.print.income_account.Adapter.Adapter_Main
import com.example.print.income_account.Database.ConectDataBase
import com.example.print.income_account.Model.model_detail
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class input_data : Fragment() {
    var list_data: RecyclerView? = null
    var list:List<model_detail> = ArrayList<model_detail>()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = Adapter_Main(this.context,load_data())
        val layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        list_data!!.adapter = adapter
        list_data!!.layoutManager = layoutManager

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_input_data,container,false)
        list_data = view.findViewById(R.id.list_detail)
        return view
    }

    fun load_data():List<model_detail>{
        val read:Cursor = ConectDataBase(context).readData()
        println("count Data: "+read.count)
        if(read.moveToFirst()){
            do {
                val data = model_detail()
                data.type = read.getString(3)
                data.menu = read.getString(2)
                data.date = read.getString(1)
                data.amount = read.getString(4)
                list += data
            }
            while (read.moveToNext())
        }

        val data2 = model_detail()
        data2.type = ""
        data2.menu = ""
        data2.date = ""
        data2.amount = ""
        list += data2

//        println("type: "+list.get(1).type+" menu: "+list.get(1).menu+" data: "+list.get(1).date+" amount: "+list.get(1).amount)
        return list
    }
}// Required empty public constructor

