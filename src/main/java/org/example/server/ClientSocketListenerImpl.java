package org.example.server;

import java.util.logging.Logger;

public class ClientSocketListenerImpl implements ServerSocketThreadListener {
    Logger logger = Logger.getLogger(ClientSocketListenerImpl.class.getName());

    @Override
    public void serverActed(String message) {
        logger.info("Client: " + message);
    }
}
