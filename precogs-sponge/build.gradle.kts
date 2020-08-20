import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("org.spongepowered.plugin")
}

applyPlatformAndCoreConfiguration()
applyShadowConfiguration()

repositories {
    maven { url = uri("https://repo.codemc.org/repository/maven-public") }
}

dependencies {
    compile(project(":precogs-core"))
    compile("org.spongepowered:spongeapi:7.1.0")
    compile("org.bstats:bstats-sponge:1.7")
    testCompile("org.mockito:mockito-core:1.9.0-rc1")
}

sponge {
    plugin {
        id = "precogs"
        version = project(":precogs-core").version
    }
}

addJarManifest()

tasks.named<ShadowJar>("shadowJar") {
    dependencies {
        relocate ("org.bstats", "org.enginehub.precogs.sponge.bstats") {
            include(dependency("org.bstats:bstats-sponge:1.7"))
        }
    }
}

if (project.hasProperty("signing")) {
    apply(plugin = "signing")

    configure<SigningExtension> {
        sign("shadowJar")
    }

    tasks.named("build").configure {
        dependsOn("signShadowJar")
    }
}
