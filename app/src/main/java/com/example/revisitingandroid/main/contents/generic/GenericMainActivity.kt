package com.example.revisitingandroid.main.contents.generic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityGenericMainBinding

class GenericMainActivity : AppCompatActivity() {

    private val binding : ActivityGenericMainBinding get() = _binding!!
    private var _binding : ActivityGenericMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGenericMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //* OUT Section// KALAU PAKE OUT berarti seluruh
        // TURUNAN Kelasnya dapat digunakan untuk suatu studi kasus
        // asalkan hirarki kelas paling atasnya sama
        // Output !
        val petshop : Petshop<Animal> = Petshop()
        val cities : Cities = Cities()
        cities.addPetshop(petshop)
        // But gimana kalau misalnya pengen Petshop hanya untuk anjing aja
        val dogPetshop : Petshop<Dog> = Petshop()
        cities.addPetshop(dogPetshop)

        // OUT SECTION done


        // IN SECTION, an Input to var from the same hierarcy
        // In kebalikannya aja

    }

}

abstract class Animal

class Dog : Animal()

class Cat : Animal()

class Petshop<out T : Animal> {
    fun doShit() {}
}

class Cities()
{
    fun addPetshop(petshop : Petshop<Animal>) {}
}







