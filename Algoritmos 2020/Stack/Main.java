import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int acciones = scan.nextInt();
    int tam = scan.nextInt();

    ArregloStack S = new ArregloStack(tam, acciones);
    for ( ; acciones > 0 ; --acciones)
    {
      int x = scan.nextInt();
      if (x==1)
      {
        int y = scan.nextInt();
        S.push(y);
      }
      if (x==2)
      {
        S.pop();
      }
    }
    S.estado();
    S.imprime();
  }
}

class ArregloStack
{
  protected int[] S;
  private int top = -1;
  protected int N;
  int[] errores; //los posibles valores son overflow=1, underflow=2
  int erroresIndex=-1; //para registrar en que orden aparecen
  //boolean overflow = false;
  //boolean underflow = false;

  public ArregloStack(int x, int acciones)
  {
    errores = new int[acciones];//no pueden haber mas errores que acciones
    N = x;
    S = new int[x];
  }

  public boolean isEmpty()
  {
    return (top < 0);
  }

  public void push(int x)
  {
    if ((top + 1) == N)
    {
      errores[++erroresIndex] = 1;
    //  overflow = true;
    }
    else
    {
      S[++top] = x;
    }
  }

  public void pop()
  {
    if (isEmpty())
    {
      errores[++erroresIndex] = 2;
      //underflow = true;
    }
    else
    {
      S[top--] = 0;
    }
  }

  public void estado()//imprime los errores que hayan ocurrido
  {
    for (int x : errores )
    {
      if(x == 1)
      {
        System.out.println("Overflow");
      }
      else if (x==2)
      {
        System.out.println("Underflow");
      }
    }
    if (isEmpty())
    {
      System.out.println("empty");
    }
    /*
    if (underflow)
    {
      System.out.println("Underflow");
    }
    if (overflow)
    {
      System.out.println("Overflow");
    }
    */
  }

  public void imprime()
  {
    if (!isEmpty())
    {
      for (int i = top; i>=0 ; --i )
      {
        System.out.print(S[i]);
        if (i>0)
        {
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    }
  }
}
