package com.example.revisitingandroid.main.contents.rooms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityRoomMainBinding
import com.example.revisitingandroid.main.contents.rooms.rooms_db.Subscriber
import com.example.revisitingandroid.main.contents.rooms.rooms_db.SubscriberDatabase
import com.example.revisitingandroid.main.contents.rooms.viewmodel.SubscriberViewModelFactory
import com.example.revisitingandroid.main.contents.rooms.viewmodel.SubscriberViewmodel

class RoomActivityMain : AppCompatActivity() {
private lateinit var viewModel : SubscriberViewmodel
    private lateinit var viewModelFactory : SubscriberViewModelFactory
    private lateinit var repository: SubscriberRepository

    // Binding
    private val binding : ActivityRoomMainBinding get() = _binding!!
    private var _binding : ActivityRoomMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        _binding = ActivityRoomMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewmodel()
        setupRecyclerView()
        setupViews()
    }
    private fun setupRecyclerView()
    {

        viewModel.subscribers.observe(this)
        {

            binding.rvMainROOM.adapter = RoomRVAdapter(it)
        }
        binding.rvMainROOM.layoutManager = LinearLayoutManager(this)
    }
    private fun setupViews()
    {

        fun setupButtons()
        {
                binding.saveOrUpdateButton.setOnClickListener {
                    val subs = Subscriber(0,binding.nameText.text.toString(), binding.emailText.text.toString())
                    if(viewModel.getUser(subs.email))
                    {
                        viewModel.update(subs.name, subs.email)
                    }
                    else
                    {
                        viewModel.insert(subs)
                    }
                }

        }

        viewModel.inputName.observe(this) {
            binding.nameText.setText(it)
        }

        viewModel.inputEmail.observe(this)
        {
            binding.emailText.setText(it)
        }

        setupButtons()
    }

    private fun setupRepository()
    {
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        repository = SubscriberRepository(dao)
    }
    private fun setupViewmodel()
    {
        setupRepository()
        viewModelFactory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SubscriberViewmodel::class.java)

    }

}