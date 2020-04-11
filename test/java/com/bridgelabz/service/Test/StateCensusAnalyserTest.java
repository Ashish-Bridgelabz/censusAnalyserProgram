package com.bridgelabz.service.Test;

import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.exception.StateCensusAnalyserException;
import com.bridgelabz.service.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class StateCensusAnalyserTest {
    StateCensusAnalyser stateCensusAnalyser;
    String STATE_CSV_FILE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCensusData.csv";
    String STATE_CSV_WRONG_FILE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/tested/resources/IndiaStateCensusData.csv";
    String STATE_CSV_WRONG_FILE_TYPE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCensusData.txt";
    String STATE_CSVFILE_DELIMITERINCORRECT_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCensusData1.csv";
    String STATE_CSVHEADER_INCORRECT_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCensusData2.csv";
    //CSV State code file path
    String CSV_STATE_CODE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCode.csv";
    String INCORRECT_CSV_STATE_CODE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/tested/resources/IndiaStateCode.csv";
    String INCORRECT_EXTENSION_CSV_STATE_CODE = "test/resources/IndiaStateCode.pdf";
    String INCORRECT_IN_DELIMITER_CSV_STATE_CODE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCode1.csv";
    String INCORRECT_IN_HEADER_CSV_STATE_CODE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCode2.csv";

    @Test
    public void givenStateCensusCSVFile_WhenTrue_NumberOfRecordShouldMatch() throws StateCensusAnalyserException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        int countRecord = stateCensusAnalyser.loadCensusCsvData(STATE_CSV_FILE_PATH);
        Assert.assertEquals(countRecord, 29);
    }

    @Test
    public void givenStateCensusCsvFile_WhenIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadCensusCsvData(STATE_CSV_WRONG_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_WRONG_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenTypeIncorrect_ShouldReturnCustomException() {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            StateCensusAnalyser.getFileExtension(new File(STATE_CSV_WRONG_FILE_TYPE_PATH));
        } catch ( CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFileCorrect_WhenDelimiterIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadCensusCsvData(STATE_CSVFILE_DELIMITERINCORRECT_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenCorrectButCsvHeaderIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadCensusCsvData(STATE_CSVHEADER_INCORRECT_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_INCORRECT_DELIMITER, e.type);
        }
    }

    @Test
    public void givenStateCensusCode_WhenTrue_NumberOfRecordShouldBeMatch() throws IOException, StateCensusAnalyserException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        int countRecord = stateCensusAnalyser.loadSateCodeCsvData(CSV_STATE_CODE_PATH);
        Assert.assertEquals(countRecord, 37);
    }

    @Test
    public void givenStateCodeCsvFile_WhenIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadSateCodeCsvData(INCORRECT_CSV_STATE_CODE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_WRONG_FILE, e.type);
        }
    }

    @Test
    public void givenStateCodeCsvFile_WhenTypeIncorrect_ShouldThrowCustomException() {
        try {
            File fileExtension = new File(INCORRECT_EXTENSION_CSV_STATE_CODE);
            stateCensusAnalyser.getFileExtension(fileExtension);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenStateCensusCodeCSVFileCorrect_WhenDelimiterIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadSateCodeCsvData(INCORRECT_IN_DELIMITER_CSV_STATE_CODE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenStateCensusCodeCSVFile_WhenHeaderIncorrect_ShouldReturnCustomException() throws IOException, CSVBuilderException {
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadSateCodeCsvData(INCORRECT_IN_HEADER_CSV_STATE_CODE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.Exceptiontype.ENTERED_INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }
}