import org.antlr.v4.runtime.*;

public class InsertSerialIDListener extends JavaBaseListener {

    TokenStreamRewriter rewriter;

    public InsertSerialIDListener(final TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterClassBody(final JavaParser.ClassBodyContext ctx) {
        String field = "\n\tpublic static final long serialVersionUID = 1L;";
        rewriter.insertAfter(ctx.start, field);
    }
}
