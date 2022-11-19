package com.mohfahmi.myjetpackcompose.ui.screens.detail

import androidx.lifecycle.ViewModel
import com.mohfahmi.myjetpackcompose.data.NewsRepository
import com.mohfahmi.myjetpackcompose.data.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getNewsData(idNews: String): StateFlow<News> = MutableStateFlow(
        newsRepository.getNewsById(idNews)
    ).asStateFlow()
}