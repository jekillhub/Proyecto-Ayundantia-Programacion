package taller1;

import java.util.Random;
import java.util.Scanner;

public class Taller1 {
    
    
    
    public static void main(String[] args) {
        int[][] consumoGas = new int[11][31];
        llenadoMatriz(consumoGas);
        System.out.println("Seleccione una opción");
        System.out.println("1.Consumo anual en pesos de todo el edificio");
        System.out.println("2.Conusmo anual en m^3 de un piso");
        System.out.println("3.Mes de mayor consumo en el edificio");
        System.out.println("4.Consumo anual de cada piso");
        System.out.println("5.Salir");
        
        
    }
    
    public static int[][] llenadoMatriz(int[][]matriz){
        Random rnd = new Random();
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matriz[x][y] = (int) (Math.random()*49+1);    
            }
            
        }
        
    return matriz;
    
    }
    
    public static double calValPagar(int consumo){
        double valPagar=0;  
        if(consumo<=5){
             valPagar = consumo*1200 + 2000; 
          }
        if(consumo>5 && consumo<12){
             valPagar = consumo*1000 + 1500;
          }
        if(consumo>=12){
            valPagar = consumo*800+consumo*0.1; 
          }
        return valPagar;
    }
    

    public static String convertoString(double infoEntrada){
        String salida = String.valueOf(infoEntrada);
        return salida;
    }
    
    public static void salidaInfo(String entrada){
        System.out.println(entrada);
    }
    
    public static int entradaInfo(){
       Scanner sc = new Scanner(System.in);
       int valEntrada = sc.nextInt();
       return valEntrada;
    }
    
    
    public static int valMayConsumo(int[][]matriz){
      
      System.out.println ("Buscando valor de mes de mayor consumo");
      int mayor=0;
      for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
               if (matriz [x][y]>mayor){
               mayor=matriz[x][y];
               
               }
            }
      } 
      
      return mayor;  
    }
    
    public static double consAnualEd(int[][] matriz ){
        
        double consAnualEd=0;
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matriz[x][y] = (int) (Math.random()*50);
            }
        }
        return consAnualEd;
    }
    
    public static int calculoRangoPiso(int numDpto){
      switch(numDpto){
          numDpto=1
      } 
    }
}

   