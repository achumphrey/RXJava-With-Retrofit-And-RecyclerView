package com.example.rxjavawithretrofitandrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.rxjavawithretrofitandrecyclerview.R
import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel
import com.example.rxjavawithretrofitandrecyclerview.presenter.PresenterImp
import com.example.rxjavawithretrofitandrecyclerview.presenter.ViewInterface

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()
    }

    fun addFragment(){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.frm_container, StarWarsFragment())
            //      .addToBackStack(null)
            .commit()
    }
}
