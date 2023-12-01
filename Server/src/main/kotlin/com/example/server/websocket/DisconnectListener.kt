package com.example.server.websocket

import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession

interface DisconnectListener {
    fun handle(session: WebSocketSession)
}