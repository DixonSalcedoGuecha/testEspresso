package com.example.testlistmap

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testlistmap.databinding.ItemOptionsPermissionBinding
import com.example.testlistmap.model.WindowsPermissionsLocal

class OptionPermissionsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemOptionsPermissionBinding.bind(view)

    fun render (windowsPermissionsLocal: WindowsPermissionsLocal,positionItem: Int, onClickListener: (WindowsPermissionsLocal, Int) -> Unit){
        with(binding){
            textItem.text = windowsPermissionsLocal.title


            itemView.setOnClickListener { onClickListener(windowsPermissionsLocal, positionItem) }
        }

    }
}