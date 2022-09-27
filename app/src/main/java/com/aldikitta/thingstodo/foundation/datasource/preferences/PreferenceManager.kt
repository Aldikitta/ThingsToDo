package com.aldikitta.thingstodo.foundation.datasource.preferences

import androidx.datastore.core.DataStore
import com.aldikitta.thingstodo.foundation.datasource.preferences.model.CredentialPreference
import com.aldikitta.thingstodo.foundation.datasource.preferences.model.LanguagePreference
import com.aldikitta.thingstodo.foundation.datasource.preferences.model.ThemePreference
import com.aldikitta.thingstodo.foundation.datasource.preferences.model.UserPreference
import com.aldikitta.thingstodo.foundation.extension.toTheme
import com.aldikitta.thingstodo.foundation.extension.toThemePreference
import com.aldikitta.thingstodo.model.Credential
import com.aldikitta.thingstodo.model.Theme
import com.aldikitta.thingstodo.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PreferenceManager @Inject constructor(
//    @Named(DiName.DISPATCHER_IO) private val dispatcher: CoroutineDispatcher,
    private val credentialDataStore: DataStore<CredentialPreference>,
    private val userDataStore: DataStore<UserPreference>,
    private val languageDataStore: DataStore<LanguagePreference>,
    private val themeDataStore: DataStore<ThemePreference>
) {
    fun getCredential(): Flow<Credential> {
        return credentialDataStore.data
            .map { Credential(it.token) }
            .catch { emit(Credential(token = "")) }
            .flowOn(Dispatchers.IO)
    }

    fun getUser(): Flow<User> {
        return userDataStore.data
            .map { User(it.email) }
            .catch { emit(User(email = "")) }
            .flowOn(Dispatchers.IO)
    }

    fun getTheme(): Flow<Theme> {
        return themeDataStore.data.map { it.toTheme() }
            .catch { emit(Theme.SYSTEM) }
            .flowOn(Dispatchers.IO)
    }

//    fun getLanguage(): Flow<Language> {
//        return languageDataStore.data.map { it.toLanguage() }
//            .catch { emit(Language.ENGLISH) }
//            .flowOn(dispatcher)
//    }

    suspend fun setCredential(data: Credential) {
        withContext(Dispatchers.IO) {
            credentialDataStore.updateData {
                CredentialPreference(data.token)
            }
        }
    }

    suspend fun setUser(data: User) {
        withContext(Dispatchers.IO) {
            userDataStore.updateData {
                UserPreference(data.email)
            }
        }
    }

    suspend fun setTheme(data: Theme) {
        withContext(Dispatchers.IO) {
            themeDataStore.updateData {
                data.toThemePreference()
            }
        }
    }

//    suspend fun setLanguage(data: Language) {
//        withContext(dispatcher) {
//            languageDataStore.updateData {
//                data.toLanguagePreference()
//            }
//        }
//    }
}