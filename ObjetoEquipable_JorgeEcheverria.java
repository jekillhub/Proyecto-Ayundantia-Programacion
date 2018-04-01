
package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;

public class objetoEquipable {
    
    private int mejoraTotal;
    private int caracteristica;
    
    private void generadorCaracteristica(){
        int posibilidad = ThreadLocalRandom.current().nextInt(1,4+1);
        
        if(posibilidad==1){
            setCaracteristica(1);
            //HP
        }
        if(posibilidad==2){
            setCaracteristica(2);
            //ATK
        }
        if(posibilidad==3){
            setCaracteristica(3);
            //DEF
        }
        if(posibilidad==4){
            setCaracteristica(4);
            //SPD
        }
    
    }
    
    private int mejoraBase(){
        int base = ThreadLocalRandom.current().nextInt(1,9+1);
        return base;  
    }
    
    private int generadorEstrellas(){
        int posibilidad = ThreadLocalRandom.current().nextInt(1,100+1);
        int rango=0;
        
        if(posibilidad<=20){
            rango=1;
        }
        if(posibilidad>20 && posibilidad<=40){
            rango=2;
        }
        if(posibilidad>40 && posibilidad<=60){
            rango=3;
        }
        if(posibilidad>60 && posibilidad<=75){
            rango=4;
        }
        if(posibilidad>75 && posibilidad<=85){
            rango=5;
        }
        if(posibilidad>85 && posibilidad<=90){
            rango=6;
        }
        if(posibilidad>90 && posibilidad<=94){
            rango=7;
        }
        if(posibilidad>94 && posibilidad<=97){
            rango=8;
        }
        if(posibilidad>97 && posibilidad<=99){
            rango=9;
        }
        if(posibilidad>99 && posibilidad<=100){
            rango=10;
        }
        return rango;
    }
    
    private void generadorMejoraTotal(int base, int estrellas){
        setCaracteristica(mejoraBase()*generadorEstrellas());
        
    }
    
    public void showMejora(int mejoraTotal){
        IO.output("La mejora del objeto equipable es de: "+getMejoraTotal());
    }

    public int getMejoraTotal() {
        return mejoraTotal;
    }

    public int getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(int caracteristica) {
        this.caracteristica = caracteristica;
    }
    
    
        
}
