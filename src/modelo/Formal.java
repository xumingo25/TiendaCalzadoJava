package modelo;

public abstract class Formal extends Calzado{
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

    //•	impuestoEspecifico: retornará el valor de impuesto específico
    // el cual es un 7.4% del valor base (el calzado deportivo no paga éste impuesto)
    public int impuestoEspecifico(){
        return (int) Math.round(this.getProducto().getValorBase()*7.4/100);
    }

    //•	descuento: retornará el valor de descuento que tendrá el calzado, sabiendo que:
    //o	Si la altura del taco es mayor a 10, el descuento será de un 20% del valor venta
    //o	Si el calzado es de hombre y de color es “Rojo” o “Verde el descuento será de un 25%
    /*public int descuento(){
        return 0;
    }*/
    public abstract int descuento();
    //un método abstracto es aquel que se crea en una clase pero se implementa en subclases

}
