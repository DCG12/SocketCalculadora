package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InterfaceAddress;
import java.net.Socket;

/**
 * Created by 46406163y on 08/02/17.
 */
public class HiloPeticion extends Thread {

    private Socket newsocket;

    public HiloPeticion(Socket e){
        this.newsocket = e;
    }

    @Override
    public void run() {

        InputStream is = null;

        try {

            is = newsocket.getInputStream();
            OutputStream os = newsocket.getOutputStream();

            byte[] n1 = new byte[is.available()];
            is.read(n1);

            String mes = new String (n1);

            if(mes.contains("+")){
            String[] parts = mes.split("\\+");
            Double resultado = null;
            resultado = Double.valueOf(parts[0])+Double.valueOf(parts[1]);
            System.out.println(" ");
            System.out.println("EL RESULTADO ES: " + resultado);
            }

            else if(mes.contains("-")){
                String[] parts = mes.split("-");
                Double resultado = null;
                resultado = Double.valueOf(parts[0])-Double.valueOf(parts[1]);
                System.out.println(" ");
                System.out.println("EL RESULTADO ES: " + resultado);
            }

            else if(mes.contains("*")){
                String[] parts = mes.split("\\*");
                Double resultado = null;
                resultado = Double.valueOf(parts[0])*Double.valueOf(parts[1]);
                System.out.println(" ");
                System.out.println("EL RESULTADO ES: " + resultado);
            }

            else if(mes.contains("/")){
                String[] parts = mes.split("/");
                Double resultado = null;
                resultado = Double.valueOf(parts[0])/Double.valueOf(parts[1]);
                System.out.println(" ");
                System.out.println("EL RESULTADO ES: " + resultado);
            }

            System.out.println(" ");
            System.out.println("cerrando el socket");
            newsocket.close();
            System.out.println("cerrando el socket servidor");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
