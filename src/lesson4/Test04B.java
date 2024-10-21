import java.io.*;

class Test04B{
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(fis,"SJIS");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}