import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ingenierias
 */
class Reto2 {

    private final Scanner scanner = new Scanner(System.in);
    
    public String read(){
        return scanner.nextLine();
    }
    
    public void run() {
        // TODO code application logic here
        
        BasedeDatosProductos listaProductos = new BasedeDatosProductos();
        
        String operacion = read();
        String[] input = read().split(" ");
        
        Producto producto = new Producto(Integer.parseInt(input[0]), 
                input[1],
                Double.parseDouble(input[2]),
                Integer.parseInt(input[3]));
        
        if(operacion.equals("AGREGAR") && !listaProductos.verificarExistencia(producto)){
            listaProductos.agregar(producto);
            listaProductos.generarInforme();
        }
        else if (operacion.equals("BORRAR") && listaProductos.verificarExistencia(producto)){
            listaProductos.borrar(producto);
            listaProductos.generarInforme();
        }
        else if (operacion.equals("ACTUALIZAR") && listaProductos.verificarExistencia(producto)){
            listaProductos.actualizar(producto);
            listaProductos.generarInforme();
        }     
        else{
            System.out.println("ERROR");
        }
    
    }
        
}

class BasedeDatosProductos{
    
    private Map<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    public BasedeDatosProductos() {
    
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));         
    }
    
    public void agregar(Producto producto){
        listaProductos.put(producto.getCodigo(), producto);
    }
    
    public void borrar(Producto producto){
        listaProductos.remove(producto.getCodigo());
    }    
    
    public void actualizar(Producto producto){
        listaProductos.replace(producto.getCodigo(), producto);
    }
    

   
    public double totalInvetario(){        
        double totalInventario = 0;
        for (Producto producto: listaProductos.values()) {
            totalInventario += producto.getPrecio() * producto.getInventario();       
        }
        return totalInventario ;
    }        

    public boolean verificarExistencia(Producto producto){
        return listaProductos.containsKey(producto.getCodigo());     
    }
    public void generarInforme(){
        System.out.println(String.format("%.1f", totalInvetario()));
    }

}

class Producto {
    
    private int codigo;
    private String nombre; 
    private double precio;
    private int inventario;

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }   
}

    

