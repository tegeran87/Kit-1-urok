package org.example.server;

import org.example.server.ServerListener;

public class ServerListenerImpl implements ServerListener {
    @Override
    public void receiveMessage(String message) {
        System.out.println("Message: " + message);
    }
}
