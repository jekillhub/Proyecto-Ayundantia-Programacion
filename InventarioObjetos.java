
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioObjetos{

    
    private ArrayList<ObjetoEquipable> objetos;
    private int cantMax=10;
    
    
    private void MostrarAllObjetos(){
        for(int x=0;x<objetos.size();x++) {
            IO.Output((x+1)+".");
            IO.Output("Caracteristica: "+objetos.get(x).getCaracteristica());
            IO.Output("Rango: "+objetos.get(x).getRango());
            IO.Output("Mejora Total: "+objetos.get(x).getMejoraTotal());
        }
    }
    
    private int VerCantObjetos(){
        return objetos.size();    
    }
    
    private void AgregarObjetos(){
        ObjetoEquipable obj1 = new ObjetoEquipable();
        
        if(objetos.size()<=cantMax){
            objetos.add(obj1);
        }
        else{
            IO.Output("Inventario lleno");
        } 
    }

    private void QuitarObjetos(){
        int opc=0;
        
        do{
        MostrarAllObjetos();
        IO.Output("Seleccione el numero del luchador a eliminar");
        opc = IO.LeerInt()-1;
        }
        while(opc>-1 && opc<objetos.size()-1);
            objetos.remove(opc);
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<objetos.size();i++){
            if(objetos.get(i).getRango() == rango){
            IO.Output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }  
    }
    
    private void FiltrarRango(){
        int opc=0;
        IO.Output("¿Que tipo de rango desea encontrar?");
        String entrada = IO.LeerString();
        BuscarLuchadoresRango(IO.ConvertToInt(entrada));                
    }
 
}
