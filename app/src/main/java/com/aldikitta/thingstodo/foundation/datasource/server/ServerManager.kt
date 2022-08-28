package com.aldikitta.thingstodo.foundation.datasource.server

import com.aldikitta.thingstodo.model.Credential
import com.aldikitta.thingstodo.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class ServerManager @Inject constructor() {
    fun fetchCredential(): Flow<Credential> {
        return flow { emit(Credential(token = UUID.randomUUID().toString())) }
    }

    fun fetchUser(email: String, password: String): Flow<User> {
        return flow { emit(User(email)) }
    }
}