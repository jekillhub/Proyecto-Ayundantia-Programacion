package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;

public class Monstruo {
    
    private int hp;
    private int atk;
    private int def;
    private int spd;
    ObjetoEquipable obj1 = new ObjetoEquipable();
    
    public Monstruo (){
        
        this.hp = (ThreadLocalRandom.current().nextInt(3500,4000+1));
        this.atk = (ThreadLocalRandom.current().nextInt(1000,1500+1));
        this.def = (ThreadLocalRandom.current().nextInt(5,25+1));
        this.spd = (ThreadLocalRandom.current().nextInt(10,100+1));
    }
    
    private void ObjetoDropeable(){
        obj1.ShowMejora();
    }
    
    public void showInfo(){
 
       IO.output("El ataque es: "+ getAtk());
       IO.output("La defensa es: "+ getDef());
       IO.output("La fuerza vital es: "+ getHp());
       IO.output("La velocidad es: "+ getSpd());
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
