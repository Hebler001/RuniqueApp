plugins {
    alias(libs.plugins.runiqueapp.android.library)
}

android {
    namespace = "com.jhebler.core.database"
}

dependencies {
    implementation(projects.core.domain)
}