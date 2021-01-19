package main;

import main.antlr4.CsvBaseListener;
import main.antlr4.CsvParser;

public class DataBuilder extends CsvBaseListener {

    @Override
    public void exitHdr(final CsvParser.HdrContext ctx) {

    }

    @Override
    public void enterRow(final CsvParser.RowContext ctx) {

    }
}
