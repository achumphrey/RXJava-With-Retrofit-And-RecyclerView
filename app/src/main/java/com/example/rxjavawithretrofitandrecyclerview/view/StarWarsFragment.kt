package com.example.rxjavawithretrofitandrecyclerview.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.rxjavawithretrofitandrecyclerview.R
import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel
import com.example.rxjavawithretrofitandrecyclerview.presenter.PresenterImp
import com.example.rxjavawithretrofitandrecyclerview.presenter.ViewInterface
import kotlinx.android.synthetic.main.fragment_star_wars.*

/**
 * A simple [Fragment] subclass.
 */
class StarWarsFragment : Fragment(), ViewInterface {

    private lateinit var presenterImp: PresenterImp

    override fun showProgress() {
        prgs_bar.visibility = View.VISIBLE
    }

    override fun showError() {

    }

    override fun onShowList(starWarsModel: StarWarsModel) {

        prgs_bar.visibility = View.GONE

        val adapter: StarWarsAdapter = StarWarsAdapter(starWarsModel!!)
        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = adapter
    }

    override fun onDestroy() { // this is the activity's onDestroy() method call
        super.onDestroy()
        presenterImp.onDestroy()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_wars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenterImp = PresenterImp(this)
        presenterImp.processCall()
        showProgress()
    }

}
