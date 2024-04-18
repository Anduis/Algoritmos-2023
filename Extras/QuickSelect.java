import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//using list methods

public class QuickSelect {

  static Random random = new Random();

  public static void main(String[] args) {
    List<Integer> myList = new ArrayList<>(List.of(5, 3, 15, 234, 114, 1540));
    int i = 6;
    System.out.println(find(myList, 0, myList.size() - 1, i));
  }

  // Splits the list into two parts: elements less than pivot and elements greater
  // than pivot
  static int split(List<Integer> list, int lower, int upper, int pivotLoc) {
    int pivot = list.get(pivotLoc);
    swap(list, lower, pivotLoc);
    pivotLoc = lower;

    for (int index = lower + 1; index <= upper; index++)
      if (pivot > list.get(index)) {
        pivotLoc++;
        swap(list, index, pivotLoc);
      }

    swap(list, lower, pivotLoc);
    return pivotLoc;
  }

  // Finds the index of the ith largest element in the list
  static int find(List<Integer> list, int lower, int upper, int i) {
    if (upper >= lower && i >= 1 && i <= upper - lower + 1) {
      int index = random.nextInt(upper - lower + 1) + lower;
      int pivotLoc = split(list, lower, upper, index);

      if (upper - pivotLoc < i - 1)
        return find(list, lower, pivotLoc - 1, i - upper + pivotLoc - 1);
      else if (upper - pivotLoc == i - 1)
        return list.get(pivotLoc);
      else if (upper - pivotLoc > i - 1)
        return find(list, pivotLoc + 1, upper, i);
    }
    return -1; // Element not found
  }

  static void swap(List<Integer> list, int i, int j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}