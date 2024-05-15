public class Flor{
  String nombre;
  int numeroPetalos;
  float precio;

    public Flor (String nm, int nP, float pr){
      nombre = nm;
      numeroPetalos = nP;
      precio = pr;
    }
    public Flor (){
      nombre = null;
      numeroPetalos = 1;
      precio = 1f;
    }

    public void setNombre(String snm){nombre = snm;}
    public void setNumeroPetalos(int snP){numeroPetalos = snP;}
    public void setPrecio(float spr){precio = spr;}
    public String getNombre(){return nombre;}
    public int getNumeroPetalos(){return numeroPetalos;}
    public float getPrecio(){return precio;}
}
