package esperer.constant.global.config

import esperer.constant.common.annotation.DomainService
import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.common.annotation.Service
import esperer.constant.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["esperer"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                UseCase::class,
                ReadOnlyUseCase::class,
                Service::class,
                DomainService::class
            ]
        )
    ]
)
class ComponentScanConfig