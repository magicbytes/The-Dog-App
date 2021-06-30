package com.magicbytes.thedogapp_cv.utility

import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

data class AppCoroutineDispatchers @Inject constructor(
    val io: CoroutineContext,
    val cpu: CoroutineContext,
    val network: CoroutineContext,
    val ui: CoroutineContext
)
