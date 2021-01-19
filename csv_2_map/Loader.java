import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Loader extends CsvBaseListener {

    Map<String, List<String>> rows = new HashMap<>();
    private List<String> rowValues;


    @Override public void exitString(final CsvParser.StringContext ctx) {
        rowValues.add(ctx.STRING().getText());
    }

    @Override public void exitText(final CsvParser.TextContext ctx) {
        rowValues.add(ctx.TEXT().getText());
    }

    @Override public void exitEmpty(final CsvParser.EmptyContext ctx) {
        rowValues.add(null);
    }

    @Override public void enterRow(final CsvParser.RowContext ctx) {
        rowValues = new ArrayList<>();
    }

    @Override public void exitRow(final CsvParser.RowContext ctx) {
        if (rows.isEmpty()) {
            // setting up headers
            for (String s: rowValues) {
                rows.put(s, new ArrayList<>());
            }
        } else {
            int cnt = 0;
            for (var entry : rows.entrySet()) {
                entry.getValue().add(rowValues.get(cnt++));
            }
        }
    }

}
