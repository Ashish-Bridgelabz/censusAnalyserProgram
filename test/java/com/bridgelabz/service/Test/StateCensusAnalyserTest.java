package com.bridgelabz.service.Test;

import com.bridgelabz.exception.StateCensusAnalyserException;
import com.bridgelabz.service.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

//import java.io.File;
import java.io.IOException;

public class StateCensusAnalyserTest {
    String STATE_CSV_FILE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/test/resources/IndiaStateCensusData.csv";
    String STATE_CSV_WRONG_FILE_PATH = "/home/ashish/IdeaProjects/IndianCensusAnalyser/src/tested/resources/IndiaStateCensusData.csv";
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    @Test
    public void givenStateCensusCSVFile_WhenTrue_NumberOfRecordShouldMatch() throws StateCensusAnalyserException, IOException {
        int countRecord = stateCensusAnalyser.loadCensusCSVData(STATE_CSV_FILE_PATH);
        Assert.assertEquals(countRecord, 29);
    }
    @Test
    public void givenStateCensusCsvFile_WhenIncorrect_ShouldReturnCustomException() throws IOException {
        STATE_CSV_FILE_PATH = "./src/tested/resources/StateCensusData.csv";
        stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadCensusCSVData(STATE_CSV_FILE_PATH);

        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.Exceptiontype.ENTERED_WRONG_FILE, e.type);
        }
    }

}
