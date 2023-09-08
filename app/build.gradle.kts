plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    jacoco
}

android {
    namespace = "com.example.jacocohiltentrypointcoveragetestapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jacocohiltentrypointcoveragetestapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.jacocohiltentrypointcoveragetestapp.HiltTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }

    kotlin {
        jvmToolchain(17)
    }
}

jacoco {
    toolVersion = "0.8.10"
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest", "createDebugCoverageReport")

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    sourceDirectories.setFrom("${project.projectDir}/src/main/java")

    val excludes = emptyList<String>()

    val javaClasses = fileTree(
        mapOf(
            "dir" to "${buildDir}/intermediates/javac/debug",
            "excludes" to excludes
        )
    )

    val kotlinClasses = fileTree(
        mapOf(
            "dir" to "${buildDir}/tmp/kotlin-classes/debug",
            "excludes" to excludes
        )
    )

    classDirectories.setFrom(javaClasses, kotlinClasses)

    val execData = "${buildDir}/outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec"

    val ecData = fileTree(
        mapOf(
            "dir" to "${buildDir}/outputs/code_coverage/debugAndroidTest/connected/",
            "includes" to listOf("**/*.ec")
        )
    )

    executionData.setFrom(execData, ecData)
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")

    androidTestImplementation("org.mockito:mockito-android:5.5.0")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
}

kapt {
    correctErrorTypes = true
}
