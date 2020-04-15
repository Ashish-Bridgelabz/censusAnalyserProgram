package com.bridgelabz.utility;

import com.bridgelabz.exception.CSVBuilderException;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder {
    public <E> Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException, com.bridgelabz.exception.CSVBuilderException;

    public <E> List getCSVFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException, com.bridgelabz.exception.CSVBuilderException;
}