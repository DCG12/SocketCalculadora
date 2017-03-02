package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 46406163y on 08/02/17.
 */
public class SocketServidor {

        public static void main(String[] args) {

            try{
                System.out.println("creando servidor");

                ServerSocket serverSocket = new ServerSocket();

                System.out.println("realizando el bind (.3vinculo)");

                InetSocketAddress addr = new InetSocketAddress("localhost", 5125);
                serverSocket.bind(addr);

                System.out.println("aceptando conexiones");

                while(true) {

                    Socket newsocket = serverSocket.accept();

                    HiloPeticion hp = new HiloPeticion(newsocket);
                    hp.start();
                    System.out.println("Conexion recibida");
                }
                //serverSocket.close();

            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

}
