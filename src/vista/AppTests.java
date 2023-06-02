package vista;

import modelo.Deportivo;
import modelo.Producto;

public class AppTests {
    public static void main(String[] args) {

        Producto prod = new Producto("1",100,10000);

        Deportivo deportivo = new Deportivo("Fin de semana",43,prod,"Futbol","Cuero");

    }
}
