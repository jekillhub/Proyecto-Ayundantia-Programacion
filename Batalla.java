package proyectoayudantia;

import java.util.concurrent.ThreadLocalRandom;

public class Batalla {
    
    private int dañoDados;
    private int minPeleadores;
    private int maxPeleadores;
    private int cantMonstruos;

    public Batalla() {
        CalculoDañoDados();
        minPeleadores = 1;
        maxPeleadores = 6;
        cantMonstruos = 1;
    }

    private int Dado6Caras(){
        return (ThreadLocalRandom.current().nextInt(1,6+1));
    }
    
    private int Dado8Caras(){
        return (ThreadLocalRandom.current().nextInt(1,8+1));
    }
    
    private int RestaDados(){
        return Dado8Caras()-Dado6Caras();
    }
    
    private void CalculoDañoDados(){
        int restaDados = RestaDados();
        
        if (restaDados>1){
            this.dañoDados = 2*restaDados;
            IO.Output("El daño será: "+ this.dañoDados);
        }
        
        if (restaDados<1){
            this.dañoDados = Math.abs(restaDados);
            IO.Output("El daño será: "+ this.dañoDados);
        }
        
        else{
            IO.Output("No hay aumento del daño");
        }

    }
    
    private void EvaluacionFacciones(Luchador l1, Monstruo m1){
            
            if (l1.getFaccion() == "Agua" && m1.getFaccion() == "Fuego"){
                l1.setAtk(l1.getAtk()*1.5);
                m1.setAtk(m1.getAtk()*0.75);
            }
            if (l1.getFaccion() == "Fuego" && m1.getFaccion() == "Planta"){
                l1.setAtk(l1.getAtk()*1.5);
                m1.setAtk(m1.getAtk()*0.75);
            }           
            if (l1.getFaccion() == "Planta" && m1.getFaccion() == "Agua"){
                l1.setAtk(l1.getAtk()*1.5);
                m1.setAtk(m1.getAtk()*0.75);
            } 
            
            
            if (m1.getFaccion() == "Agua" && l1.getFaccion() == "Fuego"){
                m1.setAtk(m1.getAtk()*1.5);
                l1.setAtk(l1.getAtk()*0.75);
            }
            if (m1.getFaccion() == "Fuego" && l1.getFaccion() == "Planta"){
                m1.setAtk(m1.getAtk()*1.5);
                l1.setAtk(l1.getAtk()*0.75);
            }           
            if (m1.getFaccion() == "Planta" && l1.getFaccion() == "Agua"){
                m1.setAtk(m1.getAtk()*1.5);
                l1.setAtk(l1.getAtk()*0.75);
            } 
            
    }
    
//Esta parte la entendi de esta manera, no se si se ajusta a lo pedido.
    
    private double CalculoDañoLM(Luchador atacante, Monstruo atacado){
        double daño = atacado.getAtk() - atacado.getDef();
        if (daño<0){
            daño = 0;
        }
        return daño;
    }
    
    private double CalculoDañoML(Monstruo atacante, Luchador atacado){
        double daño = atacado.getAtk() - atacado.getDef();
        if (daño<0){
            daño = 0;
        }
        return daño;
    }
}
