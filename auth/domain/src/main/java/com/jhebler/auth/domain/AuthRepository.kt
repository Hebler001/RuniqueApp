package com.jhebler.auth.domain

import com.jhebler.core.domain.util.DataError
import com.jhebler.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}