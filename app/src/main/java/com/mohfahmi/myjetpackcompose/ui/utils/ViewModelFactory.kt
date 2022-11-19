package com.mohfahmi.myjetpackcompose.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohfahmi.myjetpackcompose.data.NewsRepository
import com.mohfahmi.myjetpackcompose.ui.screens.detail.DetailViewModel
import com.mohfahmi.myjetpackcompose.ui.screens.home.HomeViewModel

class ViewModelFactory(private val repository: NewsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}