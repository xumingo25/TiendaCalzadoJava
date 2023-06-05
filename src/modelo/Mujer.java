package modelo;

public class Mujer extends Formal{
    protected int alturaTaco;

    public Mujer(String diaVenta, int numero, Producto producto, String color, int alturaTaco) {
        super(diaVenta, numero, producto, color);
        this.alturaTaco = alturaTaco;
    }

    public int getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(int alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    @Override //es una anotación (una anotación permite establecer/definir el comportamiento de un método)
    public int descuento() { ////o	Si la altura del taco es mayor a 10, el descuento será de un 20% del valor venta
        int descuento = 0;
        if(this.getAlturaTaco()>10){
            descuento = this.valorVenta()/5;
            return descuento;
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
