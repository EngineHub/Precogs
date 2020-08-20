import net.minecrell.gradle.licenser.LicenseExtension

plugins {
    id("java-library")
}

applyPlatformAndCoreConfiguration()

configurations.all {
    resolutionStrategy {
        force("com.google.guava:guava:21.0")
    }
}

dependencies {
    "implementation"("com.google.guava:guava:${Versions.GUAVA}")
}

configure<LicenseExtension> {
    exclude {
        it.file.startsWith(project.buildDir)
    }
}

sourceSets.named("main") {
    java {
        srcDir("src/main/java")
    }
    resources {
        srcDir("src/main/resources")
    }
}
