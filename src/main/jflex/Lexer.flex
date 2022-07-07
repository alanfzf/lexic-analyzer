import alan.analizador.lexico.Categoria;
import alan.analizador.lexico.Token;
%%
%class Lexer
%type Token
%line
/* categorias lexicas */

//blancos
blancos=[\s]+
//palabras clave
pclave=@(CONST|EMPEZAR|FIN(_(MIENTRAS|SI)|ALIZAR)|MIENTRAS|SI(_NO)?|VAR)
//identificadores
ident=[\^\?]([a-zA-Z_][a-zA-Z0-9_]*)
//simbolos
simbolos=[)(:,]
//operadores
op_asignacion="~>"
op_aritmeticos=[\+\-\*\/%]
op_ecualidad=>=?|<=?|=|\!=
//comentarios.
comentarios=#.*
//literales
lit_caracteres=\"[^\"\n]*\"
lit_entera=[0-9]+
lit_flotante=[0-9]+\.[0-9]+

//errores
pclave_erronea="@"[0-9A-Za-z]*
ident_invalido=[\^\?][0-9][a-zA-Z0-9_]*
lit_flot_invalida=[0-9]+\.
op_igualdad_invalido==>|=<|=\!

%{
    public String lexeme;
%}
%%
{blancos} {/*Ignore*/}
{pclave} {  return new Token(yyline, yytext(), Categoria.P_CLAVE);}
{ident} {  return new Token(yyline, yytext(), Categoria.IDENTIFICADOR);}
//operadores
{op_asignacion} { return new Token(yyline, yytext(), Categoria.OP_ASIGNACION);}
{op_aritmeticos} {return new Token(yyline, yytext(), Categoria.OP_ARITMETICO);}
{op_ecualidad} {return new Token(yyline, yytext(), Categoria.OP_IGUALDAD);}
//simbolos
{simbolos} { return new Token(yyline, yytext(), Categoria.SIMBOLOS);}
//comentarios
{comentarios} { return new Token(yyline, yytext(), Categoria.COMENTARIOS);}
//literales
{lit_caracteres} { return new Token(yyline, yytext(), Categoria.LIT_CARACTERES);}
{lit_entera} {return new Token(yyline, yytext(), Categoria.LIT_ENTERA);}
{lit_flotante} {return new Token(yyline, yytext(), Categoria.LIT_PUNTOFLOTANTE);}
//errores
{pclave_erronea} {return new Token(yyline, yytext(), Categoria.ERROR_PC);}
{ident_invalido} {return new Token(yyline, yytext(), Categoria.ERROR_IDENT);}
{lit_flot_invalida} {return new Token(yyline, yytext(), Categoria.ERROR_LPF);}
{op_igualdad_invalido} {return new Token(yyline, yytext(), Categoria.ERROR_OPI);}
 . { return (new Token(yyline, yytext(), Categoria.ERROR));}
