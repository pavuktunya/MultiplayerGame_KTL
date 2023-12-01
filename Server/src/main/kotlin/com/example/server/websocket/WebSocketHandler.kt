package com.example.server.websocket

import com.badlogic.gdx.utils.Array
import ktx.collections.gdxArrayOf
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.AbstractWebSocketHandler

@Component
class WebSocketHandler(
    private val connectListener:ConnectListener,
    private val disconnectListener:DisconnectListener,
    private val messageListener:MessageListener
): AbstractWebSocketHandler() {
    private var sessions: Array<WebSocketSession> = gdxArrayOf()
        get()=field



    override fun afterConnectionEstablished(session: WebSocketSession) {
        connectListener.handle(session)

        sessions.add(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {

        sessions.removeValue(session, true)
        //true это сравнение по ссылке
        disconnectListener.handle(session)
    }


    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        messageListener.handle(session, message.payload)
    }

}