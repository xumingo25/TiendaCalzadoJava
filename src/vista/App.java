package vista;

import controlador.TiendaCalzado;
import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;
import modelo.Producto;

import java.util.ArrayList;

public class App {

    public static int menu(){ //en este método definiremos el menu de opciones de la app
        System.out.println("--------Tienda Calzado V1.0---------");
        System.out.println("1.\tIngresar");
        System.out.println("2.\tMostrar sólo los calzado de mujer");
        System.out.println("3.\tValor Venta");
        System.out.println("4.\tCalzados top");
        System.out.println("5.\tTotal Impuesto Especifico");
        System.out.println("6.\tTotal descuento");
        System.out.println("7.\tSalir");
        System.out.println("-----------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }
    public static void main(String[] args) {
        int opcion;
        String codigoCalzado;

        //Instanciar colección
        TiendaCalzado tienda = new TiendaCalzado(new ArrayList<>()); //Colección vacio

        do{
          opcion = menu();

          switch(opcion){
              case 1:
                  codigoCalzado = pideCodigo(); //se obtiene el cod
                  if(tienda.buscarCalzado(codigoCalzado)==-1){
                      //calzado no existe
                      System.out.println("Favor ingrese stock del calzado..."); int stock = Leer.datoInt();
                      System.out.println("Favor ingrese valor base del calzado..."); int valorBase = Leer.datoInt();
                      System.out.println("Favor ingrese nro del calzado..."); int numero = Leer.datoInt();

                      String diaVenta;
                      do{
                          System.out.println("Favor ingrese dia venta (Semana o Fin de semana)");
                          diaVenta = Leer.dato(); //Semana
                      }while(diaVenta.compareToIgnoreCase("Semana") !=0 &&
                      diaVenta.compareToIgnoreCase("Fin de semana") !=0);

                      int respuesta;
                      do{
                          System.out.println("El calzado es: 1)Deportivo    2)Formal Hombre    3)Formal Mujer");
                          System.out.println("Favor ingrese una opción para continuar...");
                          respuesta = Leer.datoInt(); //10
                      }while(respuesta<1 || respuesta>3);

                            if(respuesta==1){
                                //Deportivo
                                System.out.println("Favor ingrese tipo de deporte"); String tipoDeporte = Leer.dato();

                                String tipoMaterial; //cuero o lona
                                do{
                                    System.out.println("Favor ingrese tipo de material (Cuero o Lona)");
                                    tipoMaterial = Leer.dato();
                                }while(tipoMaterial.compareToIgnoreCase("Cuero")!=0
                                && tipoMaterial.compareToIgnoreCase("Lona")!=0);


                                tienda.ingresarCalzadoDeportivo(new Deportivo(diaVenta,numero, new Producto(codigoCalzado,stock,valorBase),tipoDeporte,tipoMaterial));
                                System.out.println("Se agrega calzado deportivo correctamente");
                            }else{
                                System.out.println("Favor ingrese el color..."); String color = Leer.dato();

                                if(respuesta==2){ //Hombre

                                    tienda.ingresarCalzadoHombre(new Hombre(diaVenta,numero,new Producto(codigoCalzado,stock,valorBase),color));
                                    System.out.println("Se agrega calzado formal de hombre correctamente");
                                }else{ //Mujer
                                    System.out.println("Favor ingrese la altura del taco..."); int alturaTaco = Leer.datoInt();

                                    tienda.ingresarCalzadoMujer(new Mujer(diaVenta,numero,new Producto(codigoCalzado,stock,valorBase),color,alturaTaco));
                                    System.out.println("Se agrega calzado formal de mujer correctamente");
                                }
                            }

                  }else{
                      System.out.println("Calzado con codigo "+codigoCalzado + " ya se encuentra almacenado");
                  }
                  break;
              case 2:
                  if(tienda.getTienda().size()==0){ //no hay calzados
                      System.out.println("Favor registre calzados en la tienda para continuar...");
                  }else{
                      System.out.println(tienda.calzadosMujer());
                  }
                  break;
              case 3:
                  if(tienda.getTienda().size()==0){
                      System.out.println("Favor registre calzados en la tienda para continuar...");
                  }else{
                      String codigoABuscar = pideCodigo();
                      System.out.println(tienda.valorVenta(codigoABuscar));
                  }
                  break;
              case 4:
                  System.out.println(tienda.calzadosTOP());
                  break;
              case 5:
                  System.out.println("El total de impuestos específicos si se vendieran todos los calzados es: $"
                          +tienda.totalImpuestoEspecifico());
                  break;
              case 6:
                  System.out.println("El total de descuentos si se vendieran todos los calzados es: $"
                          +tienda.totalDescuento());
                  break;
          }

        }while(opcion!=7); //salir

    }

    public static String pideCodigo(){ //en este método solicitaremos el codigo para buscar un calzado
        System.out.println("Favor ingrese el codigo del calzado (ej: 123ABC)");
        return Leer.dato();
    }
}
