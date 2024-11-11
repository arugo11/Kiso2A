/**
 * @file : MyNKF.java
 */

 import my_util.FileUtil;
 import java.util.Scanner;
 import java.io.UnsupportedEncodingException;
 
 public class MyNKF {
     public static void main(String[] args){
         int argc = args.length;
         String utf_8 = "UTF-8";String sjis = "SJIS";
         if(argc < 1 ){usage();} /*コマンドライン引数不足 */
         else{
             if(argc == 1) {
                 if(args[0].equals("-g")) {
                     /*標準入力からの判別*/
                     Scanner scanner = new Scanner(System.in);
                     StringBuilder input = new StringBuilder();
                     while(scanner.hasNextLine()) {
                         input.append(scanner.nextLine()).append("\n");
                     }
                     scanner.close();
                     System.out.println(detectEncoding(input.toString()));
                     return;
                 } else if(args[0].equals("-s") || args[0].equals("-w")) {
                     /*標準入力からの変換*/
                     Scanner scanner = new Scanner(System.in);
                     StringBuilder input = new StringBuilder();
                     while(scanner.hasNextLine()) {
                         input.append(scanner.nextLine()).append("\n");
                     }
                     scanner.close();
                     try {
                         if(args[0].equals("-s")) {
                             byte[] bytes = input.toString().getBytes(utf_8);
                             System.out.print(new String(bytes, sjis));
                         } else {
                             byte[] bytes = input.toString().getBytes(sjis);
                             System.out.print(new String(bytes, utf_8));
                         }
                     } catch(UnsupportedEncodingException e) {
                         e.printStackTrace();
                     }
                     return;
                 }
                 usage();
                 return;
             }
             if(argc > 1){
                 /*入力ファイルあり */
                 String in_file_name;
                 if(args[0].equals("-g")) {
                     /*文字コード判別モード*/
                     System.out.println(detectEncoding(FileUtil.readTextFile(args[1])));
                     return;
                 }
                 if(args[1].equals("-O") && argc == 4){
                     /*出力ファイルあり */
                     String out_file_name = args[3];
                     in_file_name = args[2];
                     String content;
                     if(args[0].equals("-s")) {
                         try {
                             content = FileUtil.readTextFile(in_file_name);
                             byte[] bytes = content.getBytes(utf_8);
                             FileUtil.writeTextFile(new String(bytes, sjis), out_file_name);
                         } catch(UnsupportedEncodingException e) {
                             e.printStackTrace();
                         }
                     } else if(args[0].equals("-w")) {
                         try {
                             content = FileUtil.readTextFile(in_file_name);
                             byte[] bytes = content.getBytes(sjis);
                             FileUtil.writeTextFile(new String(bytes, utf_8), out_file_name);
                         } catch(UnsupportedEncodingException e) {
                             e.printStackTrace();
                         }
                     }else{usage();}
                     return;
                 }
                 in_file_name = args[1];
                 try {
                     String content = FileUtil.readTextFile(in_file_name);
                     if(args[0].equals("-s")) {
                         System.out.print(new String(content.getBytes(utf_8), sjis));
                     } else if(args[0].equals("-w")) {
                         System.out.print(new String(content.getBytes(sjis), utf_8));
                     }
                 } catch(UnsupportedEncodingException e) {
                     e.printStackTrace();
                 }
                 return;
             }
             usage();
         }
     }
 
     private static String detectEncoding(String text) {
         String utf_8 = "UTF-8";String sjis = "SJIS";
         try {
             String original = text;
             // SJIS判定
             if(original.equals(characterCode(text, sjis))) {
                 return sjis;
             }
             // UTF-8判定
             if(original.equals(characterCode(text, utf_8))) {
                 return utf_8;
             }
             return "ASCII";
         } catch(UnsupportedEncodingException e) {
             e.printStackTrace();
             return "Error";
         }
     }
 
     private static String characterCode(String str, String charCode) throws UnsupportedEncodingException {
         byte[] tmp = str.getBytes(charCode);
         return new String(tmp);
     }
 
     static void usage() {
         System.out.println(
             "- java MyNKF {-s | -w}\n" +
             "    標準入力から読み込んだデータの文字コードを変換し、標準出力へ書き出す\n" +
             "- java MyNKF {-s | -w} 入力ファイル名\n" +
             "    入力ファイルから読み込んだデータの文字コードを変換し、標準出力へ書き出す。\n" +
             "- java MyNKF {-s | -w} -O 入力ファイル名 出力ファイル名\n" +
             "    入力ファイルから読み込んだデータの文字コードを変換し、出力ファイルへ書き出す\n" +
             "- java MyNKF -g\n" +
             "    標準入力から読み込んだデータの文字コードを自動で判別する\n" +
             "    (出力は\"SJIS\", \"UTF-8\", \"ASCII\"のどれか)\n" +
             "- java MyNKF -g 入力ファイル名\n" +
             "    入力ファイルの文字コードを自動判別する\n" +
             "    (出力は\"SJIS\",\"UTF-8\",\"ASCII\"のどれか)\n"
         );
     }
 }