package com.example.mytestwork

import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytestwork.api.dailymotion.DailymotionApi
import com.example.mytestwork.databinding.FragmentBlankBinding
import com.example.mytestwork.api.github.GitHubApi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class UsersFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: UsersViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
val adapter = RvAdapter(mutableListOf())
     binding.Rv.adapter = adapter
        binding.Rv.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        ).get(UsersViewModel::class.java)
        GlobalScope.launch {
            delay(20000)
        }
        viewModel.getUsersApi()
        viewModel.getAllUsers()
        viewModel.userEnityLiveDat.observe(viewLifecycleOwner){
            println("??????????" + it)
            adapter.setList(it)
        }
    }

}