package com.aldikitta.thingstodo.features.host.ui

import android.content.res.Resources
import com.aldikitta.thingstodo.model.Theme
import javax.annotation.concurrent.Immutable

@Immutable
data class HostState(val theme: Theme = Theme.SYSTEM)