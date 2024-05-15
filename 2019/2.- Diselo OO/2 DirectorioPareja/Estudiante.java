public class Estudiante implements Persona {
  String id;
  String nombre ;
  int edad ;
  public Estudiante ( String i, String n, int e) {
    id = i;
    nombre = n;
    edad = e;
  }
  public String getId () { return id; } // id del estudiante
  protected int horasEstudio () { return edad /3; }
  public String getNombre () { return nombre ; } // de interfaz
  public int getEdad () { return edad ; } // de interfaz
  public boolean igualA ( Persona otra ) { // de interfaz
    Estudiante otroEstudiante = ( Estudiante ) otra ;
    return (id. equals ( otroEstudiante . getId ()));
  }
  public String toString () { // para mostrar
    return " Estudiante (Id: " + id +
    ", Nombre : " + nombre +
    ", Edad : " + edad + ")";
  }
}
