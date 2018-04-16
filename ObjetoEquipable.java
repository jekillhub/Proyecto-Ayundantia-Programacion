package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;

public class ObjetoEquipable {
    
    private int mejoraTotal;
    private String caracteristica;
    private int rango;
    
    public ObjetoEquipable() {
        GeneradorMejoraTotal();
        GeneradorCaracteristica();
    }
    
    
    private void GeneradorCaracteristica(){
        int posibilidad = ThreadLocalRandom.current().nextInt(1,4+1);
        
        if(posibilidad==1){
            setCaracteristica("Armadura");
        }
        if(posibilidad==2){
            setCaracteristica("Arma");
        }
        if(posibilidad==3){
            setCaracteristica("Escudo");
        }
        if(posibilidad==4){
            setCaracteristica("Botas");
        }
    
    }

    private int MejoraBase(){
        int base = ThreadLocalRandom.current().nextInt(1,9+1);
        return base;  
    }
    
    private void GeneradorRango(){
        int posibilidad = ThreadLocalRandom.current().nextInt(1,100+1);
        
        if(posibilidad<=20){
            setRango(1);
        }
        if(posibilidad>20 && posibilidad<=40){
            setRango(2);
        }
        if(posibilidad>40 && posibilidad<=60){
            setRango(3);
        }
        if(posibilidad>60 && posibilidad<=75){
            setRango(4);
        }
        if(posibilidad>75 && posibilidad<=85){
            setRango(5);
        }
        if(posibilidad>85 && posibilidad<=90){
            setRango(6);
        }
        if(posibilidad>90 && posibilidad<=94){
            setRango(7);
        }
        if(posibilidad>94 && posibilidad<=97){
            setRango(8);
        }
        if(posibilidad>97 && posibilidad<=99){
            setRango(9);
        }
        if(posibilidad>99 && posibilidad<=100){
            setRango(10);
        }
    }

    private void GeneradorMejoraTotal(){
        GeneradorRango();
        setMejoraTotal(MejoraBase()*getRango());   
    }
    
    public void ShowMejora(){
        IO.Output("La mejora del objeto equipable es de: "+getMejoraTotal());
    }

    public int getMejoraTotal() {
        return this.mejoraTotal;
    }

    public String getCaracteristica() {
        return this.caracteristica;
    }

    public void setMejoraTotal(int mejoraTotal) {
        this.mejoraTotal = mejoraTotal;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    
    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getRango() {
        return rango;
    }
    
    
        
}
