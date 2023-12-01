package com.example.server.websocket

import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession

interface MessageListener {
    fun handle(session: WebSocketSession, message: String)
}