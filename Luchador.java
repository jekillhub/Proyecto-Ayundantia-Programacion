package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;


public class Luchador {
    
    private String nombre;
    private String faccion;
    private int rango;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    
    
    public Luchador (){
        
        this.nombre = ChosenName();
        this.faccion = ChosenFaction();
        this.rango = GeneratorRango();
        this.hp = (ThreadLocalRandom.current().nextInt(200,500+1))*this.rango;
        this.atk = (ThreadLocalRandom.current().nextInt(20,70+1))*this.rango;
        this.def = (ThreadLocalRandom.current().nextInt(5,25+1))*this.rango;
        this.spd = (ThreadLocalRandom.current().nextInt(10,100+1))*this.rango;
    }
    
    private String ChosenName(){
        int opc=0;
        String name="";
        
        //IO.Output("Seleccione un nombre");
        //IO.Output("1.Manjarsh");
        //IO.Output("2.Zafrada");
        //IO.Output("3.Vidal");
        //IO.Output("4.Junior Playboy");
        //IO.Output("5.Laarson");
        //IO.Output("6.Tío Emilio");
        //IO.Output("7.Alexis");
        //IO.Output("8.Salfate");
        //IO.Output("9.Pedro Angel");
        //IO.Output("10.Profesor Rosa");
        //IO.Output("11.Guru Guru");
        //IO.Output("12.Censista");
        //IO.Output("13.Pastor Soto");
        //IO.Output("14.Kramer");
        //IO.Output("15.Julio Cesar");
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
            }
        
        IO.Output("");
        return name;
        
    }
    
    private String ChosenFaction(){
        int opc=0;
        String faction="";

        //IO.Output("Seleccione una facción");
        //IO.Output("1.Fuego");
        //IO.Output("2.Agua");
        //IO.Output("3.Tierra");
        opc= ThreadLocalRandom.current().nextInt(1,3+1);
        
        switch(opc){
            case 1:  faction = "Fuego";
                     break;
            case 2:  faction = "Agua";
                     break;
            case 3:  faction = "Tierra";
                     break;
            } 
        
        IO.Output("");
        return faction;
    }
    
    private int GeneratorRango(){
        
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
    
       IO.Output("El nombre es: "+ getNombre());
       IO.Output("La facción es: "+ getFaccion());
       IO.Output("El rango es: "+ getRango());
       IO.Output("El ataque es: "+ getAtk());
       IO.Output("La defensa es: "+ getDef());
       IO.Output("La fuerza vital es: "+ getHp());
       IO.Output("La velocidad es: "+ getSpd());
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFaccion() {
        return this.faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public int getRango() {
        return this.rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return this.spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }
    

}
