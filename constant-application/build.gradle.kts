plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

allOpen {
    annotation("esperer.common.annotation.UseCase")
    annotation("esperer.common.annotation.ReadOnlyUseCase")
}