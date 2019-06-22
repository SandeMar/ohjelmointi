package com.example.rekisterinumerobingo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.register_list_item.view.*

class RegisterAdapter(val items: MutableList<Registeritem>, private val clickListener: (Registeritem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.register_list_item, parent, false)
        return RegisterViewHolder(view)
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RegisterViewHolder).bind(items[position], clickListener)

    }

    class RegisterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(registerData: Registeritem, clickListener: (Registeritem) -> Unit) {
            itemView.txt_number.text = registerData.id.toString()
            itemView.setOnClickListener {
                clickListener(registerData)
            }

        }
    }
}