import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Binomial A = new Binomial();
    Scanner scan = new Scanner(System.in);

    int entradas = scan.nextInt();
    while (entradas != 0)
    {
      A.agrega(scan.nextInt());
      entradas--;
    }
    A.imprime();

    /*
    EXPLICACION DE LA SALIDA
    se muestran los arboles en orden ascendente por grado separados por una linea vacia
    cada nodo impreso tendra sus hijo un paso de indentado mas delante
    los nodos a la misma altura de indentado son hermanos
    cada nodo imprimira su elemento seguido de su grado en la forma *ELEMENTO* B*GRADO*
    La impresion de los nodos sera en el siguiente orden
    Nodo padre
      Nodo hijo mas izquierdo
       El hijo del hijo si es que lo hay(recursion)
      Hermano del hijo mas izquierdo
    */

    //Codigo de prueba el metodo elimina() descomentar lo siguiente y comentar las lineas 9-15
    /*
    //para agregar un numero escribir 1 *TU NUMERO*
    //para sacar el maximo del bosque, igresar un 2
    //despues de cada instruccion el programa imprimira el estado del bosque
    //para salir, ingresar cualquer letra
    while (scan.hasNextInt())
    {
      int x = scan.nextInt();
      if (x==1)
        A.agrega(scan.nextInt());
      if (x==2)
        A.elimina();
      System.out.println("*-*-*-*-*-*-*-*");
      A.imprime();
    }
   */

  }
}
class Binomial
{
  Lista bosque;
  Binomial(){bosque = new Lista();}
  void agrega(int x)
  {
    Arbol temp = new Arbol(x);
    bosque.insert(new NodoL(temp));
    revisa();
  }
  void elimina()//elimina a la raiz mas grande
  {
    NodoL temp = bosque.head;
    NodoL max = bosque.head;
    while  (temp != null)
    {
      if (max.elemento.raiz.elemento < temp.elemento.raiz.elemento)
        max = temp;
      temp = temp.siguiente;
    }
    Nodo actual = max.elemento.raiz.hijo;
    bosque.delete(max);
    while (actual != null)
    {
      actual.padre = null;
      Nodo her = actual.hermano;
      actual.hermano = null;
      bosque.insert(new NodoL(new Arbol(actual)));
      actual = her;
      revisa();
    }
  }
  void revisa()//si en el bosque deben unirse arboles
  {
    NodoL actual = bosque.head;
    while (actual.siguiente != null)
    {
      if (actual.elemento.grado() == actual.siguiente.elemento.grado())
      {
        actual.siguiente.elemento.union(actual.siguiente.elemento.raiz,actual.elemento.raiz);
        bosque.delete(actual);
        actual = actual.siguiente;
      }
      else
        actual = actual.siguiente;
    }
  }
  void imprime()
  {
    NodoL actual = bosque.head;
    while (actual != null)
    {
      actual.elemento.imprime(actual.elemento.raiz, "");
      if (actual.siguiente != null)
        System.out.println();
      actual = actual.siguiente;
    }
  }
}

class Arbol
{
  Nodo raiz;
  Arbol(int x){ raiz = new Nodo(x);}
  Arbol(Nodo x){ raiz = x;}
  int grado(){ return raiz.grado;}
  void union(Nodo R1, Nodo R2)
  {
    if (R1.elemento > R2.elemento)
    {
      R2.hermano = R1.hijo;
      R2.padre = R1;
      R1.hijo = R2;
      R1.grado++;
      raiz = R1;
    }
    else
    {
      R1.hermano = R2.hijo;
      R1.padre = R2;
      R2.hijo = R1;
      R2.grado++;
      raiz = R2;
    }
  }
  void imprime(Nodo x, String dentado)
  {
    while (x != null)
    {
      System.out.println(dentado + x.elemento+" B" + x.grado);
      imprime(x.hijo, dentado+" ");
      x = x.hermano;
    }
  }
}
class Nodo
{
  int elemento;
  int grado;
  Nodo padre;
  Nodo hermano;// inmediato a la derecha
  Nodo hijo;//el mas izquierdo
  Nodo(int x)
  {
    elemento = x;
    grado=0;
  }
}

class Lista//para que los arboles se inserten con grados en orden ascendente
{
  NodoL head;
  void insert(NodoL x)
  {
    if (head == null)
      head = x;
    else
    {
      NodoL actual = head;
      while(actual != null)
      {
        if (x.elemento.grado() < actual.elemento.grado())
        {
          x.siguiente = actual;
          if (actual == head)
            head = x;
          else
            pre(actual).siguiente = x;
          return;
        }
        actual = actual.siguiente;
      }
      pre(actual).siguiente= x;
    }
  }
  NodoL pre(NodoL x)
  {
    NodoL actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  void delete(NodoL x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
}
class NodoL
{
  Arbol elemento;
  NodoL siguiente;
  NodoL (Arbol e){ elemento = e;}
}
