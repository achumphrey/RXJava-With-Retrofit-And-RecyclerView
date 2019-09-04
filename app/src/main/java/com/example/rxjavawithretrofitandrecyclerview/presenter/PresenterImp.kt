package com.example.rxjavawithretrofitandrecyclerview.presenter

import android.util.Log
import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel
import com.example.rxjavawithretrofitandrecyclerview.network.ClientInterface
import com.example.rxjavawithretrofitandrecyclerview.network.RetrofitInstance
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PresenterImp(_view: ViewInterface): PresenterInterface {

    var view: ViewInterface? = _view

    override fun processCall() {

        val starWarsModelInterface =
            RetrofitInstance().retrofitInstance.create(ClientInterface::class.java)

        val starWarsModelObservable: Observable<StarWarsModel>
                = starWarsModelInterface.getNewsRecords()

        starWarsModelObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(starWarsObserver())
    }

    private fun starWarsObserver(): Observer<StarWarsModel>{

        return object : Observer<StarWarsModel>{

            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: StarWarsModel) {
                Log.d("Presenter", t.results[0].name)
                view?.onShowList(t)
            }

            override fun onError(e: Throwable) {
            }
        }
    }

    override fun onDestroy() {
        view = null
    }
}