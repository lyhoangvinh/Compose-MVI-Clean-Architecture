package com.base.app.navigation

sealed class AppRoute(val route: String) {
    data object Home : AppRoute("home")
    data object Detail : AppRoute("detail/{id}") {
        fun createRoute(id: String) = "detail/$id"
    }
    // Add more routes here
}
