public class Progresion {
/** Primer valor de la progresi on. */
protected long primero ;
/** Valor actual de la progresi on. */
protected long actual ;
/** Constructor por defecto . */
Progresion () {
actual = primero = 0;
}
/** Reinciar la progresi on al primer valor .
*
* @return primer valor
*/
protected long primerValor () {
actual = primero ;
return actual ;
}
/** Avanzar la progresi on al siguiente valor .
*
* @return siguiente valor de la progresi on
*/
protected long siguienteValor () {
return ++ actual ; // siguiente valor por defecto
}
/** Imprimir los primeros n valores de la progresi on
*
* @param n nu mero de valores a imprimir
*/
public void mostrarProgresion ( int n) {
System . out . print ( primerValor ());
for (int i = 2; i <= n; i ++)
System . out . print (" " + siguienteValor ());
System . out . println (); // salto del l nea
}
}
