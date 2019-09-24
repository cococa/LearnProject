package com.cocoa.test.io;

import com.cocoa.test.Constanct;

import java.io.*;
import java.net.Socket;

public class ServerClientTest1 {

    public static void main(String[] args) {


        System.out.println("1".equals(null));




        try {
            Socket socket = new Socket(Constanct.ADDRESS,Constanct.PORT);

            OutputStream outputStream = socket.getOutputStream();


            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                if (isConented(socket)) {
                    String str = wt.readLine();
                    out.println(str);
                    out.flush();
                    if (str.equals("end")) {
                        break;
                    }
                    System.out.println(in.readLine());
                }else{
                    System.out.println("is offline ");
                    break;
                }
            }
            socket.close();

//
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//
//            bufferedWriter.write("hahahaha,bendan1 ");
//            bufferedWriter.write("hahahaha,bendan2 ");
//            bufferedWriter.write("hahahaha,bendan3 ");
//            bufferedWriter.write("hahahaha,bendan4**");
//
//
//            bufferedWriter.close();
//
//
//
//            InputStream inputStream = socket.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//            String result;
//            while ((result = bufferedReader.readLine()) != null) {
//                System.out.println(result);
//                if(result.endsWith("**")){
//                break;}
//            }
//
//            bufferedReader.close();
//            inputStream.close();
//
//            outputStream.close();
//            socket.close();





        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static boolean isConented(Socket socket) {
        return socket.isConnected() && !socket.isClosed();
    }


}
