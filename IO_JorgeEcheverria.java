
package proyectoayudantia;

import java.util.Scanner;

public class IO {
    
    public static String input(){
       Scanner sc = new Scanner(System.in);
       String valEntrada = sc.nextLine();
       return valEntrada;
    }
    
    public static String convertToString(double infoEntrada){
        String salida = String.valueOf(infoEntrada);
        return salida;
    }
    
    public static int convertToInt(String input){
       int salida = Integer.parseInt(input);
       return salida;
    }
    
    public static boolean convertToBoolean(String input){
       boolean output = Boolean.parseBoolean(input);
       return output;
    }
    
    public static int convertDoubleToInt(double infoEntrada){
        int salida = (int)infoEntrada;
        return salida;
    }
    
    public static void output(String entrada){
        System.out.println(entrada);
    }
    
}
