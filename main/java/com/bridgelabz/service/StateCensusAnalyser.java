package com.bridgelabz.service;


import com.bridgelabz.exception.StateCensusAnalyserException;
import com.bridgelabz.model.CSVState;
import com.bridgelabz.model.CSVStateCensus;
import com.bridgelabz.utility.OpenCsvBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


public class StateCensusAnalyser {
    int countRecord = 0;

    //Reading the data from csv file
    public int loadCensusCsvData(String SAMPLE_CSV_PATH) throws StateCensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));) {
            Iterator<CSVStateCensus> censusCSVIterator = new OpenCsvBuilder().getCSVFileIterator(reader, CSVStateCensus.class);
            while (censusCSVIterator.hasNext()) {
                CSVStateCensus csvStateCensus = censusCSVIterator.next();
                countRecord++;
            }
            return countRecord;
        } catch (IOException e) {
            throw new StateCensusAnalyserException
                    (StateCensusAnalyserException.Exceptiontype.ENTERED_WRONG_FILE, e.getMessage());
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException
                    (StateCensusAnalyserException.Exceptiontype.ENTERED_INCORRECT_DELIMITER_OR_HEADER, e.getMessage());
        }
    }

    //Reading the data from statecode file
    public int loadSateCodeCsvData(String CSV_PATH) throws StateCensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));) {
            Iterator<CSVState> csvStatesCodeIterator = new OpenCsvBuilder()
                    .getCSVFileIterator(reader, CSVState.class);

            while (csvStatesCodeIterator.hasNext()) {
                countRecord++;
                CSVState csvStates = csvStatesCodeIterator.next();
            }
            return countRecord;
        } catch (IOException e) {
            throw new StateCensusAnalyserException
                    (StateCensusAnalyserException.Exceptiontype.ENTERED_WRONG_FILE, e.getMessage());
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException
                    (StateCensusAnalyserException.Exceptiontype.ENTERED_INCORRECT_DELIMITER_OR_HEADER, e.getMessage());
        }
    }
    //Read file extension
    public static void getFileExtension(File file) throws StateCensusAnalyserException {
        String extension = "";
        if (file != null) {
            String name = file.getName();
            extension = name.substring(name.lastIndexOf("."));
            if (!extension.equals(".csv")) {
                throw new StateCensusAnalyserException
                        (StateCensusAnalyserException.Exceptiontype.ENTERED_WRONG_FILE_TYPE, "FILE_TYPE_INCORRECT");
            }
        }
    }
}