public class TreeTraversal {
   public static <E> int depth (Tree<E> T, Posicion<E> v) {
      if ( T.isRoot(v) )
         return 0;
      else
         return 1 + depth(T, T.parent(v) );
   }

   public static <E> int height1 (Tree<E> T) {
      int h = 0;
      for ( Posicion<E> v : T.positions() )
         if ( T.isExternal(v) )
            h = Math.max( h, depth(T,v) );
      return h;
   }

   public static <E> int height2 (Tree<E> T, Posicion<E> v) {
      if ( T.isExternal(v) ) return 0;
      int h = 0;
      for ( Posicion<E> w : T.children(v) )
         h = Math.max(h, height2( T, w ));
      return 1 + h;
   }

   public static <E> String toStringPreorden(Tree<E> T, Posicion<E> v) {
      String s = v.elemento().toString(); // acción principal de visita
      for (Posicion<E> h: T.children(v))
         s += ", " + toStringPreorden(T, h);
      return s;
   }

   public static <E> String representacionParentetica(
                              Tree<E> T, Posicion<E> v) {
      String s = v.elemento().toString(); // acción principal de visita
      if (T.isInternal(v)) {
         Boolean primeraVez = true;
         for (Posicion<E> w : T.children(v))
            if (primeraVez) {
               s += " ( "+representacionParentetica(T, w); // 1er hijo
               primeraVez = false;
            }
            else
               s += ", "+representacionParentetica(T, w); // hijos siguientes
         s += " )"; // cerrar paréntesis
      }
      return s;
   }
               
   public static <E> String toStringPostorden(Tree<E> T, Posicion<E> v) {
      String s = "";
      for (Posicion<E> h: T.children(v))
         s += ", " + toStringPreorden(T, h)+" ";
      s += v.elemento();
      return s;
   }
               
   public static <E> int espacioDisco(Tree<E> T, Posicion<E> v) {
      int t = tam(v);  //iniciar con el tamaño del propio nodo
      for (Posicion<E> h: T.children(v))
         // agregar espacio calculado recursivamente usado por los hijos
         t += espacioDisco(T, h);
      if (T.isInternal(v))
         // imprimir nombre y espacio en disco usado
         System.out.print(nombre(v) + ": " + t);
      return t;
   }

   public static <E> int tam(Posicion<E> v) {
      // próximamente
      return 0;
   }

   public static <E> String nombre(Posicion<E> v) {
      // próximamente
      return "";
   }


}
