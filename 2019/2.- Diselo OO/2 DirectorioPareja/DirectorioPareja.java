/*
*Autor: Andres Anguiano
*Matricula: 1638975x
*fecha:26 Marzo 2020
**Indicaciones dadas:
**El bosquejo de la clase DirectorioPareja, página 76 de las notas,
**terminar de codificarlo suponiendo que los parejas de personas están guardadas en un arreglo con capacidad 1,000.
**El directorio deberá llevar registro de cuantas parejas de personas están actualmente
*/
public class DirectorioPareja {
  // ... variables de instancia ...
  Persona [][] registro = new Persona [1000][2]; //suponiendo que los parejas de personas están guardadas en un arreglo con capacidad 1,000.
  public long espaciosOcupados = 0; //El directorio deberá llevar registro de cuantas parejas de personas están actualmente

  public DirectorioPareja(){}//constructor

  public void insertar(Persona persona, Persona otra) { //Guarda la pareja en el primer espacio desocupado
    for (int i = 0; i < 1000 ; i++ ) {
      if (registro[i][0] == null) {
        registro[i][0] = persona;
        registro [i][1] = otra;
        espaciosOcupados++;
        break;
      }
    }
  }

  public boolean igualA ( Persona otra ) {
    if (otra == this) {
      return true;
    }return false;
  }

  public Persona encontrarOtra(Persona persona) { //encontrar su pareja
    //el metodo encontrarOtra(), usa el metodo igualA() para la busqueda.
    for (int i = 0 ; i < 1000 ; i++ ) {
      if (persona.igualA(registro[i][0])) {
        return registro[i][1];
      }
      else if (persona.igualA(registro[i][1])) {
        return registro[i][0];
      }
    }
    return null ;
  }

  public void quitar (Persona persona, Persona otra) {//El metodo quitar() realiza una busqueda en el contenido del directorio y quita el par de personas indicadas
    for (int i = 0 ; i < 1000 ; i++ ) {
      if (persona.igualA(registro[i][0]) && otra.igualA(registro[i][1])) {
        registro[i][0] = null;
        registro[i][1] = null;
        espaciosOcupados--;
        break;
      }
      else if (otra.igualA(registro[i][0]) && persona.igualA(registro[i][1])) {
        registro[i][0] = null;
        registro[i][1] = null;
        espaciosOcupados--;
        break;
      }else System.out.println("Las personas ingresadas no son pareja"); break;
    }
  }

  public long getEspaciosOcupados(){return espaciosOcupados;}; //obtener el conteo de los especios ocupados
  public void imprimirPareja(int x){
    System.out.println(registro[x][0] +" "+ registro[x][1]);
  }
  //esto es una pruba, descomentar para ejecutar prueba
  /*
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
    System.out.println("numero de registros " + miDirectorio.getEspaciosOcupados());
    miDirectorio.imprimirPareja(0);
    miDirectorio.imprimirPareja(1);
    miDirectorio.imprimirPareja(2);
    miDirectorio.imprimirPareja(3);
    miDirectorio.imprimirPareja(4);
    //System.out.println(Falso11.toString())

    System.out.println("*************cambio************");
    System.out.println("");
    System.out.println("*****parejas registradas*****");
    System.out.println("numero de registros " + miDirectorio.getEspaciosOcupados());
    System.out.print("quitar la pareja de Martin y falso7: ");
    miDirectorio.quitar(Martin,Falso7);
    miDirectorio.imprimirPareja(0);
    miDirectorio.imprimirPareja(1);
    miDirectorio.imprimirPareja(2);
    miDirectorio.imprimirPareja(3);
    miDirectorio.imprimirPareja(4);
    System.out.println("*************cambio************");
    System.out.println("");
    System.out.println("*****parejas registradas*****");
    System.out.println("numero de registros " + miDirectorio.getEspaciosOcupados());
    System.out.print("quitar la pareja de Martin y Andres: ");miDirectorio.quitar(Martin,Andres);
    miDirectorio.imprimirPareja(0);
    miDirectorio.imprimirPareja(1);
    miDirectorio.imprimirPareja(2);
    miDirectorio.imprimirPareja(3);
    miDirectorio.imprimirPareja(4);
    System.out.print("la pareja de Falso11 : ");
    try {
      System.out.println(miDirectorio.encontrarOtra(Falso11));
    }
    catch(NullPointerException e) {
      System.out.println("no tiene pareja");
    }
  }
  */
}
