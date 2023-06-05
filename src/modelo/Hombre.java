package modelo;

public class Hombre extends Formal{

    public Hombre(String diaVenta, int numero, Producto producto, String color) {
        super(diaVenta, numero, producto, color);
    }

    @Override
    public int descuento() { //o	Si el calzado es de hombre y de color es “Rojo” o “Verde el descuento será de un 25%
        int descuento = 0;
        if(this.getColor().equalsIgnoreCase("rojo") || this.getColor().equalsIgnoreCase("verde")){
            descuento = (int) valorVenta()/4;
            return  descuento;
        }
        return descuento;
    }


    @Override
    public int valorAPagar() { //valor a pagar - descuento + impuestoIva + impuestoEspecifico
        int valorAPagar = -1;

        if(this.getProducto().getStock()>0){
            valorAPagar = this.valorVenta() - this.descuento() + this.impuestoEspecifico() + this.impuestoIva();
            return valorAPagar;
        }else{
            return valorAPagar;
        }
    }
}
