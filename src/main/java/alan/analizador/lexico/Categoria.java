
package alan.analizador.lexico;

import java.util.Arrays;

/**
 *
 * @author Alan
 */
public enum Categoria {
        P_CLAVE("1A"),
        IDENTIFICADOR("2A"),
        OP_ARITMETICO("3A"),
        OP_ASIGNACION("3B"),
        OP_IGUALDAD("3C"),
        LIT_ENTERA("4A"),
        LIT_PUNTOFLOTANTE("4B"),
        LIT_CARACTERES("4C"),
        SIMBOLOS("5A"),
        COMENTARIOS("6A"),

        //ERRORES
        ERROR("ERR_GENERICO"),
        ERROR_PC("ERR_PCLAVE"),
        ERROR_IDENT("ERR_ID"),
        ERROR_LPF("ERR_L_PUNTO_FLOTANTE"),
        ERROR_OPI("ERR_OPERADOR");


        private final String codigo;
        
        Categoria(String cod){
                this.codigo = cod;
        }

        public String getCode(){
                return codigo;
        }

        public static boolean isError(Categoria cat){
                Categoria[] errors = {ERROR, ERROR_PC, ERROR_IDENT, ERROR_LPF, ERROR_OPI};
                return Arrays.asList(errors).contains(cat);
        }
}
