package alan.analizador.lexico;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ALexico {

		private static ALexico instance;

		ALexico(){}


		public static ALexico getInstance() {
			return instance == null ? instance = new ALexico() : instance;
		}

		public ResALexico realizarAnalisis(String code){
				final List<Token> tokens = new ArrayList<>();
				final List<Token> errors = new ArrayList<>();


				try(final StringReader buffer = new StringReader(code)){
						final Lexer lexer = new Lexer(buffer);
						Token token;

						while ((token=lexer.yylex())!=null){

							if(Categoria.isError(token.getCategoria())){
									errors.add(token);
									continue;
							}
							tokens.add(token);
						}

				} catch (IOException e) {
						e.printStackTrace();
				}
				return new ResALexico(tokens, errors);
		}

		public static class ResALexico {
			private final List<Token> tokens, errors;
			ResALexico(List<Token> tokenList, List<Token> errorList){
					tokens = tokenList;
					errors = errorList;
			}

			public List<Token> getTokens() {
				return tokens;
			}

			public List<Token> getErrors() {
				return errors;
			}
		}
}
