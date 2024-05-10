plugins {
    `kotlin-dsl`
}

group = "com.jhebler.runiqueapp.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "runiqueapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "runiqueapp.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}