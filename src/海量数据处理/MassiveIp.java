package 海量数据处理;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class MassiveIp {
    /**
     * 海量日志数据，如何提取出某日访问淘宝次数最多的IP(淘宝可以是百度其他公司)
     *1、对大文件分类成小文件，使用ip的hashCode值来取模，取n的模就是分为n个小文件，相同的ip都会在同一个文件中
     * 2、使用hashMap来统计相同ip的个数，key值是ip，value是出现次数
     * 3、统计每个文件hashMap的value最大的值，然后选最大的
     */


        //generate the massive numbers of IPs
        public void generateIP(String fileName){
            PrintWriter out =null;
            try {

                out=new PrintWriter(fileName);
                String s;
                Random r=new Random();
                //向外面写一亿个数据
                for(int i=0;i<100000000;i++){
                    s="159.227.";
                    s+=r.nextInt(256)+"."+r.nextInt(256);
                    out.println(s);
                }


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally{
                if (out != null)
                    out.close( );
            }

        }
        //split the file to make it fit into the memory
        public void FileSplit(String fileName){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //100个通道向外面写出
            PrintWriter[] out=new PrintWriter[100];
            for(int i=0;i<100;i++)
                try {
                    //specify split file name
                    out[i]=new PrintWriter(fileName+i);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            String IP = null;
            try {
                while((IP =reader.readLine())!= null ) {
                    IP=reader.readLine();
                    int fileNum=IP.hashCode()%100;
                    fileNum=(fileNum>=0?fileNum:fileNum+100);
                    //	System.out.println(fileNum);
                    out[fileNum].println(IP);

                }
                for(int i=0;i<100;i++)
                    out[i].close();

                //}
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        //find IP with the largest number of occurrence
        public Map.Entry<String,Integer>  statitics(String fileName){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader (fileName));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            HashMap<String,Integer> map=new HashMap<String,Integer>();
            String IP = null;
            try {
                while((IP =reader.readLine())!= null){
                    //to judge whether the IP is already
                    //existed in the HashMap
                    if(map.containsKey(IP)){
                        map.put(IP, map.get(IP)+1);
                    }
                    else
                        map.put(IP,1);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //Entry in HashMap with the maximum value
            //which means the IP with the largest occurrence
            Map.Entry<String,Integer>  maxEntry=null;
            for (Map.Entry<String,Integer> entry : map.entrySet()){
                if (maxEntry == null || entry.getValue()>maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return maxEntry;
        }
        public static void main(String[] args){
            MassiveIp m=new MassiveIp();
            String FileName="D://Data//test.txt";
            m.generateIP(FileName);
            m.FileSplit(FileName);
            List<Map.Entry<String,Integer>> l
                    =new ArrayList<Map.Entry<String,Integer>>();
            for(int i=0;i<100;i++)
                l.add(m.statitics(FileName+i));
            Map.Entry<String,Integer>maxEntry=l.get(0);
            for(int j=1;j<100;j++){
                if(l.get(j).getValue()>maxEntry.getValue())
                    maxEntry=l.get(j);
            }
            System.out.println(maxEntry.getKey());
            System.out.println(maxEntry.getValue());
        }


}
