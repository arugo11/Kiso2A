/**
 * @file : FileUtil.java
 */

package my_util;

import java.io.*;

public class FileUtil {
    /**
     * ファイルを読み込む関数
     * @param filename 読み込むファイル名
     * @return 各行の末尾に改行文字を加えた文字列
     */
    public static String readTextFile(String filename){
        try{
            String line;
              BufferedReader br =
                new BufferedReader(
                    new FileReader(filename));
            StringBuilder text = new StringBuilder();
            while((line = br.readLine()) != null){
                text.append(line).append("\n");
            }
            br.close();
            return text.toString();
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 文字コードを指定してファイルを読み込む関数
     * @param filename 読み込むファイル名
     * @param enc 文字コードの指定
     * @return 各行の末尾に改行文字加えた文字列
     */
    public static String readTextFile(String filename, String enc){
        try{
            String line;
            BufferedReader br =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(filename),enc));
        StringBuilder text = new StringBuilder();
        while((line = br.readLine()) != null){
           text.append(line).append("/n");
        }
        br.close();
        return text.toString();
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
}
    /**
     * ファイル名を書き出す関数
     * @param data ファイルに書き出す内容
     * @param filename 書き出すファイル名
     */
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
    /**
     * 文字コードを指定してファイル名を書き出す関数
     * @param data ファイルに書き出す内容
     * @param filename 書き出すファイル名
     * @param enc 文字コード
     */
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
