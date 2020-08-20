import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
}

applyPlatformAndCoreConfiguration()
applyShadowConfiguration()

repositories {
    maven { url = uri("https://hub.spigotmc.org/nexus/content/groups/public") }
    maven { url = uri("https://repo.codemc.org/repository/maven-public") }
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

configurations.all {
    resolutionStrategy {
        force("com.google.guava:guava:21.0")
    }
}

dependencies {
    "api"(project(":precogs-core"))
    "api"("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT") {
        exclude("junit", "junit")
    }
    "compileOnly"("org.jetbrains:annotations:19.0.0")
    "implementation"("org.bstats:bstats-bukkit:1.7")
    "testImplementation"("org.mockito:mockito-core:1.9.0-rc1")
}

tasks.named<Copy>("processResources") {
    filesMatching("plugin.yml") {
        expand("internalVersion" to project.ext["internalVersion"])
    }
}

addJarManifest()

tasks.named<ShadowJar>("shadowJar") {
    dependencies {
        include(dependency(":precogs-core"))
        relocate("org.bstats", "org.enginehub.precogs.bukkit.bstats") {
            include(dependency("org.bstats:bstats-bukkit:1.7"))
        }
    }
}

tasks.named("assemble").configure {
    dependsOn("shadowJar")
}
