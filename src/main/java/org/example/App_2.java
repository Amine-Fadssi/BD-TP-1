package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App_2 {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:8020");

        FileSystem fs = FileSystem.get(conf);
        FSDataInputStream fdis = fs.open(new Path("/file1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fdis));

        String line = null;

        while ((line= br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
