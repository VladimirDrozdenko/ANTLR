import org.antlr.v4.runtime.*;
import java.io.FileInputStream;

public class Calc {
    
    public static void main(final String[] args) throws Exception {

        String inputFile = (args.length > 0)
            ? args[0]
            : null;

        var is = (inputFile != null)
            ? new FileInputStream(inputFile)
            : System.in;

        var input = CharStreams.fromStream(is);
        var lexer = new ExprLexer(input);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ExprParser(tokens);
        var tree = parser.prog();
        
        //System.out.println(tree.toStringTree(parser));
        var eval = new EvalVisitor();
        eval.visit(tree);
    }
} 
