import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ExprBaseVisitor<Integer> {
    Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitAssign(final ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(final ExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }

    @Override
    public Integer visitInt(final ExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitId(final ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return 0;
    }

    @Override
    public Integer visitClear(final ExprParser.ClearContext ctx)  {

        if (ctx.clr().ID() == null) {
            memory.clear();
        } else {
            memory.remove(ctx.clr().ID().getText());
        }
        return 0;
    }

    @Override
    public Integer visitMulDiv(final ExprParser.MulDivContext ctx) {
        if (ctx == null) {
            return 0;
        }
        
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.MUL) {
            return left * right;
        }
        return left / right;
    }

    @Override
    public Integer visitAddSub(final ExprParser.AddSubContext ctx) {
        if (ctx == null) {
            return 0;
        }

        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.ADD) {
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitParens(final ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
