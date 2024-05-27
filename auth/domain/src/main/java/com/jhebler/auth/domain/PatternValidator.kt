package com.jhebler.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}