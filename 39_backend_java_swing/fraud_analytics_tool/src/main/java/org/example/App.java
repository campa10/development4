package org.example;

import java.io.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        try{
            //System.out.println( "Hello World!" );
            App app = new App();
            app.mainGate();
        }catch (Exception ee){
            System.out.println(ee.getMessage());
        }
    }

    private void mainGate() throws IOException {
        //System.out.println(getOS() + " -- " + userAuthorized("c70091a"));
        fetchFfraudEvents();
    }

    private String getOS() {
        return System.getProperty("os.name");
    }

    private String getLoggedOsUser() {
        return System.getProperty("user.name");
    }

    private boolean userAuthorized(String loggedOsUser) {
        boolean validUser = false;
        Hashtable<Integer, String> hm = new Hashtable<Integer, String>();

        hm.put(1, "c70091a");
        hm.put(2, "Ravi");
        hm.put(3, "Vijay");
        hm.put(4, "Rahul");

        for (Map.Entry m : hm.entrySet()) {
            //System.out.println(m.getKey() + " " + m.getValue());
            if (m.getValue().toString().toLowerCase().equals(loggedOsUser.toLowerCase())) {
                validUser = true;
            }
        }
        return validUser;
    }

    private void fetchFfraudEvents() {
        try{
            String fileName = "artifact1.jar";
            // Run a java app in a separate system process
            //ClassLoader classLoader = getClass().getClassLoader();
            //File file = new File(classLoader.getResource(fileName).getFile());
            //Process proc = Runtime.getRuntime().exec("java -jar " + file);
            //System.out.println("java -jar " + file);

            //Process proc = Runtime.getRuntime().exec(" java -jar " +  " ./src/main/resources/artifact1.jar");
            Process proc = Runtime.getRuntime().exec(" java -jar " +  "\\C:\\temp\\FNEventValidator_08312021.jar");

            // Then retreive the process output
            //InputStream in = proc.getInputStream();
            //InputStream err = proc.getErrorStream();/
            //InputStream fraudJar = getClass().getClassLoader().getResourceAsStream("artifact1.jar");
            //String executionPath = System.getProperty("user.dir");

            //InputStream inputStream = this.getClass().getResourceAsStream("/file.txt");
            //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            //FileReader fileReader = new FileReader("src/main/resources/");
            //BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Runtime.getRuntime().exec( + "ajava -jar artifact1.jar");
            //System.out.println(bufferedReader);

            //URL url = this.getClass().getClassLoader().getResource("");
        }catch (Exception ee){

            System.out.println(ee.getMessage());

        }
    }
}
