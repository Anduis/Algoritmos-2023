import java.util.Random;

//using array methods

public class QuickSelect1 {
  static Random rand = new Random();

  public static void main(String[] args) {
    int[] arr = { 5, 3, 15, 234, 114, 1540 };
    int i = 3;
    System.out.println(arr[find(arr, 0, arr.length - 1, i)]);
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

  // Finds the index of the ith largest element in the list
  public static int find(int[] arr, int lower, int upper, int i) {
    if (upper >= lower && i >= 1 && upper - lower + 1 >= i) {
      int index = rand.nextInt(upper - lower + 1) + lower;
      int pivotLoc = split(arr, lower, upper, index);
      if (upper - pivotLoc < i - 1)
        return find(arr, lower, pivotLoc - 1, i - upper + pivotLoc - 1);
      else if (upper - pivotLoc == i - 1)
        return pivotLoc;
      else if (upper - pivotLoc > i - 1)
        return find(arr, pivotLoc + 1, upper, i);
    }
    return -1; // Element not found
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
