plugins {
    alias(libs.plugins.runiqueapp.android.library)
}

android {
    namespace = "com.jhebler.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
}