public class conjun{
  public static void main(String[] args) {
    int[]a={1,2,3,4,5};
    int[]b={2,4,6,8,0};
    int[]c={2,7,8,9,0};
    System.out.println("Son conjuntos Disjuntos: "+sonDisjuntos(a,b,c));
  }
  public static boolean estaEn(int conjunto[], int elemento){// este metodo es de complejidad lineal O(n)
    for (int i=0 ; i < conjunto.length ; i++) if (conjunto[i]==elemento) return true;
    return false;
  }
  public static boolean sonDisjuntos(int[]a,int[]b,int[]c){// este metodo es de complejidad n+
    for (int i=0 ; i < a.length ; i++ ) if (estaEn(b,a[i]) && estaEn(c,a[i])) return false;
    return true;
  }
}
