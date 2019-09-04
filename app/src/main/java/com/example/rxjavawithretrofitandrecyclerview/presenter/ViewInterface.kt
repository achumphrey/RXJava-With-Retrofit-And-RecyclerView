package com.example.rxjavawithretrofitandrecyclerview.presenter

import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel

interface ViewInterface {

    fun showProgress()
    fun showError()
    fun onShowList(starWarsModel: StarWarsModel)
}