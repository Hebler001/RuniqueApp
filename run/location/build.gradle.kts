plugins {
    alias(libs.plugins.runiqueapp.android.library)
}

android {
    namespace = "com.jhebler.run.location"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}