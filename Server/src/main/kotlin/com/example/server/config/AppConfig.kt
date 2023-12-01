package com.example.server.config

import com.badlogic.gdx.backends.headless.HeadlessApplication
import com.example.server.GameLoop
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun getApplication() = HeadlessApplication(GameLoop())
}