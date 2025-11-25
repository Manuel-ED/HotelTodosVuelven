package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    private static final String DNI_REGEX = "^[0-9]{8}$"; 
    private static final String NUMERO_REGEX = "^[0-9]+$"; 
    private static final String TELEFONO_REGEX = "^[0-9]{7,10}$"; 
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String FECHA_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";



    
    public static boolean esNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esAlfabetico(String texto) {
        if (!esNoVacio(texto)) return false;
        return texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    
    public static boolean esNumeroEntero(String texto) {
        if (!esNoVacio(texto)) return false;
        return texto.matches(NUMERO_REGEX);
    }
    
    
    public static boolean esNumeroDecimal(String texto) {
        if (!esNoVacio(texto)) return false;
        return texto.matches("^-?\\d+(\\.\\d+)?$");
    }



    
    public static boolean validarDni(String dni) {
        if (!esNoVacio(dni)) return false;
        return dni.matches(DNI_REGEX);
    }

    
    public static boolean validarNumeroHabitacion(String numero) {
        if (!esNoVacio(numero) || !esNumeroEntero(numero)) return false;
        return Integer.parseInt(numero) > 0; 
    }
    
    
    public static boolean validarPrecio(String precio) {
        if (!esNoVacio(precio) || !esNumeroDecimal(precio)) return false;
        return Double.parseDouble(precio) >= 0; 
    }

    
    public static boolean validarTelefono(String telefono) {
        if (!esNoVacio(telefono)) return false;
        return telefono.matches(TELEFONO_REGEX);
    }

    
    public static boolean validarEmail(String email) {
        if (!esNoVacio(email)) return false;
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    
    public static boolean validarFormatoFecha(String fecha) {
        if (!esNoVacio(fecha)) return false;
        return fecha.matches(FECHA_REGEX);
    }
    
  
}