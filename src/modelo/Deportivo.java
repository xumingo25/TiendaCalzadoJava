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
}
