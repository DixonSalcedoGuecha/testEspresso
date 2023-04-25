package com.example.testlistmap.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testlistmap.LocationReferencesActivity
import com.example.testlistmap.OptionPermissionsAdapter
import com.example.testlistmap.R
import com.example.testlistmap.databinding.FragmentEntriesBinding
import com.example.testlistmap.model.WindowsPermissionsLocal


class EntriesFragment : Fragment() {
    private lateinit var binding: FragmentEntriesBinding
    private lateinit var adapter: OptionPermissionsAdapter
    private var listOptionsLocal: MutableList<WindowsPermissionsLocal> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntriesBinding.inflate(inflater, container, false)

        listOptionsLocal = mutableListOf()
        assignValuesOptionList()
        initRecyclerView()



        return binding.root
    }


    private fun assignValuesOptionList() {

        val listResource: MutableList<String> =
            resources.getStringArray(R.array.entriesOptions).toMutableList()
        val listCodeResource: MutableList<String> =
            resources.getStringArray(R.array.codeEntriesOptions).toMutableList()


        for (i in listResource.indices) {
            listOptionsLocal.add(
                i,
                WindowsPermissionsLocal(
                    listCodeResource[i],
                    2,
                    listResource[i]
                )
            )
        }
    }

    private fun initRecyclerView() {

        adapter = OptionPermissionsAdapter(listOptionsLocal) { windowsPermissionsLocal, position ->
            onItemSelected(
                windowsPermissionsLocal,
                position
            )
        }
        binding.rvEntries2.layoutManager = LinearLayoutManager(binding.root.context)
        val dividerItemDecoration = DividerItemDecoration(
            binding.rvEntries2.context,
            (binding.rvEntries2.layoutManager as LinearLayoutManager).orientation
        )
        binding.rvEntries2.addItemDecoration(dividerItemDecoration)
        binding.rvEntries2.adapter = adapter
    }

    private fun onItemSelected(windowsPermissionsLocal: WindowsPermissionsLocal, position: Int) {
        if (windowsPermissionsLocal.idRoles == 2) {
            when (position) {
                0 -> Toast.makeText(requireContext(), "Click en item", Toast.LENGTH_SHORT).show()
                1 -> startActivity(Intent(activity, LocationReferencesActivity::class.java))
            }
        }

    }


}