package edpro1;

public class Person {
    private int cuenta;
    private String nombre;
    private String carrera;

    public Person(int cuenta, String nombre, String carrera) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.carrera = carrera;
    }
    
    

    public int getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "cuenta=" + cuenta;
    }
    
    
}
