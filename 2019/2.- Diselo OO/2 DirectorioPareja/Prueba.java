public class Prueba {
  public static void main(String[] args) {
    Estudiante Andres = new Estudiante("1638975x","Andres Anguiano",18);
    Estudiante Martin = new Estudiante("0000000x","Martin inventado",18);
    Estudiante Falso1 = new Estudiante("0000001x","Falso1 inventado",18);
    Estudiante Falso2 = new Estudiante("0000002x","Falso2 inventado",18);
    Estudiante Falso3 = new Estudiante("0000003x","Falso3 inventado",18);
    Estudiante Falso4 = new Estudiante("0000004x","Falso4 inventado",18);
    Estudiante Falso5 = new Estudiante("0000005x","Falso5 inventado",18);
    Estudiante Falso6 = new Estudiante("0000006x","Falso6 inventado",18);
    Estudiante Falso7 = new Estudiante("0000007x","Falso7 inventado",18);
    Estudiante Falso8 = new Estudiante("0000008x","Falso8 inventado",18);
    Estudiante Falso11 = new Estudiante("00000011x","Falso11 inventado",18);
System.out.println("");
    DirectorioPareja miDirectorio = new DirectorioPareja();
      miDirectorio.insertar(Andres,Martin);
      miDirectorio.insertar(Falso1,Falso2);
      miDirectorio.insertar(Falso3,Falso4);
      miDirectorio.insertar(Falso5,Falso6);
      miDirectorio.insertar(Falso7,Falso8);
      System.out.println("*****parejas registradas*****");
      System.out.println("numero de registros "miDirectorio.getEspaciosOcupados());
      miDirectorio.imprimirPareja(0);
      miDirectorio.imprimirPareja(1);
      miDirectorio.imprimirPareja(2);
      miDirectorio.imprimirPareja(3);
      miDirectorio.imprimirPareja(4);
      //System.out.println(Falso11.toString())

      System.out.println("*************cambio************");
      System.out.println("");
      System.out.println("*****parejas registradas*****");
      System.out.println("numero de registros "miDirectorio.getEspaciosOcupados());
      miDirectorio.quitar(Martin,Falso7);
      miDirectorio.imprimirPareja(0);
      miDirectorio.imprimirPareja(1);
      miDirectorio.imprimirPareja(2);
      miDirectorio.imprimirPareja(3);
      miDirectorio.imprimirPareja(4);
      System.out.println("*************cambio************");
      System.out.println("");
      System.out.println("*****parejas registradas*****");
      System.out.println("numero de registros "miDirectorio.getEspaciosOcupados());
      miDirectorio.quitar(Martin,Andres);
      miDirectorio.imprimirPareja(0);
      miDirectorio.imprimirPareja(1);
      miDirectorio.imprimirPareja(2);
      miDirectorio.imprimirPareja(3);
      miDirectorio.imprimirPareja(4);
      System.out.print("la pareja de Falso11 :");
      try {
        System.out.println(miDirectorio.encontrarOtra(Falso11));
      } catch(NullPointerException e) {
        System.out.println("no tiene pareja");
      }
  }
}
