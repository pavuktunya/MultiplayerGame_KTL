package com.example.server

import com.badlogic.gdx.ApplicationAdapter
import com.example.server.websocket.WebSocketHandler
import org.springframework.stereotype.Component

@Component
class GameLoop: ApplicationAdapter() {
    private lateinit var socketHandler:WebSocketHandler
    override fun create() {
        //socketHandler=WebSocketHandler()
    }

    override fun render() {
    }

    override fun dispose() {
        //код освобождения ресурсов
        super.dispose()
    }
}