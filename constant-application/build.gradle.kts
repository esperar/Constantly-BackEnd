plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

dependencies {


}

allOpen {
    annotation("esperer.common.annotation.UseCase")
    annotation("esperer.common.annotation.ReadOnlyUseCase")
    annotation("esperer.common.annotation.Service")
    annotation("esperer.common.annotation.DomainService")
}