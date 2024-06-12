package com.jhebler.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import java.util.Properties

val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.apiKeyProperties: Properties
    get() {
        val keystoreFile = project.rootProject.file("apikeys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        return properties
    }