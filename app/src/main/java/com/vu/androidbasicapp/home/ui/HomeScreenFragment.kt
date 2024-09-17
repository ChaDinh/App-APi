package com.vu.androidbasicapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.home.ui.HomeScreenViewModel

import com.vu.androidbasicapp.home.ui.recyclerview.MyRecyclerViewAdapter
import com.vu.androidbasicapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {

    private val viewModel: HomeScreenViewModel by viewModels()
    private lateinit var recyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val keypass = arguments?.getString("keypass")
        view.findViewById<TextView>(R.id.screenTitle).text = "Keypass: $keypass"

        recyclerViewAdapter = MyRecyclerViewAdapter { item ->
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToDashboardFragment(item)
            findNavController().navigate(action)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recyclerViewAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.apiResponseObjects.collect { listOfResponseItems ->
                    recyclerViewAdapter.setData(listOfResponseItems)
                }
            }
        }
    }
}
