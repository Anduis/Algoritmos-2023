public void add(int x, E e)
  throws IndexOutOfBoundsException {
  revisarIndice(x);
  if (isFull()) {
    N *= 2;
    E[] B =(E[]) new Object[N];
    for (int i=0; i<tam; i++)
      B[i] = A[i];
    A = B;
  }
  if (x>=(size()/2)) {
    for (int k=(size()/2)-1; k>=x; k--)  // desplazar elementos hacia adelante
    A[k+1] = A[k];
    A[(f+x)%N] = e;
    r++;
  }
  for (int k=-1; k<x; k++)  // desplazar elementos hacia adelante
  A[k+1] = A[k];
  A[(f+x)%N] = e;
  r++;
}
public void add(int x, E e)
  throws IndexOutOfBoundsException {
  revisarIndice(x);
  if (isFull()) {
    N *= 2;
    E[] B =(E[]) new Object[N];
    if(r>f){
      for (int i=0; i<r; i++) B[i] = A[i];
      for (int i=N; i>f ; i--){
        B[i] = A[i];
        f = N-i;
      }
      A = B;
    }
    else if (r<f){
      for (int i=0; i<f; i++) {
        B[i] = A[i];
        f=i;
      }
      A = B;
    }
  }
  if(x==f){
    A[f]=e;
    if (f==0) f=N-1;
    else f = (f-1);
  }
  else if(x!=f){
    for (int k=size()-1; k>=x; k--)  // desplazar elementos hacia adelante
      A[k+1] = A[k];
    if(f==N-1) A[(f+1+x)%N] = e;
    else
    A[(f+x)%N] = e;
    r = (r+1)%N;
  }
}
A[x]=null;
/*
if(x==(f+1)%N){
  E e = A[f];
  A[f] = null;
  f=(f+1)%N;
}
*/
for (int i=x; i<size()-1; i++)
  A[f+i] = A[f+i+1];
if (r==0) r=N-1;
else r = (r-1);
return temp;
if (x <= size()/2) {
  int i=f;
  for (; i<((f+x)%N); i=(i+1)%N)  // desplazar elementos hacia adelante
    A[i] = A[(i+1)%N];
  if (i<((f+x)%N)) A[((f+1+x)%N)]=e;
  else {
    A[f]=e;
    f= (N+f-1)%N;
  }
}
