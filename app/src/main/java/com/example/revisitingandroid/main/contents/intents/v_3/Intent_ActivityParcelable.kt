package com.example.revisitingandroid.main.contents.intents.v_3

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.IntentActivityParcelableBinding

class Intent_ActivityParcelable : AppCompatActivity() {

    private lateinit var binding : IntentActivityParcelableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntentActivityParcelableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()

    }

    private fun setupView()
    {
        val userDummyData =
            if (Build.VERSION.SDK_INT>= 33 )
            {
                intent.getParcelableExtra(EXTRA_PARCELABLE,UserDummyData::class.java)
            }
        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PARCELABLE)
        }

        if(userDummyData != null)
        {
            binding.intentTvV3Age.text = userDummyData.age.toString()
            binding.intentTvV3Hobby.text = userDummyData.hobby
            binding.intentTvV3Namae.text = userDummyData.name
        }

    }
    companion object {
        const val EXTRA_PARCELABLE : String = "extra_parcelable"
    }
}