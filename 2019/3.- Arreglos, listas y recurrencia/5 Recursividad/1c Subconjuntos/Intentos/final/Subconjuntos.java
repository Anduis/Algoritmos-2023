/*
*Autor: Andres Anguiano 1638975x
Fecha: 9 Abril 2020
**INDICACIONES DADAS:
**Aplicación Subconjuntos la cual genera todos los subconjuntos de un conjuntos de n elementos
**(sin repetir ningún subconjunto)
*/
import java.util.ArrayList;
public class Subconjuntos {
	public static void main(String[] args){
		String[] conjunto = { "a", "b", "c", "d"};
		int i = conjunto.length-1;
		ArrayList<ArrayList<String>> subconjuntos = subconjuntosDe(conjunto, i);
		System.out.println(subconjuntos);
	}

	static ArrayList<ArrayList<String>> subconjuntosDe(String[] conjunto, int i){
	  ArrayList<ArrayList<String>> todos;
		if (i < 0) {
			todos = new ArrayList<ArrayList<String>>();
			todos.add(new ArrayList<String>());
		}else {
			todos = subconjuntosDe(conjunto, i-1);
			String elemento = conjunto[i];
			ArrayList<ArrayList<String>> subconjuntos	= new ArrayList<ArrayList<String>>();
			for (ArrayList<String> subconjunto : todos) {
				ArrayList<String> nuevo = new ArrayList<String>();
				nuevo.addAll(subconjunto);
				nuevo.add(elemento);
				subconjuntos.add(nuevo);
			}
			todos.addAll(subconjuntos);
		}
		return todos;
	}
}
