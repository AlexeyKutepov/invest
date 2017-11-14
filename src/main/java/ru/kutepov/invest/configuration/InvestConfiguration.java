package ru.kutepov.invest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.kutepov.invest.repository.BaseRepositoryImpl;

/**
 * Конфигурация приложения
 */
@Configuration
@EnableJpaRepositories(
    basePackages = {
        "ru.kutepov.invest.repository"
    },
    repositoryBaseClass = BaseRepositoryImpl.class
)
public class InvestConfiguration {
}