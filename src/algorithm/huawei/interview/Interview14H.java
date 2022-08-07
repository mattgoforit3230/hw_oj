package algorithm.huawei.interview;

import java.util.*;

/**
 打印任务排序
 某个打印机根据打印队列执行打印任务。
 打印任务分为九个优先级，分别用数字1-9表示，数字越大优先级越高。
 打印机每次从队列头部取出第一个任务A， 然后检查队列余下任务中有没有比A优先级更高的任务，
 如果有比A优先级高的任务，则将任务A 放到队列尾部，否则就执行任务A的打印。
 请编写一个程序，根据输入的打印队列，输出实际的打印顺序。
 */
public class Interview14H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->ints[b] - ints[a]);
        for (int i = 0; i < ints.length; i++)queue.add(i);
        int order = 0;
        int[] res = new int[ints.length];
        while(!queue.isEmpty())res[queue.poll()] = order++;
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                System.out.print(res[i] + ",");
            } else {
                System.out.print(res[i]);
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] line = sc.nextLine().split(",");
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<Integer> original = new ArrayList<>();
//        for (String s : line) {
//            list.add(Integer.parseInt(s));
//            original.add(Integer.parseInt(s));
//        }
//        int[] res = new int[line.length];
//        int order = 0;
//        while (list.size() > 0) {
//            int curr = list.remove(0);
//            boolean flag = true;
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i) > curr) {
//                    list.add(curr);
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                int index = original.indexOf(curr);
//                original.set(index, -1);
//                res[index] = order;
//                order++;
//            }
//        }
//        for (int i = 0; i < res.length; i++) {
//            if (i != res.length - 1) {
//                System.out.print(res[i] + ",");
//            } else {
//                System.out.print(res[i]);
//            }
//        }
//    }
}
