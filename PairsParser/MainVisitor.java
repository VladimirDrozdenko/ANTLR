import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public final class MainVisitor {
    public static void main(final String[] args) {
        var lexer = new PropertyFileLexer(CharStreams.fromString("a1=\"qwerty\"\nj=\"123\"\n"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new PropertyFileParser(tokens);

        var loader = new PropertyFileVisitorLoader();
        var tree = parser.file();
        loader.visit(tree);

        System.out.println(loader.properties);
    }
}