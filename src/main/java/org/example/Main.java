package org.example;

import org.example.client.Client;
import org.example.server.ChatServer;
import org.example.server.ClientSocketListenerImpl;
import org.example.server.ServerListenerImpl;
import org.example.task3.*;

import java.util.ArrayList;
import java.util.List;

// 1. Необходимо вынести логику работы сервера в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и журналирования сообщений от сервера.
//    Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
//    «получить сообщение», вызывать его с одной стороны, и реализовать с другой.


// 2.Создать интерфейсы ServerSocketThreadListener и SocketThreadListener, содержащие методы, соответствующие событиям сервера и клиента чата.
// Реализовать созданные интерфейсы простым логированием. Со стороны клиента – только SocketThreadListener,со стороны сервера – оба интерфейса.

//3. Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
//которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы, и фуллстэк разработчики, совмещающие в себе обе компетенции.
//Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
//все его методы.

//Дописать третье задание таким образом, чтобы в идентификатор типа Developer записывался объект Frontender, и далее вызывался метод developGUI(),
// не изменяя существующие интерфейсы, только код основного класса.
//public static void main(String[] args) {

public class Main {
    public static void main(String[] args) {
        //Имплементация вывода в консль
        //new ChatServer(new ServerListenerImpl(), new ClientSocketListenerImpl());
        new ChatServer(new ClientSocketListenerImpl());
        new Client();


        //task3
        FullstackDeveloper fullstackDeveloper = new FullstackDeveloper("Pavel", "Java Spring Boot", "Angular");
        fullstackDeveloper.developBackend();
        fullstackDeveloper.developGUI();

        List<Developer> list = new ArrayList<>();
        list.add(new FrontenderImpl("Roman", "JavaScript"));
        list.add(new BackenderImpl("Boris", "Java"));
        list.add(new BackenderImpl("Mariia", "PHP"));
        list.add(new FrontenderImpl("Katya", "React JS"));
        list.add(new BackenderImpl("Pavel", "Java"));
        list.add(new FrontenderImpl("Alex", "Angular"));
        list.add(new BackenderImpl("Petr", "C#"));

        for (Developer developer : list) {
            if (developer instanceof Frontender) {
                ((Frontender) developer).developGUI();
            } else {
                System.out.println("Developer " + developer.getName() + " is not frontend developer.");
            }
        }
    }
}