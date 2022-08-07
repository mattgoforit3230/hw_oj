package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Interview35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());

        String[] heights = scanner.nextLine().trim().split("\\s+");
        String[] weights = scanner.nextLine().trim().split("\\s+");
        ArrayList<Student> list = new ArrayList<>();

        for(int i = 0;i < heights.length;i++){
            list.add(new Student(i+1,
                    Integer.parseInt(heights[i]),Integer.parseInt(weights[i])));
        }
        list.sort((a,b)->{
            if(a.height != b.height){
                return a.height - b.height;
            }else if(a.weight != b.weight){
                return a.weight - b.weight;
            }else{
                return a.i - b.i;
            }
        });
        StringBuilder res = new StringBuilder();
        for(Student temp:list) {
            res.append(temp.i);
            res.append(" ");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
    static class Student{
        int i;
        int height;
        int weight;
        public Student(int i, int height, int weight) {
            this.i = i;
            this.height = height;
            this.weight = weight;
        }
    }
}
