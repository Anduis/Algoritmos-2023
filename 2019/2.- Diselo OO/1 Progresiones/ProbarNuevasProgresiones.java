/*
*Autor: Andres Anguiano
*Fecha: 19 Marzo 2020
**INDICACIONES DADAS*
*Agregar la aplicación ProbarNuevasProgresiones la cual crea progresiones de las clases mencionadas previamente para mostrar el resultado de estas.
*/
class ProbarNuevasProgresiones { //Agregar la aplicación ProbarNuevasProgresiones
  public static void main ( String [] args ) {
    Progresion prog;
  // probar ProgresionAbsoluta
  System . out . println (" ProgresionAbsoluta valores iniciales por defecto:");
  prog = new ProgresionAbsoluta (); //la cual crea progresiones de las clases mencionadas previamente para mostrar el resultado de estas.
  prog . mostrarProgresion (10);
  System . out . println (" ProgresionAbsoluta valores iniciales: 125, 120");
  prog = new ProgresionAbsoluta (125, 120 );
  prog . mostrarProgresion (10);
  // probar ProgresionRaiz
  System.out.println();
  System.out.println (" ProgresionRaiz con inicio por defecto:");
  prog = new ProgresionRaiz ();
  prog . mostrarProgresion (10);
  System . out . println (" ProgresionRaiz iniciando con primer valor: 207936");
  prog = new ProgresionRaiz (207936);
  prog . mostrarProgresion (10);
  }
}
