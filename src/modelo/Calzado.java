package modelo;

public class Calzado {
    //día de venta  (“semana” o “fin de semana”)
    //	número (medida del calzado)
    //	Producto
    protected String diaVenta;
    protected int numero;
    protected Producto producto;

    public Calzado(String diaVenta, int numero, Producto producto) {
        this.diaVenta = diaVenta;
        this.numero = numero;
        this.producto = producto;
    }

    public String getDiaVenta() {
        return diaVenta;
    }

    public void setDiaVenta(String diaVenta) {
        this.diaVenta = diaVenta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public Calzado(){

    }
}
