package main;

import main.antlr4.CsvBaseVisitor;
import main.antlr4.CsvParser;

public class PrintVisitor extends CsvBaseVisitor<String> {

    @Override
    public String visitHdr(final CsvParser.HdrContext ctx) {
        System.out.print("*");
        super.visitHdr(ctx);
        return "";
    }

    @Override
    public String visitRow(CsvParser.RowContext ctx) {
        super.visitRow(ctx);
        System.out.println();
        return "";
    }

}
