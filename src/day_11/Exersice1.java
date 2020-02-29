package day_11;

public class Exersice1 {
	
	public static void bubbleSort1(int[] list) {
		int count = 1;
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = list.length - 1; j > i; j--) {
				if(list[j] < list[j-1]) {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
			System.out.print("Pass " + count + ": ");
			for (int x : list)
				System.out.print(x + " ");
			count++;
			System.out.println();
		}
	}
	
	public static void selectionSort1(int[] list) {
		int count = 1;
		for(int i = 0; i < list.length; i++) {
			int min = list[i];
			int index = i;
			for(int j = i; j < list.length; j++) {
				if (min > list[j]) {
					min = list[j];
					index = j;
				}
			}
			if (list[i] != list[index]) {
				int temp = list[i];
				list[i] = min;
				list[index] = temp;

				System.out.print("Pass " + count + ": ");
				for (int x : list)
					System.out.print(x + " ");
				count++;
				System.out.println();
			}
		}
		
	}
	
	public static void insertionSort1(int[] list) {
		int count = 1;
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = i + 1; j > 0 ; j--) {
				if(list[j] > list[j-1])
					break;
				else {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}

			System.out.print("Pass " + count + ": ");
			for (int x : list)
				System.out.print(x + " ");
			count++;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] data = {24, 15, 29, 11, 47, 12};
		int[] tmp = data.clone();
		System.out.println("Before Sorting");
		for (int x : tmp) 
			System.out.print(x + " ");
		System.out.println("\n");
		System.out.println("After Bubble Sorting");
		bubbleSort1(tmp);
		
		tmp = data.clone();
		System.out.println("\nBefore Sorting");
		for (int x : tmp) 
			System.out.print(x + " ");
		System.out.println("\n");
		
		System.out.println("After Selection Sorting");
		selectionSort1(tmp);

		tmp = data.clone();
		System.out.println("\nBefore Sorting");
		for (int x : tmp) 
			System.out.print(x + " ");
		System.out.println("\n");
		
		System.out.println("After Insertion Sorting");
		insertionSort1(tmp);
	}


}
