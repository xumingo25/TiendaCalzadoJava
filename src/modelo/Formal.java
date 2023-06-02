package modelo;

public class Formal extends Calzado{
    protected String color;

    public Formal(String diaVenta, int numero, Producto producto, String color) {
        super(diaVenta, numero, producto);
        this.color = color;
    }

    public Formal(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
