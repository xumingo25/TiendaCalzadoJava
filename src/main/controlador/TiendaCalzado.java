package main.controlador;

import main.modelo.Calzado;
import main.modelo.Deportivo;
import main.modelo.Hombre;
import main.modelo.Mujer;

import java.util.ArrayList;

public class TiendaCalzado {

    //Atributos
    private ArrayList<Calzado> tienda; //{calzado,calzado,calzado,calzado,calzado}
                                       //{deportivo,mujer,hombre,deportivo,deportivo}

    //Métodos
    public ArrayList<Calzado> getTienda() {
        return tienda;
    }

    public void setTienda(ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }

    public TiendaCalzado(ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }

    //Logica de la aplicación
    //El ingreso puede ser Calzado de mujer, hombre o deportivo y  no puede estar duplicado
    public int buscarCalzado(String codigo){ //12avc3123
        for(int i=0;i<tienda.size();i++){    //{1234,qwewq12,123qwe,12avc,23112} codigo
            if(tienda.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
                //encontre el calzado
                return i; //posición
            }
        }
        return -1; //no existe el codigo asociado a un calzado
    }

    //Método para ingresar calzados deportivos
    public void ingresarCalzadoDeportivo(Deportivo deportivo){
        if(this.buscarCalzado(deportivo.getProducto().getCodigo())==-1){
            tienda.add(deportivo);
        }
    }

    public void ingresarCalzadoMujer(Mujer mujer){
        if(this.buscarCalzado(mujer.getProducto().getCodigo())==-1){
            tienda.add(mujer);
        }
    }

    public void ingresarCalzadoHombre(Hombre hombre){
        if(this.buscarCalzado(hombre.getProducto().getCodigo())==-1){
            tienda.add(hombre);
        }
    }

    //2.	Mostrar sólo los calzado de mujer
    //En opción 2, debe mostrar Día de venta, altura de taco y descuento.
    public String calzadosMujer(){//{deportivo,mujer,hombre,deportivo,mujer,mujer,mujer,deportivo}
        String mensaje = "";
        Mujer mujer = null;
        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Mujer){
                //es un calzado de mujer
                mujer = (Mujer) tienda.get(i);
                mensaje = mensaje + "\nDia de venta: "+mujer.getDiaVenta() + ", altura taco: "+
                        mujer.getAlturaTaco()+" y descuento: $"+mujer.descuento();
            }
        }

        return mensaje;
    }

    //3.	Valor Venta
    //En Valor Venta mostrará el valor Venta y número del calzado de uno en particular.
    public String valorVenta(String codigo){
        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
                //lo encontre
                return "El valor venta del calzado es: $"+tienda.get(i).valorVenta()+
                        " y el nro del calzado es: "+tienda.get(i).getNumero();
            }
        }
        return "El codigo "+codigo +" ingresado no pertenece a ningun calzado registrado...";
    }

    //4.	Calzados top
    //En Calzados top mostrará la cantidad de calzados cuyo valorVenta sea mayor a $80000
    public String calzadosTOP(){
        int suma = 0;
        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i).valorVenta()>80000){
                //Es un calzado top
                suma = suma + tienda.get(i).getProducto().getStock();
            }
        }
        return "La cantidad de calzados top de la tienda (Valor venta mayor a $80.000) son: "+suma;
    }


    //5.	Total Impuesto Especifico
    //En opción 5 mostrará el total de impuesto específico si se vendieran todos los calzados
    public int totalImpuestoEspecifico(){
        int total = 0; //Se declara una variable para almacenar el total de impuesto
        Mujer mujer = null; //Se declara una variable para almacenar los objetos de tipo mujer identifcados en la colección
        Hombre hombre = null; //Se declara una variable para almacenar los objetos de tipo hombre identifcados en la colección
        for(int i=0;i<tienda.size();i++){ //Iteramos en la colección
            if(tienda.get(i) instanceof Hombre){ //evaluamos si el elemento a iterar es una instancia de la clase hombre
                hombre = (Hombre) tienda.get(i); //instanciamos el objeto para manipular su información via getters & Setters
                total = total + (hombre.impuestoEspecifico()*hombre.getProducto().getStock()); //obtenemos el total metiante el impuesto x el stock
            }else if(tienda.get(i) instanceof  Mujer){ //evaluamos si el elemento a iterar es una instancia de la clase mujer
                mujer = (Mujer) tienda.get(i); //instanciamos el objeto para manipular su información via getters & Setters
                total = total + (mujer.impuestoEspecifico()*mujer.getProducto().getStock());  //obtenemos el total metiante el impuesto x el stock
            }
        }
        return total;
    }

    //6.	Total descuento
    //En Total descuento mostrará el total de descuento en toda la tienda
    public int totalDescuento(){
       int totalDesc = 0;
       Mujer mujer = null;
       Hombre hombre = null;

       for(int i=0;i<tienda.size();i++){
           if(tienda.get(i) instanceof Mujer){
               mujer = (Mujer) tienda.get(i);
               totalDesc = totalDesc + (mujer.descuento()*mujer.getProducto().getStock());
           }else if(tienda.get(i) instanceof  Hombre){
               hombre = (Hombre) tienda.get(i);
               totalDesc = totalDesc + (hombre.descuento()*hombre.getProducto().getStock());
           }
       }
       return totalDesc;
    }

}
