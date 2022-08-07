package algorithm.huawei.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 *  九宫格按键输入法
 *   九宫格按键输入，判断输出，有[英文]和[数字]两个模式，默认是数字模式，数字模式直接输出数字，
 *   英文模式连续按同一个按键会依次出现这个按键上的字母，如果输入"/"或者其他字符，则循环中断。
 *   要求输入一串按键，输出屏幕显示
 *
 *  输入描述:
 *      输入范围为数字 0~9 和字符'#'、’/’，输出屏幕显示，例如，
 *      在数字模式下，输入 1234，显示 1234
 *      在英文模式下，输入 1234，显示,adg
 *
 *  输出描述:
 *      1. #用于切换模式，默认是数字模式，执行#后切换为英文模式;
 *      2. /表示延迟，例如在英文模式下，输入 22/222，显示为 bc;
 *      3. 英文模式下，多次按同一键，例如输入 22222，显示为 b;
 *
 123#222235/56
 => 123adjjm
 #/22/2022#33#872233444/44
 => ba b33tpbeih
 */
public class Interview72H {

    static HashMap<Character,String[]> map = new HashMap<>();
    static { map.put('1',new String[] {",","."});
        map.put('2',new String[] {"a","b","c"});
        map.put('3',new String[] {"d","e","f"});
        map.put('4',new String[] {"g","h","i"});
        map.put('5',new String[] {"j","k","l"});
        map.put('6',new String[] {"m","n","o"});
        map.put('7',new String[] {"p","q","r","s"});
        map.put('8',new String[] {"t","u","v"});
        map.put('9',new String[] {"w","x","y","z"});
        map.put('0',new String[] {" "}); }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);String str = scanner.nextLine().trim();
        boolean isABC = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(cur>='0' && cur <= '9'){
                if(isABC){
                    int j = i;
                    for (; j < str.length()-1; j++) {
                        if(str.charAt(j+1) != cur)break;
                    }
                    int size = map.get(cur).length;
                    sb.append(map.get(cur)[(j-i)%size]);
                    i = j;
                }else{
                    sb.append(cur);
                }
            }else if(cur == '#'){
                isABC = !isABC;
            }
        }
        System.out.println(sb);
    }
}
