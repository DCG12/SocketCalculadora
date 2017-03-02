package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 46406163y on 01/02/17.
 */
public class SocketClient {

    public static void main(String[] args) {
        try{

            Scanner sc = new Scanner(System.in);

            System.out.println("Escriva la operación que quiere realizar sin espacios EJEMPLO: 32+41");

            String n1 = sc.next();

            System.out.println("Creamos un cliente (creando socket)");

            Socket cliente = new Socket();

            System.out.println("Estableciendo conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5125);

            cliente.connect(addr);

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            System.out.println("enviando mensaje");

            os.write(n1.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket del cliente");

            cliente.close();


            System.out.println("Terminado");


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
