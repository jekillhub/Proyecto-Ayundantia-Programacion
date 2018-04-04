
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioLuchadores{
    
    private ArrayList<Luchador> luchadores;
    private int cantMax=25;
    
    public int VerCantLuchadores(){
        return luchadores.size();    
    }
    
    public void AgregarLuchadores(){
        Luchador L1 = new Luchador();
        
        if(luchadores.size()<=cantMax){
            luchadores.add(L1);
        }
        else{
            IO.output("Inventario lleno");
        } 
    }
    
    
    public void BuscarLuchadoresFaccion(String faccion) {
        int i;
        
        for(i=0; i<luchadores.size();i++){
            if(luchadores.get(i).getFaccion().equals(faccion)){
            IO.output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }
    }
    
    public void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<luchadores.size();i++){
            if(luchadores.get(i).getStars() == rango){
            IO.output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }  
    }
    
    public void Filtrar(){
        int opc=0;
        
        do{
        IO.output("Seleccione alguna de las opciones siguientes");
        IO.output("1. Filtrar por Facción");
        IO.output("2. Filtrar por Rango");
        opc = IO.leerInt();
        
            if(opc>0 && opc<5){
                String entrada="";
            
                switch(opc){
                    case 1: IO.output("¿Que tipo de facción desea encontrar?");
                            entrada = IO.leerString();
                            BuscarLuchadoresFaccion(entrada);
                            break;
                    case 2: IO.output("¿Que tipo de rango desea encontrar?");
                            entrada = IO.leerString();
                            BuscarLuchadoresRango(IO.convertToInt(entrada));
                            break;
                }
            }
            else{
                IO.output("Error, opción no válida");
                IO.output("");
            }
        }
        while(opc>0 && opc<5);
    }
    
    public void QuitarLuchadores(){
        int opc=0;
        
        do{
        MostrarAllLuchadores();
        IO.output("Seleccione el numero del luchador a eliminar");
        opc = IO.leerInt()-1;
        }
        while(opc>-1 && opc<luchadores.size()-1);
            luchadores.remove(opc);
    }
    
    public void MostrarAllLuchadores(){
        for(int x=0;x<luchadores.size();x++) {
            IO.output((x+1)+".");
            IO.output("Nombre: "+luchadores.get(x).getNombre());
            IO.output("Facción: "+luchadores.get(x).getFaccion());
            IO.output("Rango: "+ luchadores.get(x).getStars());
        }
    }
    
    public void MostrarSpecificLuchador(){
        int opc=0;
        
        do{
            IO.output("Seleccione el numero de algún luchador para mostrar toda su información");
            MostrarAllLuchadores();
            opc= IO.leerInt()-1;
            
            if(opc>-1 && opc<luchadores.size()-1){
                luchadores.get(opc).showInfo();
            }
            else{
                IO.output("Error, opción no válida");
            }
            
        }
        while(opc>0 && opc<luchadores.size());
    }
       
}
