package com.example.revisitingandroid.main.contents.varargs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.revisitingandroid.databinding.ActivityVariabelArgumentsBinding

class VariabelArguments : AppCompatActivity() {
    private lateinit var binding : ActivityVariabelArgumentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVariabelArgumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sumVarArgsAmpas( numberShit = intArrayOf(2,3,1,23))
        binding.varargsTvArrSum.text = genericVarargs(Kambing(), Kambing(),
                                                      Kerbau(), Kerbau()).toString()

    }
    /// How about kalua misalnya kamu butuh n params ? Masa nambahin a4,a5 ... an
    private fun sumShitWo_varArgs(a1 : Int, a2 : Int, a3 : Int ) : Int
    {
        return a1+a2+a3;
    }

    private fun sumShit_Varargs(vararg numberShit : Int) : Int
    {
        var theSum : Int = 0
            for(i : Int in 0..numberShit.size)
        {
            theSum += numberShit[i]
        }
        return theSum
    }

    private fun sumVarArgsAmpas(namae : String = "default" ,vararg numberShit : Int, state : Boolean = false)
    {
        val strText : String = namae + " " + numberShit.sum().toString() + " " +  state.toString()
        binding.varargsTvSum.text = strText
    }

    private fun <T> genericVarargs(vararg inputs : T)  : List<T>
    {
        val kambings : ArrayList<T> = ArrayList()
        val kerbaus : ArrayList<T> = ArrayList()
        val merge : ArrayList<T> = ArrayList()
        for( input : T in inputs)
        {
            when(input)
            {
                is Kambing ->
                {
                    kambings.add(input)
                }

                is Kerbau ->
                {
                    kerbaus.add(input)
                }
            }
            merge.add(input)
        }

        return merge
    }

}