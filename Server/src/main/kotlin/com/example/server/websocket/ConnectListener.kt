package com.example.server.websocket

import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.sockjs.client.WebSocketClientSockJsSession
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession

interface ConnectListener {
    fun handle(session: WebSocketSession)
}