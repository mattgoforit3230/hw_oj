package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 分班问题
 *
 1/N 2/Y 3/N 4/Y
 1 2
 3 4
 1/N 2/Y 3/N 4/Y 5/Y
 1 2
 3 4 5
 */
public class Interview66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        ArrayList<String> fst = new ArrayList<>();
        ArrayList<String> scd = new ArrayList<>();
        int pre = 1;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] split1 = s.split("/");
            int  a = Integer.parseInt(split1[0]);
            if(a <= 0 || a > 999){
                System.out.println("ERROR");
                return;
            }
            if(i == 0) {
                fst.add(split1[0]);
            } else {
                if(split1[1].equals("Y")){
                    if(pre == 1){
                        fst.add(split1[0]);
                    }else{
                        scd.add(split1[0]);
                    }
                }else{
                    if(pre == 1){
                        scd.add(split1[0]);
                        pre = 2;
                    }else{
                        fst.add(split1[0]);
                        pre = 1;
                    }
                }
            }
        }
        fst.sort((a,b)->Integer.parseInt(a) - Integer.parseInt(b));
        scd.sort((a,b)->Integer.parseInt(a) - Integer.parseInt(b));
        if(fst.size() == 0){
            System.out.println(String.join(" ",scd));
            System.out.println();
        }else if(scd.size() == 0){
            System.out.println(String.join(" ",fst));
            System.out.println();
        }else {
            System.out.println(String.join(" ",fst));
            System.out.println(String.join(" ",scd));
        }
    }
}
