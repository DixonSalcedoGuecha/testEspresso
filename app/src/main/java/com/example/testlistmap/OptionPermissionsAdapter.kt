package com.example.testlistmap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testlistmap.model.WindowsPermissionsLocal

class OptionPermissionsAdapter  (private var listOptionsLocal: List<WindowsPermissionsLocal>, private val onClickListener: (WindowsPermissionsLocal, Int) -> Unit) : RecyclerView.Adapter<OptionPermissionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionPermissionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return OptionPermissionsViewHolder(layoutInflater.inflate(R.layout.item_options_permission ,parent, false))
    }

    override fun getItemCount(): Int = listOptionsLocal.size

    override fun onBindViewHolder(holder: OptionPermissionsViewHolder, position: Int) {
        val item = listOptionsLocal[position]
        holder.render(item,position ,onClickListener)
    }

}