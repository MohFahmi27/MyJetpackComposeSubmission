package com.mohfahmi.myjetpackcompose.ui.screens.home

import androidx.lifecycle.ViewModel
import com.mohfahmi.myjetpackcompose.data.NewsRepository
import com.mohfahmi.myjetpackcompose.data.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(newsRepository: NewsRepository) : ViewModel() {
    private val _news = MutableStateFlow(
        newsRepository.getNewsData()
    )

    val news: StateFlow<List<News>> get() = _news.asStateFlow()
}