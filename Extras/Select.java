import java.util.Arrays;

public class Select {
  public static void main(String[] args) {
    int[] arr = { 5, 3, 15, 234, 114, 1540 };
    int i = 3;
    System.out.println(arr[select(arr, 0, arr.length - 1, i)]);
  }

  public static int split(int[] arr, int lower, int upper, int pivotLoc) {
    int pivot = arr[pivotLoc];
    swap(arr, lower, pivotLoc);
    pivotLoc = lower;
    for (int index = lower + 1; index <= upper; index++)
      if (pivot > arr[index]) {
        pivotLoc++;
        swap(arr, index, pivotLoc);
      }

    swap(arr, lower, pivotLoc);
    return pivotLoc;
  }

  public static int select(int[] arr, int lower, int upper, int i) {
    int n = upper - lower + 1;
    if (n == 1) {
      return lower;
    }
    int[] medians = new int[(n + 4) / 5];
    for (int j = 0; j < n / 5; j++) {
      int[] subArray = Arrays.copyOfRange(arr, lower + 5 * j, lower + 5 * j + 5);
      Arrays.sort(subArray);
      medians[j] = subArray[subArray.length / 2];
    }
    if (n % 5 != 0) {
      int[] subArray = Arrays.copyOfRange(arr, lower + (n / 5) * 5, upper + 1);
      Arrays.sort(subArray);
      medians[medians.length - 1] = subArray[subArray.length / 2];
    }
    int index = select(medians, 0, medians.length - 1, medians.length / 2);
    int pivotLoc = split(arr, lower, upper, lower + index);
    if (upper - pivotLoc < i - 1) {
      return select(arr, lower, pivotLoc - 1, i - (upper - pivotLoc + 1));
    } else if (upper - pivotLoc == i - 1) {
      return pivotLoc;
    } else {
      return select(arr, pivotLoc + 1, upper, i);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
