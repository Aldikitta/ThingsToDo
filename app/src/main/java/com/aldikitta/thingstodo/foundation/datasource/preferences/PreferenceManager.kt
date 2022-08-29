package com.aldikitta.thingstodo.foundation.datasource.preferences

import androidx.datastore.core.DataStore
import com.aldikitta.thingstodo.foundation.di.DiName
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class PreferenceManager @Inject constructor(
    @Named(DiName.DISPATCHER_IO) private val dispatcher: CoroutineDispatcher,
//    private val credentialDataStore: DataStore<CredentialPr>
){
}