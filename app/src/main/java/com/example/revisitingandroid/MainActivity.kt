package com.example.revisitingandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.databinding.ActivityMainBinding
import com.example.revisitingandroid.main.MainGridAdapter
import com.example.revisitingandroid.main.contents.coroutines.CT_CoroutinesActivityMain
import com.example.revisitingandroid.main.contents.intents.IntentActivityMain
import com.example.revisitingandroid.main.contents.livedatas.LiveDataActivity
import com.example.revisitingandroid.main.contents.navigations.NavigationActivity
import com.example.revisitingandroid.main.contents.recyclerViews.RV_RecyclerViewsActivity
import com.example.revisitingandroid.main.contents.rooms.RoomActivityMain
import com.example.revisitingandroid.main.contents.varargs.VariabelArguments
import com.example.revisitingandroid.main.contents.viewGroups.viewGroups_Activity_main
import com.example.revisitingandroid.main.contents.viewModels.ViewModelsActivity

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding ?= null
    private val binding : ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareGridView()
    }

    private fun provideContent() :ArrayList<String>
    {

        return arrayListOf(
            "ViewModel","Live Data","Activity_Fragment","Navigation",
            "RecyclerView", "Coroutines","Intent","View_viewgroup","vararg","room"
        
        )
    }

    private fun prepareGridView()
    {
        val adapter : MainGridAdapter = MainGridAdapter(this, provideContent())
        binding.GVMain.adapter = adapter
        var intent : Intent = Intent()
        binding.GVMain.setOnItemClickListener { adapterView, view, position, l ->
            if((provideContent()[position]).lowercase() == "viewmodel")
            {
                intent = Intent(this, ViewModelsActivity::class.java)
            }
            else if((provideContent()[position]).lowercase() == "live data")
            {

                intent = Intent(this, LiveDataActivity::class.java)
            }
            else if((provideContent()[position]).lowercase() == "navigation")
            {
                intent = Intent(this, NavigationActivity::class.java)
            }
            else if((provideContent()[position]).lowercase() == "recyclerview")
            {
                intent = Intent(this, RV_RecyclerViewsActivity::class.java)
            }
            else if((provideContent()[position]).lowercase() == "coroutines")
            {
                intent = Intent(this, CT_CoroutinesActivityMain::class.java)

            }
            else if(provideContent()[position].lowercase() == "intent")
            {
                intent = Intent(this, IntentActivityMain::class.java)
            }
            else if(provideContent()[position].lowercase() == "view_viewgroup")
            {
                intent = Intent(this, viewGroups_Activity_main::class.java)
            }
            else if(provideContent()[position].lowercase() == "vararg")
            {
                intent = Intent(this, VariabelArguments::class.java)
            }
            else if(provideContent()[position].lowercase() == "room")
            {
                intent = Intent(this,  RoomActivityMain::class.java)
            }
            startActivity(intent)
        }
    }


}