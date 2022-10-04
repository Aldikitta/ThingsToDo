package com.aldikitta.thingstodo.runtime.navigation

import androidx.navigation.navArgument

sealed class MainFlow(val name: String) {
    object Root : MainFlow("main-root") {
        val route = name
    }

    object RootEmpty : MainFlow("list-detail-root-empty") {
        val route = name
    }
}

sealed class AuthFlow(val name: String) {
    object Root : AuthFlow("auth-root") {
        val route = name
    }

    object LoginScreen : AuthFlow("login-screen") {
        val route = name
    }
}

sealed class HomeFLow(val name: String) {
    object Root : HomeFLow("home-root") {
        val route = name
    }

    object DashboardScreen : HomeFLow("dashboard-screen") {
        val route = name
    }

    object GroupMenu : HomeFLow("group-menu-screen") {
        val arguments = listOf(
            navArgument(ARG_GROUP_ID) {
                defaultValue = ""
            }
        )
        val route = "$name?$ARG_GROUP_ID={$ARG_GROUP_ID}"

        fun route(groupId: String): String {
            return "$name?$ARG_GROUP_ID=${groupId}"
        }
    }

    object CreateGroup : HomeFLow("create-group-screen") {
        val route = name
    }

    object UpdateGroup : HomeFLow("update-group-screen") {
        val arguments = listOf(
            navArgument(ARG_GROUP_ID) {
                defaultValue = ""
            }
        )

        val route = "$name?$ARG_GROUP_ID={$ARG_GROUP_ID}"

        fun route(groupId: String?): String {
            return "$name?$ARG_GROUP_ID=${groupId}"
        }
    }

    object UpdateGroupList : HomeFLow("update-group-list-screen") {
        val arguments = listOf(
            navArgument(ARG_GROUP_ID) {
                defaultValue = ""
            }
        )

        val route = "$name?$ARG_GROUP_ID={$ARG_GROUP_ID}"

        fun route(groupId: String): String {
            return "$name?$ARG_GROUP_ID=${groupId}"
        }
    }

    object EditGroupList : HomeFLow("edit-group-list-screen") {
        val arguments = listOf(
            navArgument(ARG_GROUP_ID) {
                defaultValue = ""
            }
        )

        val route = "$name?$ARG_GROUP_ID={$ARG_GROUP_ID}"

        fun route(groupId: String?): String {
            return "$name?$ARG_GROUP_ID=${groupId}"
        }
    }
}

const val ARG_STEP_ID = "stepId"
const val ARG_TASK_ID = "taskId"
const val ARG_LIST_ID = "listId"
const val ARG_GROUP_ID = "groupId"
const val ARG_SCHEDULED_TYPE = "scheduledType"