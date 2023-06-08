package test.modelo;

import main.modelo.Mujer;
import main.modelo.Producto;
import org.junit.*;

public class MujerTest {
    private Mujer mujer;

    private static int nroCasoPrueba;

    @BeforeClass
    public static void prepracionClase(){
        System.out.println("Preparando ejecución de suite de pruebas");
        System.out.println("----------------------------------------");
        nroCasoPrueba = 1;
    }

    @AfterClass
    public static void posEjecucionPruebas(){
        System.out.println("---------------------------------------");
        System.out.println("Finalizando ejecución. enviando informe resultados...");
    }
    
    @Before
    public void preCondiciones(){
        //se ejecuta antesa de cada test
        System.out.println("Preparación test "+ nroCasoPrueba);
        mujer = new Mujer("Fin de semana",36,new Producto("1",10,10000),"rojo",9);
    }

    @After
    public void posCondiciones(){
        System.out.println("Pos ejecución test "+nroCasoPrueba);
        nroCasoPrueba++;
    }

    @Test
    public void descuentoNoValidoTest(){
        System.out.println("Ejecución test descuentoNoValidoTest");
        Assert.assertEquals(0,mujer.descuento());
    }

    @Test
    public void descuentoValido(){
        System.out.println("Ejecución test descuentoValido");
        mujer.setAlturaTaco(11);
        Assert.assertEquals(2480,mujer.descuento());
    }

    @Test
    public void totalAPagarSinStock(){
        System.out.println("Ejecución test totalAPagarSinStock");
        mujer.getProducto().setStock(0);
        Assert.assertEquals(-1,mujer.valorAPagar());
    }

    @Test
    public void totalAPagarOKSinDescuento(){
        System.out.println("Ejecución test totalAPagarSinStock");
        Assert.assertEquals(15496,mujer.valorAPagar());
    }

    @Test
    public void totalAPagarOKConDescuento(){
        System.out.println("Ejecución test totalAPagarOKConDescuento");
        mujer.setAlturaTaco(11);
        Assert.assertEquals(13016,mujer.valorAPagar());
    }


}
