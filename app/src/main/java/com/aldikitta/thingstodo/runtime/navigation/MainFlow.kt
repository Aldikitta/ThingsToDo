package com.aldikitta.thingstodo.runtime.navigation

sealed class MainFlow(val name: String) {
    object Root: MainFlow("main-root"){
        val route = name
    }
    object RootEmpty: MainFlow("list-detail-root-empty"){
        val route = name
    }
}