
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioLuchadores{
    
    private ArrayList<Luchador> luchadores;
    private int cantMax=25;
    
    private int VerCantLuchadores(){
        return luchadores.size();    
    }
    
    private void AgregarLuchadores(){
        Luchador L1 = new Luchador();
        
        if(luchadores.size()<=cantMax){
            luchadores.add(L1);
        }
        else{
            IO.Output("Inventario lleno");
        } 
    }
    
    
    private void BuscarLuchadoresFaccion(String faccion) {
        int i;
        
        for(i=0; i<luchadores.size();i++){
            if(luchadores.get(i).getFaccion().equals(faccion)){
            IO.Output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<luchadores.size();i++){
            if(luchadores.get(i).getRango() == rango){
            IO.Output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }  
    }
    
    private void Filtrar(){
        int opc=0;
        
        do{
        IO.Output("Seleccione alguna de las opciones siguientes");
        IO.Output("1. Filtrar por Facción");
        IO.Output("2. Filtrar por Rango");
        opc = IO.LeerInt();
        
            if(opc>0 && opc<2){
                String entrada="";
            
                switch(opc){
                    case 1: IO.Output("¿Que tipo de facción desea encontrar?");
                            entrada = IO.LeerString();
                            BuscarLuchadoresFaccion(entrada);
                            break;
                    case 2: IO.Output("¿Que tipo de rango desea encontrar?");
                            entrada = IO.LeerString();
                            BuscarLuchadoresRango(IO.ConvertToInt(entrada));
                            break;
                }
            }
            else{
                IO.Output("Error, opción no válida");
                IO.Output("");
            }
        }
        while(opc>0 && opc<3);
    }
    
    private void QuitarLuchadores(){
        int opc=0;
        
        do{
        MostrarAllLuchadores();
        IO.Output("Seleccione el numero del luchador a eliminar");
        opc = IO.LeerInt()-1;
        }
        while(opc>-1 && opc<luchadores.size()-1);
            luchadores.remove(opc);
    }
    
    private void MostrarAllLuchadores(){
        for(int x=0;x<luchadores.size();x++) {
            IO.Output((x+1)+".");
            IO.Output("Nombre: "+luchadores.get(x).getNombre());
            IO.Output("Facción: "+luchadores.get(x).getFaccion());
            IO.Output("Rango: "+ luchadores.get(x).getRango());
        }
    }
    
    private void MostrarSpecificLuchador(){
        int opc=0;
        
        do{
            IO.Output("Seleccione el numero de algún luchador para mostrar toda su información");
            MostrarAllLuchadores();
            opc= IO.LeerInt()-1;
            
            if(opc>-1 && opc<luchadores.size()-1){
                luchadores.get(opc).showInfo();
            }
            else{
                IO.Output("Error, opción no válida");
            }
            
        }
        while(opc>0 && opc<luchadores.size());
    }
 

}
