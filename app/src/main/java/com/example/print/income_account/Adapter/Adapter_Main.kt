package com.example.print.income_account.Adapter

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.print.income_account.Database.ConectDataBase
import com.example.print.income_account.Model.model_detail
import com.example.print.income_account.R
import com.example.print.income_account.View.view_cardAdd
import com.example.print.income_account.View.view_cardDetail
import java.text.SimpleDateFormat

/**
 * Created by print on 9/19/2017.
 */
class Adapter_Main(val context: Context,val list:List<model_detail>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var data = list.get(position)
        println("date: "+data.date+" amount: "+data.amount+" menu: "+data.menu+" type: "+data.type)
            if(position<list.size-1){
                (holder as view_cardDetail).amount.setText(data.amount)
                (holder ).date.setText(data.date)
                (holder ).manu.setText(data.menu)
                (holder ).type.setText(data.type)
            }else{
                (holder as view_cardAdd).add.setOnClickListener(View.OnClickListener {
                    val dialog:Dialog = Dialog(context)
                    dialog.setContentView(R.layout.fragment_dialog_add_data)
                    val bt_date = dialog.findViewById<View>(R.id.bt_date)
                    val sp_type = dialog.findViewById<Spinner>(R.id.sp_type)
                    val adapter = ArrayAdapter.createFromResource(context,R.array.type,R.layout.support_simple_spinner_dropdown_item)
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                    sp_type.adapter = adapter
                    val txt_date = dialog.findViewById<TextView>(R.id.txt_date)
                    val sp_type_detail = dialog.findViewById<Spinner>(R.id.sp_typeDetail)
                    sp_type.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                            when(sp_type.selectedItemPosition){
                                0->{
                                    sp_type_detail.visibility = View.INVISIBLE
                                }
                                1->{
                                    sp_type_detail.visibility = View.VISIBLE
                                    val ad_type_detail = ArrayAdapter.createFromResource(context,R.array.detail_income,R.layout.support_simple_spinner_dropdown_item)
                                    ad_type_detail.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                                    sp_type_detail.adapter = ad_type_detail
                                }
                                2->{
                                    sp_type_detail.visibility = View.VISIBLE
                                    val ad_type_detail = ArrayAdapter.createFromResource(context,R.array.detail_fee,R.layout.support_simple_spinner_dropdown_item)
                                    ad_type_detail.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                                    sp_type_detail.adapter = ad_type_detail
                                }
                                else -> {
                                }
                            }
                        }

                    }

                    val edit_text:EditText = dialog.findViewById<EditText>(R.id.edit_text)
                    val bt_save = dialog.findViewById<Button>(R.id.bt_save)
                    bt_save.setOnClickListener {
                        val text:Any = edit_text.text.toString()
                        val money:Int = text.toString().toInt()
                        println("print: "+money)

                        ConectDataBase(context).addData(list.size-1,txt_date.text.toString(),sp_type.selectedItem.toString(),sp_type_detail.selectedItem.toString(),money)
                        val modeil = model_detail()

                        notifyItemInserted(list.size-1)
                        notifyDataSetChanged()
                        dialog.dismiss()
                    }
                    bt_date.setOnClickListener(View.OnClickListener {
                        val dialog_date = Dialog(context)
                        
                        dialog_date.setContentView(R.layout.fragment_dialog_date)
                        val bt_colse = dialog_date.findViewById<View>(R.id.di_bt_close)
                        bt_colse.setOnClickListener(View.OnClickListener {
                            dialog.show()
                            dialog_date.dismiss()
                        })

                        val bt_check = dialog_date.findViewById<View>(R.id.di_bt_check)
                        bt_check.setOnClickListener(View.OnClickListener {
                            val calander:CalendarView = dialog_date.findViewById<CalendarView>(R.id.calendarView)
                            val sdf = SimpleDateFormat("dd/MM/yyyy")
                            val Date:String = sdf.format(calander.date)

                            calander.date
                            txt_date.text = Date
                            dialog.show()
                            dialog_date.dismiss()
                        })
                        dialog.hide()
                        dialog_date.show()
                    })
                    Toast.makeText(context,"add",Toast.LENGTH_LONG).show()
                    dialog.show()
                })
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view:ViewHolder
        if(viewType==list.size-1){
            view = view_cardAdd(LayoutInflater.from(context).inflate(R.layout.card_add,null))
        }
        else{
            view = view_cardDetail(LayoutInflater.from(context).inflate(R.layout.card_detail,null))
        }
        return view
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}