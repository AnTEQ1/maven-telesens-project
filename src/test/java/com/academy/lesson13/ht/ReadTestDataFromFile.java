package com.academy.lesson13.ht;

import com.academy.telesens.util.PropertyProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadTestDataFromFile {

    public List<List<String>> readData() {
        String pathToFile = PropertyProvider.get("auth.file");
        String line;
        String csvSplitter = ";";
        List<List<String>> fullDataSet = new ArrayList<>();
        List<String> row;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(pathToFile))) {
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    continue;
                }
                row = Arrays.asList(line.split(csvSplitter));
                fullDataSet.add(row);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fullDataSet;
    }
}
