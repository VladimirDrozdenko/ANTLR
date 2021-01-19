package main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main( String[] args) throws Exception
    {
        var lexer = new CsvLexer(CharStreams.fromString("h1,h2,h3\nr1,r2,r3\nr4,r5,r6\n"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new CsvParser(tokens);
        var tree = parser.file();

        System.out.println(tree.toStringTree(parser));

        new PrintVisitor().visit(tree);
    }
}