package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 整数对最小和】
 *  给定两个整数数组array1、array2，数组元素按升序排列。
 *  假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素， 并对取出的所有元素求和，计算和的最小值。
 * 两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
 * 输入描述
 *  输入两行数组array1、array2，每行首个数字为数组大小size(0 < size <= 100); 0 < array1[i] <= 1000
 * 0 < array2[i] <= 1000
 * 接下来一行为正整数k
 * 0 < k <= array1.size() * array2.size()
 * 输出描述
 * 满足要求的最小和
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例 输入
 *  给定两个整数数组array1、array2，数组元素按升序排列。
 *  假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值。
 3 1 1 2
 3 1 2 3
 2
 => 4

 */
public class Interview90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String array1 = scanner.nextLine().trim();
        String array2 = scanner.nextLine().trim();
        String[] arr1 = array1.split(" ");
        String[] arr2 = array2.split(" ");
        int key = scanner.nextInt();
        int sum = 0;
        List<Integer> list = new ArrayList();
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                list.add(Integer.parseInt(arr1[i]) + Integer.parseInt(arr2[j]));
            }
        }
        Collections.sort(list);
        for (int i = 0; i < key; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
