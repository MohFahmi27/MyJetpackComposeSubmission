package com.mohfahmi.myjetpackcompose.data

import com.mohfahmi.myjetpackcompose.data.model.News
import com.mohfahmi.myjetpackcompose.data.source.NewsDatas

class NewsRepository {
    fun getNewsData(): List<News> = NewsDatas.news

    fun getNewsById(id: String): News = NewsDatas.news.find {
        it.id == id
    } as News
}