package com.example.server.config

import com.example.server.websocket.ConnectListener
import com.example.server.websocket.DisconnectListener
import com.example.server.websocket.MessageListener
import com.example.server.websocket.WebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.config.annotation.WebSocketConfigurer as WebSocketConfigurer1

@Configuration
@EnableWebSocket
class WebSocketConfig(
private val connectListener: ConnectListener,
private val disconnectListener: DisconnectListener,
private val messageListener: MessageListener
): WebSocketConfigurer1
{
    private val webSocketHandler =WebSocketHandler(connectListener, disconnectListener, messageListener)
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler, "/websocket").setAllowedOrigins("*")
        //в дальнейшем поправить
    }
}