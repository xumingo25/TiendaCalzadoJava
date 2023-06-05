package vista;

import modelo.Deportivo;
import modelo.Mujer;
import modelo.Producto;

import java.sql.SQLOutput;

public class AppTests {
    public static void main(String[] args) {

        Producto prod = new Producto("1",100,10000);

        Deportivo deportivo = new Deportivo("Fin de semana",43,prod,"Futbol","Otra cosa");

        Mujer mujer = new Mujer("Fin de semana",43,prod,"Rojo",10);


        System.out.println("Valor venta calzado: $"+ deportivo.valorVenta());

        System.out.println("Impuesto Iva: $"+deportivo.impuestoIva());


        System.out.println("Impuesto Especifico: "+mujer.impuestoEspecifico());

        System.out.println("Impuesto Material: "+deportivo.impuestoMaterial());





    }
}
