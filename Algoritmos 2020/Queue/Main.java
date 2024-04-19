import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int acciones = scan.nextInt();
    int tam = scan.nextInt();

    ArregloQueue Q = new ArregloQueue(tam, acciones);
    for ( ; acciones > 0 ; --acciones)
    {
      int x = scan.nextInt();
      if (x==1)
      {
        int y = scan.nextInt();
        Q.enqueue(y);
      }
      if (x==2)
      {
        Q.dequeue();
      }
    }
    Q.estado();
    Q.imprime();
  }
}

class ArregloQueue
{
  protected int[] Q;
  int tail = 0;
  int head = 0;
  int N;
  int[] errores; //los posibles valores son overflow=1, underflow=2
  int erroresIndex=-1; //para registrar en que orden aparecen
  //boolean overflow = false;
  //boolean underflow = false;

  public ArregloQueue(int x, int acciones)
  {
    errores = new int[acciones];//no pueden haber mas errores que acciones
    N=x+1;
    Q = new int[x+1];
  }

  public boolean isEmpty()
  {
    return (head==tail && size()==0);
  }

  public void enqueue(int x)
  {
    if (size()==N-1)
    {
      errores[++erroresIndex] = 1;
      //overflow = true;
    }
    else
    {
      Q[tail]=x;
      tail = (tail+1);
      tail = tail%N;
    }
  }

  public void dequeue ()
  {
    if (isEmpty())
    {
      errores[++erroresIndex] = 2;
      //underflow = true;
    }
    else
    {
      Q[head] = 0;
      head = (head+1);
      head = head%N;
    }
  }

  public int size(){
    return (N-head+tail)%N;
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
      int temp = head;
      for (int i = size(); i>0 ; --i )
      {
        System.out.print(Q[temp]);
        if ((i-1)>0)
        {
          System.out.print(" ");
        }
        temp = (temp+1);
        temp = temp%N;
      }
      System.out.print("\n");
    }
  }
}
