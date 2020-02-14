package day_7;

import java.util.Scanner;

public class Iteratormain {

    public static int findMax(LinkedList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int max = 0;
        while (it.hasNext()) {
            int temp = it.next();
            if (max < temp)
                max = temp;
        }
        return max;
    }

    public static LinkedList<Integer> selectionSort(LinkedList<Integer> list) {
        LinkedList<Integer> sortedList = new LinkedList<Integer>();
        Iterator<Integer> listit = list.iterator();
        while (listit.hasNext()) {
            Iterator<Integer> it = list.iterator();
            int max = 0;
            int index = 0;
            int indexcount = 1;
            while (it.hasNext()) {
                int temp = it.next();
                if (max <= temp) {
                    max = temp;
                    index = indexcount;
                }
                indexcount++;
            }
            sortedList.insert(max);
            list.delete(index);
            listit = list.iterator();
        }

        return sortedList;
    }

    public static LinkedList<Word> countDup(LinkedList<Integer> list) {
        LinkedList<Word> wordList = new LinkedList<Word>();
        Iterator<Integer> it = list.iterator();
        int index = it.next();
        wordList.insert(new Word(index));
        while (it.hasNext()) {


        }

        return wordList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        String command;
        int item;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command: i(insert), r(emove), s(earch), size, p(rint), ");
        System.out.println("m(ax), c(ount duplicates), d(elete duplicates), sort, or q(uit)");
        System.out.print("> ");
        command = input.next();

        while (true) {
            if (command.equals("i")) {
                item = input.nextInt();
                list.insert(item);
            } else if (command.equals("r")) {
                item = input.nextInt();
                if (list.remove(item))
                    System.out.println(item + " removed.");
                else
                    System.out.println("No such " + item + "!");
            } else if (command.equals("s")) {
                item = input.nextInt();
                if (list.search(item))
                    System.out.println(item + " is in the list.");
                else
                    System.out.println("No such " + item + "!");
            } else if (command.equals("size")) {
                System.out.println("size: " + list.size());
            } else if (command.equals("p"))
                list.print();
            /**
             else if (command.equals("d")) {
             LinkedList<Integer> list1 = removeDup(list);
             list1.print();
             }
             */


                // 데이터와 데이터 개수를 필드로 하는 Word 클래스 만들어 사용
            else if (command.equals("c")) {
                LinkedList<Word> list2 = countDup(list);
                System.out.println(list2);
            } else if (command.equals("m")) {
                int max = findMax(list);
                System.out.println("Max: " + max);
            } else if (command.equals("sort")) {
                list = selectionSort(list);
                list.print();
            } else if (command.equals("q"))
                break;
            System.out.print("> ");
            command = input.next();

        }
        System.out.println("Commands Terminated.");
        input.close();

    }


}
