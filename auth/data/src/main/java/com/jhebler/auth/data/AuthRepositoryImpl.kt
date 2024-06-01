package com.jhebler.auth.data

import com.jhebler.auth.domain.AuthRepository
import com.jhebler.core.data.networking.post
import com.jhebler.core.domain.util.DataError
import com.jhebler.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}