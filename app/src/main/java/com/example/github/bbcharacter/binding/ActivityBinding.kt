package com.example.github.bbcharacter.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.example.github.bbcharacter.R
import com.google.android.material.appbar.MaterialToolbar

/**
 *   Created by Lee Zhang on 12/3/20 01:10
 **/
@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
    activity.simpleToolbarWithHome(toolbar, title)
}
@BindingAdapter("bindTextListToString")
fun bindTextListToString(textview : AppCompatTextView,list: List<String>){
    textview.text  =  list.joinToString(",")
}
private fun AppCompatActivity.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        setDisplayHomeAsUpEnabled(true)
        title = title_
    }
}
