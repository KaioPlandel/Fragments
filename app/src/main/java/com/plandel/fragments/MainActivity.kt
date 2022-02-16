package com.plandel.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.plandel.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,firstFragment)
            commit()
        }

        binding.buttonOn.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,firstFragment)
                    .commit()
            }
        }

        binding.buttonTwo.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,secondFragment)
                addToBackStack(null)
                    .commit()
            }
        }
    }
}