package com.magicbytes.thedogapp_cv.utils

import com.magicbytes.thedogapp_cv.utility.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers

object UtilityMocks {
    fun provideCoroutineDispatchers(): AppCoroutineDispatchers {
        return AppCoroutineDispatchers(Dispatchers.Main, Dispatchers.Main, Dispatchers.Main, Dispatchers.Main)
    }
}
