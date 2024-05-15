/*Sophie Rubí Domínguez Alvarado, Matrícula: 1837995F.
Escribir la aplicación Matriz, la cual puede sumar y multiplicar matrices de tipos genéricos, de tal forma que las matrices involucradas puedan contener tipos numéricos arbitrarios, como Integer, o Double. Limitar el tipo genérico al tipo Number en esta clase. Agregar código que muestre el uso de la clase Matriz.*/
public class MatrizSophie {
    int [][] Number = new int [3][3];
    public static void main(String[] args) {
        Double[][] a = {{2.0,5.0,4.0},{7.0,6.0,1.0},{8.0,4.0,3.0}};
        Integer[][] b = {{5,7,6},{2,5,4},{3,6,5}};
        Number[][] suma = sumarmatrices(a,b);
        Number [][] multiplicacion = multiplicarmatrices(a,b);
        System.out.println("El programa realiza la suma y multiplicacion de dos matrices, de las que se muestran en pantalla, la primera es el resultado de la suma y la segunda el de la multiplicacion: ");
        ImprimirResultado(suma);
        ImprimirResultado(multiplicacion);
    }

        public static Number[][] sumarmatrices (Number a[][], Number b[][]){
            if (a.length == b.length && a[0].length == b[0].length){
                int ident = Math.min(Met(a), Met(b));
                Number [][] suma = new Number[a.length][b[0].length];
                for (int i=0; i < a.length; i++) {
                    for (int j=0; j < a[i].length; j++) {
                        suma[i][j]= Conversion(a[i][j].doubleValue()+b[i][j].doubleValue(),ident);
                    }
                }
            return suma;
            }
              return null;
        }

        public static Number [][] multiplicarmatrices (Number[][] a, Number[][] b){
            if(a[0].length == b.length){
                int ident = Math.min(Met(a), Met(b));
                Number[][] multiplicacion = new Number[a.length][b[0].length];
                double temp;
                for (int i=0; i < multiplicacion.length; i++) {
                    for (int j=0; j < multiplicacion[i].length; j++) {temp = 0.0;
                        for (int k=0; k<b.length; k++){
                            temp += a[i][k].doubleValue() * b[k][j].doubleValue();
                        }
                        multiplicacion[i][j] =Conversion(temp, ident);
                    }
                }return multiplicacion;
            }
            return null;
        }

        public static int Met (Number[][] a){
            int entero = 0;
            if (a instanceof Double[][]) {entero = 1;}
                else if (a instanceof Float[][]) {entero = 2;}
                else if (a instanceof Long[][]) {entero = 3;}
                else if (a instanceof Integer[][]) {entero = 4;}
                else if (a instanceof Short[][]) {entero = 5;}
                else if (a instanceof Byte[][]) {entero = 6;}
            return entero;
        }

        public static Number Conversion(Double b, int entero){
            Number cambio = 0;
            switch(entero){
                case 1: cambio = b.doubleValue();
                    break;
                case 2: cambio = b.floatValue();
                    break;
                case 3: cambio = b.longValue();
                    break;
                case 4: cambio = b.intValue();
                    break;
                case 5: cambio = b.shortValue();
                    break;
                case 6: cambio = b.byteValue();
                    break;
                default: break;
            }
            return cambio;
        }

        public static void ImprimirResultado(Number[][] number){
            for(int i=0;i<number.length;i++){
                for(int j=0;j<number[i].length;j++){
                    System.out.print(number[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
}
