package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;

public class Monstruo {
    
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private String faccion;
    ObjetoEquipable obj1; 
    
    public Monstruo (){
        
        this.hp = (ThreadLocalRandom.current().nextInt(3500,4000+1));
        this.atk = (ThreadLocalRandom.current().nextInt(1000,1500+1));
        this.def = (ThreadLocalRandom.current().nextInt(5,25+1));
        this.spd = (ThreadLocalRandom.current().nextInt(10,100+1));
        this.faccion= ChosenFaction();
        this.obj1 = new ObjetoEquipable();
    }
    
    private void ObjetoDropeable(){
        this.obj1.ShowMejora();
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
 
       IO.Output("El ataque es: "+ getAtk());
       IO.Output("La defensa es: "+ getDef());
       IO.Output("La fuerza vital es: "+ getHp());
       IO.Output("La velocidad es: "+ getSpd());
       IO.Output("La facción es: "+ getFaccion());
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getFaccion() {
        return this.faccion;
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
