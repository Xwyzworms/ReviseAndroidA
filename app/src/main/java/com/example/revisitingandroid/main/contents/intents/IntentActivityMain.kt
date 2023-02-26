package com.example.revisitingandroid.main.contents.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityIntentMainBinding
import com.example.revisitingandroid.main.contents.intents.v_1.IntentActivity_v1
import com.example.revisitingandroid.main.contents.intents.v_2.Intent_ActivityData
import com.example.revisitingandroid.main.contents.intents.v_2.Intent_ActivityData.Companion.AGE_EXTRA
import com.example.revisitingandroid.main.contents.intents.v_2.Intent_ActivityData.Companion.HOBBY_EXTRA
import com.example.revisitingandroid.main.contents.intents.v_2.Intent_ActivityData.Companion.NAMAE_EXTRA
import com.example.revisitingandroid.main.contents.intents.v_3.Intent_ActivityParcelable
import com.example.revisitingandroid.main.contents.intents.v_3.Intent_ActivityParcelable.Companion.EXTRA_PARCELABLE
import com.example.revisitingandroid.main.contents.intents.v_3.UserDummyData

class IntentActivityMain : AppCompatActivity() {

    private lateinit var binding : ActivityIntentMainBinding
    private lateinit var launcherIntentGallery : ActivityResultLauncher<Intent>
    private lateinit var launcherIntentText : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        // The implict intent should be prepared at onCreate
        // You create the contract from the begining
        prepareTheImplicitIntents()

    }
    private fun prepareTheImplicitIntents()
    {

        // RegisterForActivityResult adalah salah satu cara untuk menyederhanakan
        // Pengambilan hasil dari ACTIVITY / INTENT !
        // Misalnya kamu ngambil foto dari activity A dan kamu hendak menampilkannya langsung pada activity B
        // Kamu bisa pake registerForActivity Result
        // THIS RegisterForACtivityResult basically hanya seorang pelayan aja
        // Therefore dia need contract ( what is the input and what is the output )
        // And Callback < What should you do to the OUTPUT )
        launcherIntentGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // What you should do with the ouyput ?

        }
        launcherIntentText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            // Do the callback stuff after the output produced
        }

    }
    private fun provideContents() :  ArrayList<String>
    {
        return arrayListOf(
            "Explicit Intent#1",
            "Implicit Intent#1",
            "Implicit Intent#2",
            "Explicit Intent-Data",
            "Explicit Intent-DataParcel",

        )
    }

    private fun onClickListener(position : Int) :  Unit
    {
        when(position)
        {
            0 ->
            {
                val intent : Intent = Intent(this, IntentActivity_v1::class.java)
                startActivity(intent)
            }
            1 ->
            {
                // Because we want to communicate with android components
                // ASk user to chose a file base on intent type
                val intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type="image/*"
                // Launch --> Launch your Contract to produce the Output then do the callback stuff
                // Intent.CreateChooser ( STATIC ) --> Membuat A new ACTION_CHOOSE Intent yang wraps the target intent
                launcherIntentGallery.launch(Intent.createChooser(intent, "Choose a Picture"))
            }
            2 -> {

                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type="text/*"
                launcherIntentText.launch(Intent.createChooser(intent, "Choose text editor"))
            }
            3 ->
            {
                // Do some shit here
                val intent = Intent(this, Intent_ActivityData::class.java)

                val namae  : String = "PuRaMu Desu"
                val age : Int = 20
                val hobby : String= "Ngevvibu"

                intent.putExtra(NAMAE_EXTRA, namae)
                intent.putExtra(AGE_EXTRA, age)
                intent.putExtra(HOBBY_EXTRA, hobby)

                startActivity(intent)
            }
            4 -> {
                // Do another some shitty stuff here

                val intent = Intent(this, Intent_ActivityParcelable::class.java)
                val namae  : String = "PuRaMu Desu"
                val age : Int = 20
                val hobby : String= "Ngevvibu"

                val dummyUser : UserDummyData = UserDummyData(
                    namae,age,hobby
                )

                intent.putExtra(EXTRA_PARCELABLE, dummyUser)

                startActivity(intent)

            }
            else ->
            {
                // Do shit
            }
        }
    }
    private fun setupView()
    {
        binding.intentRvMain.layoutManager = LinearLayoutManager(this)
        binding.intentRvMain.adapter = IntentActivityMainAdapter(provideContents(), ::onClickListener)
    }
}