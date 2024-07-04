plugins {
    alias(libs.plugins.runiqueapp.android.feature.ui)
}

android {
    namespace = "com.jhebler.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}