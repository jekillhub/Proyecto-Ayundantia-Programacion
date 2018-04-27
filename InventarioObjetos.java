
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioObjetos{

    
    private ArrayList<ObjetoEquipable> objetos= new ArrayList();
    private int cantMax=10;

    public InventarioObjetos() {
    }
    
    private void MostrarAllObjetos(){
        for(int x=0;x<this.objetos.size();x++) {
            IO.Output((x+1)+".");
            IO.Output("Caracteristica: "+this.objetos.get(x).getCaracteristica());
            IO.Output("Rango: "+this.objetos.get(x).getRango());
            IO.Output("Mejora Total: "+this.objetos.get(x).getMejoraTotal());
        }
    }
    
    private int ObtCantObjetos(){
        return this.objetos.size();    
    }
    
    private void AgregarObjetos(){
        ObjetoEquipable obj1 = new ObjetoEquipable();
        
        if(this.objetos.size()<=cantMax){
            this.objetos.add(obj1);
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
        while(opc>-1 && opc<this.objetos.size()-1);
            this.objetos.remove(opc);
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<this.objetos.size();i++){
            if(this.objetos.get(i).getRango() == rango){
                IO.Output("El luchador numero "+(i+1)+" corresponde a la busqueda");  
            }
            else{
                IO.Output("El luchador no se encuentra en el inventario");
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
