package com.bridgelabz.service;

import com.bridgelabz.exception.StateCensusAnalyserException;
import com.bridgelabz.model.CSVStateCensus;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    int countRecord = 0;
    ;

    //Reading and printing the data csv file
    public int loadCensusCSVData(String getPaths) throws  IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(getPaths));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            //POJO file iterate and printing the data of csv file.
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
            while (csvStateCensusIterator.hasNext()) {
                CSVStateCensus csvStateCensus = csvStateCensusIterator.next();
                System.out.println("State : " + csvStateCensus.State);
                System.out.println("Area: " + csvStateCensus.Population);
                System.out.println("Population : " + csvStateCensus.AreaInSqKm);
                System.out.println("DensityPerSqKm: " + csvStateCensus.DensityPerSqKm);
                countRecord++;
                System.out.println(countRecord);
            }

            return countRecord;
        }
    }
}