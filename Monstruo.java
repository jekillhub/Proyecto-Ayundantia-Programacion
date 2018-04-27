package proyectoayudantia;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Monstruo {
    
    private double hp;
    private double atk;
    private double def;
    private double spd;
    private String faccion;
    private ArrayList<ObjetoEquipable> objetos = new ArrayList(); 
    
    public Monstruo (){
        
        this.hp = (ThreadLocalRandom.current().nextInt(3500,4000+1));
        this.atk = (ThreadLocalRandom.current().nextInt(1000,1500+1));
        this.def = (ThreadLocalRandom.current().nextInt(5,25+1));
        this.spd = (ThreadLocalRandom.current().nextInt(10,100+1));
        this.faccion= ChosenFaction();
        CrearObjetos();
    }
    
    private void CrearObjetos(){
        ObjetoEquipable obj1 = new ObjetoEquipable(1);
        ObjetoEquipable obj2 = new ObjetoEquipable(3);
        ObjetoEquipable obj3 = new ObjetoEquipable(5);
        objetos.add(obj1);
        objetos.add(obj2);
        objetos.add(obj3); 
    }
    
    public ObjetoEquipable DropearObjetos(){
        int probabilidad= ThreadLocalRandom.current().nextInt(1,100+1);
        int pos=-1;
        
        if (probabilidad<=60){
            pos = 0;
        }
        if (probabilidad>60 && probabilidad<=90){
            pos = 1;
        }
        if (probabilidad>90 && probabilidad<=100){
            pos = 2;
        } 
        
        return objetos.get(pos);
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
            case 3:  faction = "Tierra";
                     break;
            } 
        
        IO.Output("");
        return faction;
    }
    
    public void ShowInfo(){
       IO.Output("Información del Monstruo: ");
       IO.Output("El ataque es: "+ getAtk());
       IO.Output("La defensa es: "+ getDef());
       IO.Output("La fuerza vital es: "+ getHp());
       IO.Output("La velocidad es: "+ getSpd());
       IO.Output("La facción es: "+ getFaccion());
       IO.Output("");
    }
    
    public void ShowObjetos(){
        IO.Output("Los Objetos del Monstruo son: ");
        for(int x=0;x<this.objetos.size();x++) {
            IO.Output((x+1)+".");
            this.objetos.get(x).ShowMejora();
        }
        IO.Output("");
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getFaccion() {
        return this.faccion;
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
