
package proyectoayudantia;

import java.util.ArrayList;

public class InventarioLuchadores{
    
    private ArrayList<Luchador> luchadores;
    private int cantMax=25;
    private ArrayList<Luchador> luchadoresSeleccionados;
    
    private int VerCantLuchadores(){
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
                IO.Output("El luchador numero "+(i-1)+" corresponde a la busqueda");  
            }
        }
    }
    
    private void BuscarLuchadoresRango(int rango) {
        int i;
        
        for(i=0; i<this.luchadores.size();i++){
            if(this.luchadores.get(i).getRango() == rango){
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
        
            if(opc>0 && opc<3){
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
        while(opc>-1 && opc<this.luchadores.size()-1);
            this.luchadores.remove(opc);
    }
    
    private void MostrarAllLuchadores(){
        for(int x=0;x<this.luchadores.size();x++) {
            IO.Output((x+1)+".");
            IO.Output("Nombre: "+ this.luchadores.get(x).getNombre());
            IO.Output("Facción: "+ this.luchadores.get(x).getFaccion());
            IO.Output("Rango: "+ this.luchadores.get(x).getRango());
        }
    }
    
    private void MostrarSpecificLuchador(){
        int opc=0;
        
        do{
            IO.Output("Seleccione el numero de algún luchador para mostrar toda su información");
            MostrarAllLuchadores();
            opc= IO.LeerInt()-1;
            
            if(opc>-1 && opc<this.luchadores.size()-1){
                this.luchadores.get(opc).ShowInfo();
            }
            else{
                IO.Output("Error, opción no válida");
            }
            
        }
        while(opc>0 && opc<this.luchadores.size());
    }

//METODO EXPERIMENTAL
//    
    //private void SeleccionarLuchadores(){
        //int opc = 0;
        //int respuesta= 0;
        //MostrarAllLuchadores();
        //
        //do{
            //do{
                //IO.Output("Seleccione el numero de algun luchador: ");
                //opc = IO.LeerInt()-1;
            //}while(opc<0 || opc>luchadores.size());
            //this.luchadoresSeleccionados.add(this.luchadores.get(opc));
            //
            //do{
            //IO.Output("¿Desea seleccionar otro luchador?");
            //IO.Output("1. Si");
            //IO.Output("2. No");
            //respuesta = IO.LeerInt();
            //}while(respuesta<1 || respuesta>2);
        //}while(respuesta!=2);
    //}
}
