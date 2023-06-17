package com.atik.epoxypractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atik.epoxypractice.databinding.ActivityMainBinding
import com.atik.epoxypractice.epoxy.ItemEpoxyController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var controller:ItemEpoxyController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller  = ItemEpoxyController{

        }

        binding.listRv.adapter = controller.adapter
        controller.requestModelBuild()
    }
}