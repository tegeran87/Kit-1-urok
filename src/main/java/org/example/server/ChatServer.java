package org.example.server;

import java.util.logging.Logger;

public class ChatServer implements ServerSocketThreadListener {
    private final ServerListener serverListener;
    private final ServerSocketThreadListener serverServerSocketThreadListener;
    private static boolean isServerWorking;
    private static ServerManagementWindow serverManagementWindow;

    public ChatServer(ServerListener serverListener, ServerSocketThreadListener serverServerSocketThreadListener) {
        this.serverListener = serverListener;
        this.serverServerSocketThreadListener = serverServerSocketThreadListener;
        serverManagementWindow = new ServerManagementWindow(this);
    }

    public ChatServer(ServerSocketThreadListener serverServerSocketThreadListener) {
        this.serverServerSocketThreadListener = serverServerSocketThreadListener;
        serverManagementWindow = new ServerManagementWindow(this);
        serverListener = serverManagementWindow;
    }

    public void start() {
        serverActed("Server received start command");
        serverServerSocketThreadListener.serverActed("button Start pressed");
        String message;
        if (isServerWorking) {
            message = "Server is already running.";
        } else {
            isServerWorking = true;
            message = "Server started.";
        }
        serverListener.receiveMessage(message);
    }

    public void stop() {
        serverActed("received stop command");
        serverServerSocketThreadListener.serverActed("button Stop pressed");
        String message;
        if (!isServerWorking) {
            message = "Server is already stopped.";
        } else {
            isServerWorking = false;
            message = "Server stopped.";
        }
        serverListener.receiveMessage(message);
    }

    @Override
    public void serverActed(String message) {
        Logger logger = Logger.getLogger(ChatServer.class.getName());

        logger.info("Server: " + message);
    }
}
