package edu.farmingdale.alrajab.bcs421.sharedPref

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.farmingdale.alrajab.bcs421.R

class MyAdapter(private val context: Context, private val data: Map<String, *>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val keyTextView: TextView = itemView.findViewById(R.id.textViewKey)
        val valueTextView: TextView = itemView.findViewById(R.id.textViewValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val key = data.keys.elementAt(position)
        val value = data[key].toString()

        holder.keyTextView.text = key
        holder.valueTextView.text = value
    }

    override fun getItemCount(): Int {
        return data.size
    }
}