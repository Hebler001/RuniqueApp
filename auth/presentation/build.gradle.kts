plugins {
    alias(libs.plugins.runiqueapp.android.feature.ui)
}

android {
    namespace = "com.jhebler.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}