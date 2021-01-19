import org.antlr.v4.runtime.*;

public class Col {
    public static void main(final String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(System.in);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        int col = Integer.parseInt(args[0]);

        RowsParser parser = new RowsParser(tokens, col);
        parser.setBuildParseTree(false);
        parser.file();
    }
}
