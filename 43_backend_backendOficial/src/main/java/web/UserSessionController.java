package web;

import Entities.Login;
import Entities.UserSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

public class UserSessionController {

    private UUID uuid = null;
    UserSession userSession = null;

    public UserSession newSession(Login login){
        userSession = new UserSession();
        uuid = UUID.randomUUID();

        userSession.setSessionToken(uuid);
        userSession.setLoggedUser(login.getUserName());
        userSession.setLoginTime(Instant.now().toString()  );
        userSession.setMacAddress(getMacAddress());
        userSession.setExternalIpAddress(getIp());
        return userSession;
    }



    public String getIp() {
        BufferedReader in = null;
        String externalIp = null;
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            externalIp = ip;

        } catch (Exception ee) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  externalIp;
    }




    private InetAddress getMacAddress(){

        //InetAddress ip = null;
        InetAddress myIP = null;
        try {


            // First get InetAddress for the machine, here localhost
            try {
                myIP = InetAddress.getLocalHost();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // getHostAddress() returns IP address of a machine
            String IPAddress = myIP.getHostAddress();

            // getHostname returns DNS hostname of a machine
            String hostname = myIP.getHostName();

            System.out.printf("IP address of Localhost is %s %n", IPAddress);
            System.out.printf("Host name of your machine is %s %n", hostname);

            /*ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));}
            System.out.println(sb.toString());*/

        } catch (Exception e) {

            e.printStackTrace();
        }

        return myIP;
    }


}
