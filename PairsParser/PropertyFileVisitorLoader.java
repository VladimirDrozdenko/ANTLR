import java.util.HashMap;
import java.util.Map;

public final class PropertyFileVisitorLoader extends PropertyFileBaseVisitor<Void> {
    Map<String, String> properties = new HashMap<>();

    @Override
    public Void visitProps(final PropertyFileParser.PropsContext ctx) {
        var id = ctx.ID().getText();
        var val = ctx.STRING().getText();
        this.properties.put(id, val);
        return null;
    }
}
