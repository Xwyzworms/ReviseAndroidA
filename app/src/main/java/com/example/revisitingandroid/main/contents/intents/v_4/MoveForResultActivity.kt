package com.example.revisitingandroid.main.contents.intents.v_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.IntentActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity() {

    private lateinit var binding : IntentActivityMoveForResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntentActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener{
            if(binding.rgNumber.checkedRadioButtonId > 0)
            {
                var value : Int = 0
                when(binding.rgNumber.checkedRadioButtonId)
                {
                    R.id.rb_50 -> {
                        value = 50
                    }

                    R.id.rb_100 -> {
                        value = 100
                    }

                    R.id.rb_150 -> {

                        value = 150
                    }

                    R.id.rb_200 -> {
                        value = 200
                    }
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent) // The set result is for saving information !
                finish()
            }
        }



    }

    companion object {
        const val EXTRA_SELECTED_VALUE : String  = "extra_selected_value"
        const val RESULT_CODE : Int = 100
    }
}