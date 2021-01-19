import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExtractInterfaceTool {

    public static void main(final String[] args) throws Exception {

        String inputFile = (args.length > 0)
                ? args[0]
                : null;

        InputStream is = (inputFile != null)
                ? new FileInputStream(inputFile)
                : System.in;

        CharStream input = CharStreams.fromStream(is);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        //ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
        InsertSerialIDListener extractor = new InsertSerialIDListener(tokens);
        walker.walk(extractor, tree);

        System.out.println(extractor.rewriter.getText());
    }
}