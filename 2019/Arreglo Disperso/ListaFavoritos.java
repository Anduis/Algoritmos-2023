/** Lista de elementos favoritos, con sus cuentas de acceso. */
public class ListaFavoritos<E> {
	protected ListaPosicion<Entrada<E>> listaF; // lista de entradas
	/** Constructor; tiempo O(1) */
	public ListaFavoritos() {
		listaF = new ListaNodoPosicion<Entrada<E>>();
	}
	/** Regresa el número de elementos en la lista; tiempo O(1). */
	public int size() { return listaF.size(); }
	/** Prueba si la lista está vacía; tiempo O(1) */
	public boolean isEmpty() { return listaF.isEmpty(); }
	/** Quitar un elemento dado, dado que esta en la lista; tiempo O(n) */
	public void remove(E obj) {
		Posicion<Entrada<E>> p = encontrar(obj); // búsqueda de obj
		if( p!=null )
			listaF.remove(p); // quitar la entrada
	}
	/** Incrementar la cuenta de accesos para el elemento dado y lo inserta
	 * si todavía no está presente; tiempo O(n) */
	public void access(E obj) {
		Posicion<Entrada<E>> p = encontrar(obj); // búsqueda de obj
		if( p!=null )
			p.elemento().incrementarCuenta(); // incrementar cuenta de acceso
		else {
			listaF.addLast(new Entrada<E>(obj)); // agregar la entrada al final
			p = listaF.last();
		}
		moverArriba(p);
	}
	/** Encontar la posición de un elemento dado, o regresar null; tiempo O(n) */
	protected Posicion<Entrada<E>> encontrar(E obj) {
		for( Posicion<Entrada<E>> p: listaF.positions())
			if( valor(p).equals(obj))
				return p;	// encontrado en posición p
		return null;		// no encontrado
	}
   /** Mueve hacia arriba una entrada a su posición correcta en la lista; 
    * tiempo O(n) */
	protected void moverArriba(Posicion<Entrada<E>> cur) {
		Entrada<E> e = cur.elemento();
		int c = cuenta(cur);
		while( cur!=listaF.first() ) {
			Posicion<Entrada<E>> prev = listaF.prev(cur); // posición previa
			if( c<=cuenta(prev) ) break; // entrada en su posicón correcta
			listaF.set(cur, prev.elemento()); // descender la entrada previa
			cur = prev;
		}
		listaF.set(cur, e); // guardar la entrada en su posición final
	}
	/** Regresa los k elementos más accedidos, para un k; tiempo O(k) */
	public Iterable<E> top(int k) {
		if( k<0 || k>size() )
			throw new IllegalArgumentException("Argumento inválido");
		ListaPosicion<E> T = new ListaNodoPosicion<E>(); // lista top-k
		int i=0; // contador de las entradas agregadas a la lista
		for( Entrada<E> e: listaF ) {
			if (i++ >= k)
				break;	// todas las k entradas han sido agregadas
			T.addLast( e.valor() ); // agregar una entrada a la lista
		}
		return T;
	}
	/** Representación String de lista de favoritos */
	public String toString() { return listaF.toString(); }
	/** Método auxiliar que extrae el valor de la entrada en una posición */
	protected E valor(Posicion<Entrada<E>> p) { return p.elemento().valor(); }
	/** Método auxiliar que extrae el contador de la entrada en una pos. */
	protected int cuenta(Posicion<Entrada<E>> p) {return p.elemento().cuenta();}
	/** Clase interna para guardar elementos y sus cuentas de acceso. */
	protected static class Entrada<E> {
		private E valor; // elemento
		private int cuenta; // cuenta de accesos
		/** Constructor */
		Entrada(E v) {
			cuenta = 1;
			valor = v;
		}
		/** Regresar el elemento */
		public E valor() { return valor; }
		public int cuenta() { return cuenta; }
		public int incrementarCuenta() { return ++cuenta; }
		public String toString() { return "["+cuenta+","+valor+"]"; }
	}
} // Fin de la clase ListaFavoritos

