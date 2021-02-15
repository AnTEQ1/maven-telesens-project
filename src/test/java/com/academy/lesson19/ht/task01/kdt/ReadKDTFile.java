package com.academy.lesson19.ht.task01.kdt;

import com.academy.telesens.util.PropertyProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadKDTFile {

    public List<String[]> readData() {
        String pathToFile = PropertyProvider.get("kdt.file");
        String line;
        String csvSplitter = ";";
        List<String[]> fullDataSet = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(pathToFile))) {
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    continue;
                }
                String[] readRow = line.split(csvSplitter);
                fullDataSet.add(readRow);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fullDataSet;
    }
}
