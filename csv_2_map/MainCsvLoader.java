import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public final class MainCsvLoader {

    public static void main(String[] args) {

        var lexer = new CsvLexer(CharStreams.fromString("h1,h2,h3\nr1,r2,r3\nr4,r5,r6\n"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new CsvParser(tokens);

        var walker = new ParseTreeWalker();

        var loader = new Loader();
        walker.walk(loader, parser.file());

        System.out.println(loader.rows);
    }
}
