package com.moises.kotlinmvp.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.moises.kotlinmvp.KotlinMVPApp
import com.moises.kotlinmvp.R
import com.moises.kotlinmvp.api.model.ResultsItem
import com.moises.kotlinmvp.main.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupInjection()
    }


    override fun showMoviesTopRated(resultItems: List<ResultsItem>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        movies_list.layoutManager = layoutManager
        movies_list.adapter = MoviesRecyclerViewAdapter(resultItems, this)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun setupInjection() {
        presenter = (application as KotlinMVPApp).getMainComponent(this, this).getPresenter()
        presenter.getMoviesTopRated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
