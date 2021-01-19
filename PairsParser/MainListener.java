import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public final class MainListener {
    public static void main(final String[] args) {
        var lexer = new PropertyFileLexer(CharStreams.fromString("a1=\"qwerty\"\nj=\"123\"\n"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new PropertyFileParser(tokens);

        var walker = new ParseTreeWalker();
        var loader = new PropertyFileLoader();
        walker.walk(loader, parser.file());

        System.out.println(loader.properties);
    }
}