package modelo;

public class Producto {
    //Nombre, Atributos y Métodos

    //Atributos (código (String),stock,valor base.)
    private String codigo; //atributo
    private int stock;
    private int valorBase;

    //Métodos

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }


    //Constructor
    //Es un método para crear un objeto (java nos crea el constructor SOLO si no lo hacemos nosotros)

    public Producto(String codigo, int stock, int valorBase) {
        this.codigo = codigo;
        this.stock = stock;
        this.valorBase = valorBase;
    }

    public Producto() {
    }


}
