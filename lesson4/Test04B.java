import java.io.*;

class Test04B{
    public static void main(String[] args){
        try{
            /*読み込み */
            FileInputStream fis = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(fis,"SJIS");
            BufferedReader br = new BufferedReader(isr);
            String line;

            PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter("output.txt")
                )
            );

            while ((line = br.readLine()) != null){
                System.out.println(line);
                pw.println(line);
            }


            br.close();
            pw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}