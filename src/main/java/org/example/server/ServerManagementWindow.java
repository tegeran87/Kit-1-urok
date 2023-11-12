package org.example.server;

import org.example.server.ChatServer;
import org.example.server.ServerListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class ServerManagementWindow extends JFrame implements ServerListener, SocketThreadListener {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 250;
    private final JButton btnStart = new JButton("Start server");
    private final JButton btnStop = new JButton("Stop server");
    private final JTextArea log = new JTextArea("Server is stopped");
    private final ChatServer chatServer;


    public JTextArea getLog() {
        return log;
    }

    public ServerManagementWindow(ChatServer chatServer) {
        this.chatServer = chatServer;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setAlwaysOnTop(true);
        setTitle("Chat server");
        setResizable(false);

        add(log, BorderLayout.SOUTH);
        add(btnStart, BorderLayout.WEST);
        add(btnStop, BorderLayout.EAST);

        log.setEditable(false);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientActed("Button start is pressed");
                chatServer.start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientActed("Button stop is pressed");
                chatServer.stop();
            }
        });

        setVisible(true);

    }

    @Override
    public void receiveMessage(String message) {
        log.setText(message);
    }

    @Override
    public void clientActed(String message) {
        Logger logger = Logger.getLogger(ServerManagementWindow.class.getName());

        logger.info("Client: " + message);
    }
}
