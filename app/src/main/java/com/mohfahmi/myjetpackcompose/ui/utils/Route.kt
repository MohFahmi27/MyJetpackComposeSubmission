package com.mohfahmi.myjetpackcompose.ui.utils

sealed class Route(val path: String) {
    object Home: Route("home")
    object About: Route("about")
    object Detail: Route("home/{newsId}") {
        fun createRoute(newsId: String) = "home/$newsId"
    }
}