
package proyectoayudantia;

import java.util.Scanner;

public class IO {
    
    public static String LeerString(){
       Scanner sc = new Scanner(System.in);
       String valEntrada = sc.nextLine();
       return valEntrada;
    }

    public static int LeerInt(){
	Scanner sc = new Scanner(System.in);
	int output = sc.nextInt();
	return output;
	}

    public static double LeerDouble(){
	Scanner sc= new Scanner(System.in);
	double output = sc.nextDouble();
	return output;
	}

    public static boolean LeerBoolean(){
	Scanner sc= new Scanner(System.in);
	boolean output = sc.nextBoolean();
	return output;
	}
    
    public static String ConvertToString(double infoEntrada){
        String salida = String.valueOf(infoEntrada);
        return salida;
    }
    
    public static int ConvertToInt(String input){
       int salida = Integer.parseInt(input);
       return salida;
    }
    
    public static boolean ConvertToBoolean(String input){
       boolean output = Boolean.parseBoolean(input);
       return output;
    }
    
    public static int ConvertDoubleToInt(double infoEntrada){
        int salida = (int)infoEntrada;
        return salida;
    }

    public static void Output(String entrada){
        System.out.println(entrada);
    }
    
}
