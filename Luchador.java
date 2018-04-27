package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;


public class Luchador {
    
    private String nombre;
    private String faccion;
    private int rango;
    private double hp;
    private double atk;
    private double def;
    private double spd;
    private ObjetoEquipable objEq;
    private double statSinObj;
    
    
    public Luchador (){
        
        this.nombre = ChosenName();
        this.faccion = ChosenFaction();
        this.rango = GeneratorStars();
        this.hp = (ThreadLocalRandom.current().nextInt(200,500+1))*this.rango;
        this.atk = (ThreadLocalRandom.current().nextInt(20,70+1))*this.rango;
        this.def = (ThreadLocalRandom.current().nextInt(5,25+1))*this.rango;
        this.spd = (ThreadLocalRandom.current().nextInt(10,100+1))*this.rango;
    }
    
    private String ChosenName(){
        int opc=0;
        String name="";

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
        
        return name;
        
    }
    
    private String ChosenFaction(){
        int opc=0;
        String faction="";

        opc= ThreadLocalRandom.current().nextInt(1,3+1);
        
        switch(opc){
            case 1:  faction = "Fuego";
                     break;
            case 2:  faction = "Agua";
                     break;
            case 3:  faction = "Planta";
                     break;
            } 
        
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

    public void ShowInfo(){
    
       IO.Output("El nombre es: "+ getNombre());
       IO.Output("La facción es: "+ getFaccion());
       IO.Output("El rango es: "+ getRango());
       IO.Output("El ataque es: "+ getAtk());
       IO.Output("La defensa es: "+ getDef());
       IO.Output("La fuerza vital es: "+ getHp());
       IO.Output("La velocidad es: "+ getSpd());
       IO.Output("");
    }
    
    public void EquiparObjeto(ObjetoEquipable obj1){
        
        this.objEq = obj1;
        IO.Output("Has equipado "+this.objEq.getCaracteristica());
        
        if (this.objEq.getCaracteristica()=="Armadura"){
            this.statSinObj = this.hp;
            this.hp= this.hp + this.objEq.getMejoraTotal();
        }
        
        if (this.objEq.getCaracteristica()=="Arma"){
            this.statSinObj = this.atk;
            this.atk= this.atk + this.objEq.getMejoraTotal();
        }
        
        if (this.objEq.getCaracteristica()=="Escudo"){
            this.statSinObj = this.def;
            this.def= this.def + this.objEq.getMejoraTotal();
        }
        
        if (this.objEq.getCaracteristica()=="Botas"){
            this.statSinObj = this.spd;
            this.spd= this.spd + this.objEq.getMejoraTotal();
        }
        IO.Output("");
    }
    
    public void DesequiparObjeto(){
        
        if (this.objEq.getCaracteristica()=="Armadura"){
            this.hp= this.statSinObj;
        }
        
        if (this.objEq.getCaracteristica()=="Arma"){
            this.atk= this.statSinObj;
        }
        
        if (this.objEq.getCaracteristica()=="Escudo"){
            this.def= this.statSinObj;
        }
        
        if (this.objEq.getCaracteristica()=="Botas"){
            this.spd= this.statSinObj;
        }
        
        IO.Output("Has desequipado "+this.objEq.getCaracteristica());
        IO.Output("");
        
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
    
    public double getHp() {
        return this.hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAtk() {
        return this.atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return this.def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getSpd() {
        return this.spd;
    }

    public void setSpd(double spd) {
        this.spd = spd;
    }
    

}
