package com.example.print.income_account.View

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.print.income_account.R

/**
 * Created by print on 9/19/2017.
 */
class view_cardDetail(itemView: View?) : RecyclerView.ViewHolder(itemView) {
     val date:TextView = itemView!!.findViewById(R.id.card_date)
     val type:TextView = itemView!!.findViewById(R.id.card_type)
     val manu:TextView = itemView!!.findViewById(R.id.card_menu)
     val amount:TextView = itemView!!.findViewById(R.id.card_amount)
}