
package proyectoayudantia;

import java.util.ArrayList;

public class inventarioLuchadores{
    
    private ArrayList<Luchador> Luchadores;
    
    
    
    public int verCantLuchadores(ArrayList<Luchador> Luchadores){
        return Luchadores.size();
        
    }
    
    public void agregarLuchadores(ArrayList<Luchador> Luchadores){
        Luchador L1 = new Luchador();
        Luchadores.add(L1);
    }
    
    public int buscarLuchadoresName(ArrayList<Luchador> Luchadores, String nombre) {
        int i;
        
        for(i=0; i<Luchadores.size();i++){
            if(Luchadores.get(i).getNombre().equals(nombre)){
                break;
            }
        }
        return i;
    }
    
    public int buscarLuchadoresFaccion(ArrayList<Luchador> Luchadores, String faccion) {
        int i;
        
        for(i=0; i<Luchadores.size();i++){
            if(Luchadores.get(i).getFaccion().equals(faccion)){
                break;
            }
        }
        return i; 
    }
    
    public int buscarLuchadoresRango(ArrayList<Luchador> Luchadores, int rango) {
        int i;
        
        for(i=0; i<Luchadores.size();i++){
            if(Luchadores.get(i).getStars() == rango){
                break;
            }
        }
        return i;   
    }
    
    public void quitarLuchadores(ArrayList<Luchador> Luchadores){
        int opc=0;
        
        do{
        mostrarAllLuchadores(Luchadores);
        IO.output("Seleccione el numero del luchador a eliminar");
        opc = IO.convertToInt(IO.input())-1;
        Luchadores.remove(opc);
        }
        while(opc>-1 && opc<Luchadores.size()-1);
    }
    
    public void mostrarAllLuchadores(ArrayList<Luchador> Luchadores){
        for(int x=0;x<Luchadores.size();x++) {
            IO.output((x+1)+".");
            IO.output("Nombre: "+Luchadores.get(x).getNombre());
            IO.output("Facción: "+Luchadores.get(x).getFaccion());
            IO.output("Rango: "+ Luchadores.get(x).getStars());
        }
    }
    
    public void mostrarSpecificLuchador(ArrayList<Luchador>Luchadores){
        int opc=0;
        
        do{
            IO.output("Seleccione el numero de algún luchador para mostrar toda su información");
            mostrarAllLuchadores(Luchadores);
            opc= IO.convertToInt(IO.input())-1;
            
            if(opc>-1 && opc<Luchadores.size()-1){
                Luchadores.get(opc).showInfo();
            }
            else{
                IO.output("Error, opción no válida");
            }
            
        }
        while(opc>0 && opc<Luchadores.size());
    }
    
    public void busquedaAvanzada(ArrayList<Luchador> Luchadores){
        int opc=0;
        
        do{
        IO.output("Seleccione alguna de las opciones siguientes");
        IO.output("1. Busqueda por Nombre");
        IO.output("2. Busqueda por Facción");
        IO.output("3. Busqueda por Rango");
        IO.output("4. Volver al menu principal");
        opc = IO.convertToInt(IO.input());
        
            if(opc>0 && opc<5){
                String entrada="";
            
                switch(opc){
                    case 1: IO.output("Ingrese el nombre a buscar");
                            entrada = IO.input();
                            IO.output("Se encuentra en la posición "+buscarLuchadoresName(Luchadores,entrada));
                            break;
                    case 2: IO.output("Ingrese la facción a buscar");
                            entrada = IO.input();
                            IO.output("Se encuentra en la posición "+buscarLuchadoresFaccion(Luchadores,entrada));
                            break;
                    case 3: IO.output("Ingrese el rango a buscar");
                            entrada = IO.input();
                            IO.output("Se encuentra en la posición "+buscarLuchadoresRango(Luchadores,IO.convertToInt(entrada)));
                            break;
                    case 4: menuInventario();
                            break;
                }
            }
            else{
                IO.output("Error, opción no válida");
                IO.output("");
            }
        }
        while(opc>0 && opc<5);
        IO.output("Considere que las posiciones parten desde el cero");
    }
    
    public void menuInventario(){
        int opc=0;
        IO.output("Bienvenido al Menú del Inventario de Luchadores");
        
        do{
        IO.output("Seleccione alguna de las opciones siguientes");
        IO.output("1. Agregar Luchadores");
        IO.output("2. Quitar Luchadores");
        IO.output("3. Ver Cantidad de Luchadores");
        IO.output("4. Mostrar todos los Luchadores");
        IO.output("5. Mostrar toda la información de algun Luchador");
        IO.output("6. Busqueda Avanzada de Luchadores");
        IO.output("7. Salir");
        opc= IO.convertToInt(IO.input());
        
            if(opc>0 && opc<8){
                switch(opc){
                    case 1: agregarLuchadores(Luchadores);
                        break;
                    case 2: quitarLuchadores(Luchadores);
                        break;
                    case 3: verCantLuchadores(Luchadores);
                        break;
                    case 4: mostrarAllLuchadores(Luchadores);
                        break;
                    case 5: mostrarSpecificLuchador(Luchadores);
                        break;
                    case 6: 
                        break;
                    case 7: break;

                }

            }
            else{
                IO.output("Error, opción no válida");
                IO.output("");
            }
        }
        while(opc>0 && opc<8);
      
    }
    
    
    
}
