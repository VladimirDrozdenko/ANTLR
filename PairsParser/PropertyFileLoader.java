import java.util.HashMap;
import java.util.Map;

public final class PropertyFileLoader extends PropertyFileBaseListener {
    Map<String, String> properties = new HashMap<>();

    @Override
    public void exitProps(final PropertyFileParser.PropsContext ctx) {
        var id = ctx.ID().getText();
        var val = ctx.STRING().getText();
        this.properties.put(id, val);
    }
}
