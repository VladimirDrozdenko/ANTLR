import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Test {
    
    public static void main(String[] args) throws Exception {

        System.out.println("Enter an buffer: ");

        final CharStream input = CharStreams.fromStream(System.in);

        final ArrayInitLexer lexer = new ArrayInitLexer(input);

        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ArrayInitParser parser = new ArrayInitParser(tokens);
        final ParseTree tree = parser.init();
        System.out.println(tree.toStringTree(parser));

        final ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ShortToUnicodeString(), tree);

        System.out.println();
    }
}
