
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioLuchadores{

    private ArrayList<Luchador> luchadores = new ArrayList();
    private int cantMax=25;

    public InventarioLuchadores() {}
    
    private int ObtenerCantLuchadores(){
        return this.luchadores.size();    
    }
    
    private void AgregarLuchadores(){
        Luchador l1 = new Luchador();
        
        if(this.luchadores.size()<=cantMax){
            this.luchadores.add(l1);
        }
        else{
            IO.Output("Inventario lleno");
        } 
    }
    
    
    private void BuscarLuchadoresFaccion(String faccion) {
        int i;
        
        for(i=0; i<this.luchadores.size();i++){
            if(this.luchadores.get(i).getFaccion().equals(faccion)){
                IO.Output("El luchador numero "+(i+1)+" corresponde a la busqueda");  
            }
        }
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<this.luchadores.size();i++){
            if(this.luchadores.get(i).getRango() == rango){
                IO.Output("El luchador numero "+(i+1)+" corresponde a la busqueda");  
            }
        }  
    }
    
    private void Filtrar(){
        int firstOpc=0;
        
        do{
            IO.Output("Seleccione alguna de las opciones siguientes");
            IO.Output("1. Filtrar por Facción");
            IO.Output("2. Filtrar por Rango");
            firstOpc = IO.LeerInt();
        }   while(firstOpc<1 || firstOpc>2);
        
        String entrada="";
        
        switch(firstOpc){
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
        
    
    private void QuitarLuchadores(){
        int opc=0;
        MostrarAllLuchadores();
        
        do{        
        IO.Output("Seleccione el numero del luchador a eliminar");
        opc = IO.LeerInt()-1;
        
        }while(opc<0 || opc>this.luchadores.size());
        
        this.luchadores.remove(opc);
    }
    
    private void MostrarAllLuchadores(){
        IO.Output("Luchadores Disponibles: ");
        for(int x=0;x<this.luchadores.size();x++) {
            IO.Output((x+1)+".");
            IO.Output("Nombre: "+ this.luchadores.get(x).getNombre());
            IO.Output("Facción: "+ this.luchadores.get(x).getFaccion());
            IO.Output("Rango: "+ this.luchadores.get(x).getRango());
            IO.Output("");
        }
        IO.Output("");
    }
    
    private void MostrarSpecificLuchador(){
        int opc=0;
        
        do{
            MostrarAllLuchadores();
            IO.Output("Seleccione el numero de algún luchador para mostrar toda su información");
            opc= IO.LeerInt()-1;
            
        }while(opc<0 || opc>this.luchadores.size()-1); 

        this.luchadores.get(opc).ShowInfo();
    }

}
