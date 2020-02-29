package day_11;

import java.util.Scanner;

public class Exersice2 {
	
	public static void generateItems(int[] items, int n) {
		for (int i = 0; i < items.length; i++)
			items[i] = (int)(n*Math.random());
	}
	
	public static void quickSort(int[] items) {
		int first = 0;
		int last = items.length - 1;
		quickSort(items, first, last);
		
		for (int x = 0; x < 20; x++)
			System.out.print(items[x] + " ");
		System.out.println();
	}
	
	public static void quickSort(int[] items, int first, int last) {
		if(first < last) {
			int pivoIndex = partition(items, first, last);
			
			quickSort(items, first, pivoIndex-1);
			quickSort(items, pivoIndex+1, last);
		}
	}
	
	public static int partition(int[] items, int first, int last) {
		swap(items, first, (first + last)/2);
		int pivot = items[first];
		int temp = first;
		first++;
		while(first <= last) {
			while(first < last && items[first] < pivot)
				first++;
			while(items[last] > pivot)
				last--;
			if(first < last)
				swap(items, first++, last--);
			else
				break;
		}
		swap(items, temp, last);
		return last;
	}
	
	public static void bubbleSort(int[] list) {
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = list.length - 1; j > i; j--) {
				if(list[j] < list[j-1]) {
					swap(list, j, j-1);
				}
			}
		}
	}
	
	public static void selectionSort(int[] list) {
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
				swap(list, i, index);
			}
		}
	}
	

	public static void insertionSort(int[] list) {
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = i + 1; j > 0 ; j--) {
				if(list[j] > list[j-1])
					break;
				else {
					swap(list, j, j-1);
				}
			}
		}
	}
	
	public static void swap(int[] item, int a, int b) {
		int tmp = item[a];
		item[a] = item[b];
		item[b] = tmp;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int[] list;
		
		while(true) {
			System.out.print("Enter a number to sort: ");
			int x = input.nextInt();
			list = new int[x];
			generateItems(list, x);
			if (x == 0) {
				break;
			}
			else if (x <= 100000) {
				int[] items = list.clone();
				long startTime, endTime, elapsed;
				startTime = System.currentTimeMillis();
				quickSort(items);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				System.out.println("Quick Sort Time =  " + elapsed);
				
				items = list.clone();
				startTime = System.currentTimeMillis();
				bubbleSort(items);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				System.out.println("Bubble Sort Time =  " + elapsed);
				
				items = list.clone();
				startTime = System.currentTimeMillis();
				selectionSort(items);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				System.out.println("Selection Sort Time =  " + elapsed);
				
				items = list.clone();
				startTime = System.currentTimeMillis();
				insertionSort(items);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				System.out.println("Insertion Sort Time =  " + elapsed);
				System.out.println();

			}
			else if(x > 100000) {
				int[] items = list.clone();
				long startTime, endTime, elapsed;
				startTime = System.currentTimeMillis();
				quickSort(items);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				System.out.println("Quick Sort Time =  " + elapsed);
			}
		}
		
		System.out.println("Sorting done!");
		input.close();

	}
}
