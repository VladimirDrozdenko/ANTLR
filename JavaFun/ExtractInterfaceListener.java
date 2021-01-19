import org.antlr.v4.runtime.*;

public class ExtractInterfaceListener extends JavaBaseListener {

    JavaParser parser;

    public ExtractInterfaceListener(final JavaParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterClassDeclaration(final JavaParser.ClassDeclarationContext ctx) {
        System.out.println("interface I" + ctx.Identifier() + " {");
    }

    @Override
    public void exitClassDeclaration(final JavaParser.ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterMethodDeclaration(final JavaParser.MethodDeclarationContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if (ctx.type() != null) {
            type = tokens.getText(ctx.type());
        }

        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier() + args + ";");
    }

    @Override
    public void enterImportDeclaration(final JavaParser.ImportDeclarationContext ctx) {
        System.out.println(parser.getTokenStream().getText(ctx));
    }
}