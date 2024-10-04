package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class App_1 {

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:8020");

        FileSystem fileSystem = FileSystem.get(conf);
        FSDataOutputStream fsdos = fileSystem.create(new Path("/file1.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fsdos));

        bw.write("Bonjour SDIA M2");
        bw.write("Cours Big Data");
        bw.write("Fin");

        bw.close();
    }
}
