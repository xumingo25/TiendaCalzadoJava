package modelo;

public abstract class Calzado {
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

    //•	valorVenta: retornará el valor de venta del calzado, sabiendo que
    // el fin de semana, aumenta en un 24% el valor Base y en la semana
    // el valor Base disminuye en un 15%.
    public int valorVenta(){ //10000
        int valorVenta = -1;
        if(this.getDiaVenta().equalsIgnoreCase("Semana")){
            // -15%
            valorVenta = this.getProducto().getValorBase() - Math.round(this.getProducto().getValorBase()*15/100);
            return valorVenta; //8500
        }else if(this.getDiaVenta().equalsIgnoreCase("Fin de semana")){
            // +24%
            valorVenta = this.getProducto().getValorBase() + Math.round(this.getProducto().getValorBase()*24/100);
            return valorVenta; //12400
        }
        return valorVenta; //-1 (Ocurrio un errror en el calculo)
    }

    //•	impuestoIva: retornará el valor por concepto de IVA que es el 19% del valor venta
    public int impuestoIva(){
        return Math.round(this.valorVenta()*19/100);
    }

    public abstract int valorAPagar();


}
