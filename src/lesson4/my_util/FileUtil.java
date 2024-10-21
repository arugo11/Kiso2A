package my_util;

import java.io.*;

public class FileUtil {
    public static String readTextFile(String filename){
        try{
            String line;
            String text = "";
              BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(filename),"SJIS"));
            while((line = br.readLine()) != null){
                text += line + "\n";
            }
            System.out.println(text);
            br.close();
            return text;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String readTextFile(String filename, String enc){
        try{
            String line;
            String text = "";
            BufferedReader br =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(filename),enc));
        while((line = br.readLine()) != null){
            text += line + "\n";
        }
        System.out.println(text);
        br.close();
        return text;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
}

    public static void writeTextFile(String data, String filename){ 
        try{
            PrintWriter pw =
                new PrintWriter(
                    new BufferedWriter(
                        new FileWriter(filename)
                    )
                );

            pw.println(data);
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTextFile(String data, String filename, String enc){
        try{
            PrintWriter pw =
            new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(filename),enc
                    )
                )
            );
    
        pw.println(data);
        pw.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
