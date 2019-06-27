package com.ning.springboot.test;

import java.io.*;
import java.util.ArrayList;

/**
 * Create By : an
 * Time : 2019/2/28 15:56
 * Description :
 */
public class TestCopyFile {
//    public static void main(String[] args) throws IOException {
//
//        File f = new File("D:\\text1.txt");
//        InputStreamReader read = new InputStreamReader(new FileInputStream(f), "GBK");
//        BufferedReader br = new BufferedReader(read);
//        ArrayList<String> list = new ArrayList<>();
//
//        String line;
//        while((line = br.readLine()) != null) {
//            list.add(line);
//        }
//        br.close();
//
//        System.out.println(list);
//
//        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream("D:\\text2.txt"), "GBK");
//        BufferedWriter bw = new BufferedWriter(write);
//        for (int i = list.size() - 1; i >= 0; i--) {
//            bw.write(list.get(i));
//            bw.newLine();
//        }
//
//        bw.close();
//    }

    /**
     *  * @param args
     *  
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        File file;
        FileReader fils = null;
        BufferedReader br = null;
        String str;
        ArrayList<String> List = new ArrayList<String>();
        try {

            String path = "D:\\text1.txt";
            file = new File(path);
            fils = new FileReader(file);
            br = new BufferedReader(fils);
            str = null;
            while ((str = br.readLine()) != null) {
                List.add(str );

            }
        } catch (IOException e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fils.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        File file1;
        FileWriter filew = null;
        BufferedWriter bw = null;
        String list[];
        try {

            file1 = new File("D:\\text2.txt");
            filew = new FileWriter(file1);
            bw = new BufferedWriter(filew);
            list = new String[List.size()];
            for (int i = 0; i < list.length; i++) {
                list[i] = List.get(i).toString();
            }
            for (int i = 0; i < list.length - 1; i++) {
                System.out.println(list[i]);
//System.out.println(list[list.length-1]);
            }

            for (int i = list.length - 1; i >= 0; i--)//list数组中有一行空串。所以list.length-1;
            {

                bw.write(list[i]);
                bw.newLine();

            }

        } catch (IOException e) {
// TODO: handle exception
        } finally {

            try {
                bw.flush();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                bw.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                filew.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
