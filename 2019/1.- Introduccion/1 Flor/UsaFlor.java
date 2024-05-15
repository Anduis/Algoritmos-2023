public class UsaFlor{
  public static void main(String[] args) {
    Flor Magnolia = new Flor ("Magnolia",9,12.3f);
    Flor cempoalxochitl = new Flor();
    cempoalxochitl.setNombre("Cempoalxochitl");
    cempoalxochitl.setPrecio(4.6f);
    cempoalxochitl.setNumeroPetalos(37);

    System.out.println("la Flor "+ Magnolia.nombre + " tiene un precio de $" + Magnolia.precio + " pesos y tiene " + Magnolia.numeroPetalos + " petalos.");
    System.out.println("la Flor "+ cempoalxochitl.nombre + " tiene un precio de $" + cempoalxochitl.precio + " pesos y tiene " + cempoalxochitl.numeroPetalos + " petalos.");
    }
}
