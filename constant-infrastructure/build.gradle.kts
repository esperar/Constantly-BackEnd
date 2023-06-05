plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGE
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN
    kotlin("plugin.jpa") version PluginVersions.JPA
}

dependencies {
    implementation(Dependencies.SPRING_WEB)
    implementation(Dependencies.VALIDATION)
    implementation(Dependencies.SPRING_STARTER_SECURITY)
    implementation(Dependencies.SPRING_STARTER_JPA)
    runtimeOnly(Dependencies.MYSQL)
    implementation(Dependencies.KOTLIN_JACKSON)
    implementation(Dependencies.SENTRY)

    implementation(project(":constant-application"))
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
    annotation("com.pickdsm.pickserverspring.global.annotation.NoArg")
}