import java.util.ArrayList;

/* Sort functions used in path finding to
 * determine lowest F cost Node. Bubble sort is mainly
 * used, quick sort needs work. Currently not working
 */
public class Sort {

	private boolean lowToHigh, highToLow;
	public Sort() {
		lowToHigh = true;
		highToLow = false;
	}

	private static void swapArray(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void swapList(ArrayList<Node> list, int i, int j) {
		Node temp = list.get(i);
		list.remove(i);
		list.add(i + 1, temp);
	}

	public void bubbleSort(int[] data) {
		int Switch = -1;
		while (Switch != 0) {
			Switch = 0;
			if (lowToHigh) {
				for (int i = 0; i < data.length - 1; i++) {
					if (data[i] > data[i + 1]) {
						swapArray(data, i, i+1);
						Switch = 1;
					}
				}
			}

			else if (highToLow) {
				for (int i = 0; i < data.length - 1; i++) {
					if (data[i] < data[i + 1]) {
						swapArray(data, i+1, i);
						Switch = 1;
					}
				}
			}
		}
	}

	public void bubbleSort(ArrayList<Node> list) {
		int cont = -1;
		while (cont != 0) {
			cont = 0;

			if (lowToHigh) {
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).getF() > list.get(i + 1).getF()) {
						swapList(list, i, i+1);
						cont = 1;
					}
				}
			} else if (highToLow) {
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).getF() < list.get(i + 1).getF()) {
						swapList(list, i, i+1);
						cont = 1;
					}
				}
			}
		}
	}
	static int partition(int[] arr, int low, int high) {
		// pivot
		int pivot = arr[high];
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
		for(int j = low; j <= high - 1; j++) {
			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {
				// Increment index of
				// smaller element
				i++;
				swapArray(arr, i, j);
			}
		}
		swapArray(arr, i + 1, high);
		return (i + 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);
			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static int partition(ArrayList<Node> list, int low, int high) {
		// pivot
		Node pivot = list.get(high);
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
		for(int j = low; j <= high - 1; j++) {
			// If current element is smaller
			// than the pivot
			if (list.get(i).getF() < pivot.getF()) {
				// Increment index of
				// smaller element
				i++;
				swapList(list, i, j);
			}
		}
		swapList(list, i + 1, high);
		return (i + 1);
	}

	public static void quickSort(ArrayList<Node> list, int low, int high) {
		if (low < high) {
			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(list, low, high);
			// Separately sort elements before
			// partition and after partition
			quickSort(list, low, pi - 1);
			quickSort(list, pi + 1, high);
		}
	}

	public void setLowToHigh() {
		lowToHigh = true;
		highToLow = false;
	}

	public void setHighToLow() {
		lowToHigh = false;
		highToLow = true;
	}
}
