
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioObjetos{

    
    private ArrayList<ObjetoEquipable> objetos;
    private int cantMax=10;
    
    
    private void MostrarAllObjetos(){
        for(int x=0;x<objetos.size();x++) {
            IO.output((x+1)+".");
            IO.output("Caracteristica: "+objetos.get(x).getCaracteristica());
            IO.output("Rango: "+objetos.get(x).getRango());
            IO.output("Mejora Total: "+objetos.get(x).getMejoraTotal());
        }
    }
    
    private int VerCantLuchadores(){
        return objetos.size();    
    }
    
    private void AgregarLuchadores(){
        ObjetoEquipable obj1 = new ObjetoEquipable();
        
        if(objetos.size()<=cantMax){
            objetos.add(obj1);
        }
        else{
            IO.output("Inventario lleno");
        } 
    }

    private void QuitarLuchadores(){
        int opc=0;
        
        do{
        MostrarAllObjetos();
        IO.output("Seleccione el numero del luchador a eliminar");
        opc = IO.leerInt()-1;
        }
        while(opc>-1 && opc<objetos.size()-1);
            objetos.remove(opc);
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<objetos.size();i++){
            if(objetos.get(i).getRango() == rango){
            IO.output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }  
    }
    
    private void FiltrarRango(){
        int opc=0;
        IO.output("¿Que tipo de rango desea encontrar?");
        String entrada = IO.leerString();
        BuscarLuchadoresRango(IO.convertToInt(entrada));                
    }
 
}
