package day_7;

import java.util.Scanner;

public class Iteratormain {

    /**
     * 리스트의 최대값을 찾아 반환한다.
     *
     * @param list 최대값을 찾을 리스트
     * @return 최대값
     */
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

    /**
     * 선택 정렬을 수행한다.
     *
     * @param list 선택 정렬을 수행할 리스트
     * @return 선택 정렬이 완료된 리스트
     */
    public static LinkedList<Integer> selectionSort(LinkedList<Integer> list) {

        // 최대값을 순서대로 저장할 리스트를 생성한다.
        LinkedList<Integer> sortedList = new LinkedList<Integer>();

        // 입력받은 리스트의 반복자를 생성한다.
        Iterator<Integer> listit = list.iterator();

        // 반복자를 이용해 탐색하고 최대값을 새로운 리스트에 저장한다.
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

    /**
     * 중복된 데이터의 수를 계산하고 반환한다.
     *
     * @param list
     * @return
     */
    public static LinkedList<Word> countDup(LinkedList<Integer> list) {

        // 입력받은 리스트의 반복자를 생성한다.
        Iterator<Integer> it = list.iterator();

        // 반환할 리스트와 반복자를 생성한다.
        LinkedList<Word> wordList = new LinkedList<Word>();
        Iterator<Word> wordIt = wordList.iterator();

        // 입력받은 리스트의 첫 번째 값을 반환할 리스트에 추가한다.
        int index = it.next();
        wordList.insert(new Word(index));

        while (it.hasNext()) {
            index = it.next();

            wordIt = wordList.iterator();
            boolean isContain = false;

            // 반환할 리스트를 탐색하여
            // 이미 값이 존재할 경우 카운트를 증가시킨다.
            while (wordIt.hasNext()) {
                Word wordTemp = wordIt.next();
                if (wordTemp.equals(index)) {
                    wordTemp.countUp();
                    isContain = true;
                }
                if (isContain) break;
            }

            // 값이 존재하지 않은 경우 새로 추가해준다.
            if (!isContain) {
                wordList.insert(new Word(index));
            }

        }

        return wordList;

    }

    /**
     * 중복된 값을 제거해주는 메소드
     *
     * @param list 중복된 값을 제거해줄 리스트
     * @return 중복된 값이 제거된 리스트
     */
    public static LinkedList<Integer> removeDup(LinkedList<Integer> list) {
        LinkedList<Word> wordList;
        LinkedList<Integer> newList = new LinkedList<Integer>();

        // countDup 메소드를 활용하여 중복된 값이 지워진
        // Word 객체 리스트를 만든다.
        wordList = countDup(list);
        Iterator<Word> word = wordList.iterator();

        // Word객체가 저장된 리스트에서
        // index값만을 새로운 리스트에 저장해준다.
        while (word.hasNext()) {
            newList.insert(word.next().index());
        }

        return newList;

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
            else if (command.equals("d")) {
                LinkedList<Integer> list1 = removeDup(list);
                list1.print();
            }


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
