package com.jhebler.auth.presentation.register

import com.jhebler.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}