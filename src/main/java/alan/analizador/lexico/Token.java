package alan.analizador.lexico;

public class Token {

    private final int line;
    private final String tokenName;
    private final Categoria categoria;

    public Token(int line, String token, Categoria cat){
        this.line = line;
        this.tokenName = token;
        this.categoria = cat;
    }

    public int getLine() {
        return line;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public String getTokenName() {
        return tokenName;
    }
}
