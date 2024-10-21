import my_util.*;

class Test04C {
    public static void main(String[] args){
        String str;
        //  デフォルト文字コードの読み書き
        str = FileUtil.readTextFile("input_default.txt");
        FileUtil.writeTextFile(str, "output_default.txt");

        //SJISのファイルを読んでUTF-8でファイル出力
        str = FileUtil.readTextFile("input_sjis.txt","SJIS");
        FileUtil.writeTextFile(str, "output_utf-8.txt","UTF-8");

        //UTF-8のファイルを読んでSJISでファイル出力
        str = FileUtil.readTextFile("input_uft8.txt","UTF-8");
        FileUtil.writeTextFile(str,"output_sjis.txt","SJIS");
    }
}
