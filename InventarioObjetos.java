
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioObjetos{

    
    private ArrayList<ObjetoEquipable> objetos;
    private int cantMax;

    public InventarioObjetos() {
        this.objetos = new ArrayList();
        this.cantMax = 10;
    }
    
    private void mostrarAllObjetos(){
        for(int x=0;x<this.objetos.size();x++) {
            IO.output((x+1)+".");
            IO.output("Caracteristica: "+this.objetos.get(x).getCaracteristica());
            IO.output("Rango: "+this.objetos.get(x).getRango());
            IO.output("Mejora Total: "+this.objetos.get(x).getMejoraTotal());
        }
    }
    
    private void obtenerCantObjetos(){
        IO.output("Actualmente hay " +this.objetos.size()+" objetos en el inventario");    
    }
    
    private void agregarObjetos(){
        ObjetoEquipable obj1 = new ObjetoEquipable();
        
        if(this.objetos.size()<=cantMax){
            this.objetos.add(obj1);
        }
        else{
            IO.output("Inventario lleno");
        } 
    }

    private void quitarObjetos(){
        int opc=0;
        
        do{
        mostrarAllObjetos();
        IO.output("Seleccione el numero del luchador a eliminar");
        opc = IO.leerInt()-1;
        }
        while(opc>-1 && opc<this.objetos.size()-1);
            this.objetos.remove(opc);
    }
    
    private void buscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<this.objetos.size();i++){
            if(this.objetos.get(i).getRango() == rango){
                IO.output("El luchador numero "+(i+1)+" corresponde a la busqueda");  
            }
            else{
                IO.output("El luchador no se encuentra en el inventario");
            }
        }  
    }
    
    private void filtrarRango(){
        int opc=0;
        IO.output("¿Que tipo de rango desea encontrar?");
        String entrada = IO.leerString();
        buscarLuchadoresRango(IO.convertToInt(entrada));                
    }
    
    
    //NUEVO 
    
    private void equiparObjeto(Luchador l1){
        mostrarAllObjetos();
        int opc = 0;
        
        do{
            IO.output("Seleccione algun objeto para equiparlo");
            opc = IO.leerInt()-1;
        }while(opc<0 || opc> objetos.size()-1);
        
        l1.equiparObjeto(objetos.get(opc));
        this.objetos.remove(opc);
    }
    
    private void desequiparObjeto(Luchador l1){
        IO.output("Actualmente está equipado: " + l1.getObjetoEq().getCaracteristica());
        this.objetos.add(l1.getObjetoEq());
        l1.desequiparObjeto();
        IO.output("Objeto desequipado");
    }
 
}
