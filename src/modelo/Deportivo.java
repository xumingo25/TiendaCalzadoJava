package modelo;

public class Deportivo extends Calzado{
    protected String tipoDeporte;

    protected String tipoMaterial;


    public Deportivo(String diaVenta, int numero, Producto producto, String tipoDeporte, String tipoMaterial) {
        super(diaVenta, numero, producto);
        this.tipoDeporte = tipoDeporte;
        this.tipoMaterial = tipoMaterial;
    }

    public Deportivo() {
    }

    @Override
    public int valorAPagar() { //valor venta  + impuestoIva + impuestoMaterial
        int valorAPagar = -1;
        if(this.getProducto().getStock()>0){//hay stock;
            valorAPagar = this.valorVenta() + impuestoIva() + impuestoMaterial();
            this.getProducto().setStock(this.getProducto().getStock()-1);
            return  valorAPagar;
        }else{
            return valorAPagar;
        }
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    //•	impuestoMaterial: retornará el valor de impuesto de material el
    // cual es un 15% del valor base si el calzado es de Cuero y de un 6% del valor base si es de Lona
    public int impuestoMaterial(){
        int impuestoMaterial = 0;
        if(this.getTipoMaterial().equalsIgnoreCase("Cuero")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*15/100);
        }else if(this.getTipoMaterial().equalsIgnoreCase("Lona")){
            impuestoMaterial = Math.round(this.getProducto().getValorBase()*6/100);
        }
        return  impuestoMaterial;
    }
}
