package proyectoayudantia;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Luchador {
    
    private String Nombre;
    private String Faccion;
    private int Stars;
    private int HP;
    private int ATK;
    private int DEF;
    private int SPD;

    public Luchador (){
        
        this.Nombre = ChosenName();
        this.Faccion = ChosenFaction();
        this.Stars = GeneratorStars();
        this.HP = (ThreadLocalRandom.current().nextInt(200,500+1))*this.Stars;
        this.ATK = (ThreadLocalRandom.current().nextInt(20,70+1))*this.Stars;
        this.DEF = (ThreadLocalRandom.current().nextInt(5,25+1))*this.Stars;
        this.SPD = (ThreadLocalRandom.current().nextInt(10,100+1))*this.Stars;
    }
    
    private String ChosenName(){
        int opc=0;
        String name="";
        
        do{
            Output("Seleccione un nombre");
            Output("1.Manjarsh");
            Output("2.Zafrada");
            Output("3.Vidal");
            Output("4.Junior Playboy");
            Output("5.Laarson");
            Output("6.Tío Emilio");
            Output("7.Alexis");
            Output("8.Salfate");
            Output("9.Pedro Angel");
            Output("10.Profesor Rosa");
            Output("11.Guru Guru");
            Output("12.Censista");
            Output("13.Pastor Soto");
            Output("14.Kramer");
            Output("15.Julio Cesar");
            //opc = ConvertToInt(Input());
            opc= ThreadLocalRandom.current().nextInt(1,15+1);
        
            switch(opc){
                case 1:  name = "Manjarsh";
                         break;
                case 2:  name = "Zafrada";
                         break;
                case 3:  name = "Vidal";
                         break;
                case 4:  name = "Junior Playboy";
                         break;
                case 5:  name = "Laarson";
                         break;
                case 6:  name = "Tío Emilio";
                         break;
                case 7:  name = "Alexis";
                         break;
                case 8:  name = "Salfate";
                         break;
                case 9:  name = "Pedro Angel";
                         break;
                case 10: name = "Profesor Rosa";
                         break;
                case 11: name = "Guru Guru";
                         break;
                case 12: name = "Censista";
                         break;
                case 13: name = "Pastor Soto";
                         break;
                case 14: name = "Kramer";
                         break;
                case 15: name = "Julio Cesar";
                         break;
                default: Output("Error");
                         break;
            } 
        }
        while(opc<0 && opc>16);
        
        //Output(name);
        Output("");
        return name;
        
    }
    
    private String ChosenFaction(){
        int opc=0;
        String faction="";
        
        do{
            Output("Seleccione una facción");
            Output("1.Fuego");
            Output("2.Agua");
            Output("3.Tierra");
            //opc = ConvertToInt(Input());
            opc= ThreadLocalRandom.current().nextInt(1,3+1);
        
            switch(opc){
                case 1:  faction = "Fuego";
                         break;
                case 2:  faction = "Agua";
                         break;
                case 3:  faction = "Tierra";
                         break;
                default: Output("Error");
                         break;
            } 
        }
        while(opc<1 && opc>3);
        
        //Output(faction);
        Output("");
        return faction;
    }
    
    private int GeneratorStars(){
        
        int probabilidad = ThreadLocalRandom.current().nextInt(1,100+1);
        int estrellas = 0;
        
        if (probabilidad<=40){
            estrellas = 1;
        }
        if (probabilidad>40 && probabilidad<=70){
            estrellas = 2;
        }
        if (probabilidad>70 && probabilidad<=85){
            estrellas = 3;
        } 
        if (probabilidad>85 && probabilidad<=95){
            estrellas = 4;
        }
        if (probabilidad>95){
            estrellas = 5;
        }
  
        return estrellas;
    }

    public void showInfo(){
        
       Output("El nombre es: "+ getNombre());
       Output("La facción es: "+ getFaccion());
       Output("La cantidad de estrellas es: "+ getStars());
       Output("El ataque es: "+ getATK());
       Output("La defensa es: "+ getDEF());
       Output("La fuerza vital es: "+ getHP());
       Output("La velocidad es: "+ getSPD());
    }
    
    
    
    public static String Input(){
       Scanner sc = new Scanner(System.in);
       String valEntrada = sc.nextLine();
       return valEntrada;
    }
    
    public static String ConvertToString(double infoEntrada){
        String salida = String.valueOf(infoEntrada);
        return salida;
    }
    
    public static int ConvertToInt(String input){
       int salida = Integer.parseInt(input);
       return salida;
    }
    
    public static void Output(String entrada){
        System.out.println(entrada);
    }
    
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFaccion() {
        return Faccion;
    }

    public void setFaccion(String Faccion) {
        this.Faccion = Faccion;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int Stars) {
        this.Stars = Stars;
    }
    
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getSPD() {
        return SPD;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }
    

}
