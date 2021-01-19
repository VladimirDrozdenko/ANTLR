// Generated from Csv.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CsvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CsvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CsvParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(CsvParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#hdr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHdr(CsvParser.HdrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(CsvParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link CsvParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(CsvParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CsvParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(CsvParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empty}
	 * labeled alternative in {@link CsvParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(CsvParser.EmptyContext ctx);
}