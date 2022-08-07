package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 41 5键键盘
 * 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键。
 * a键在屏幕上输出一个字母a;ctrl-c将当前选择的字母复制到剪贴板;
 * ctrl-x将当前选择的字母复制到剪贴板，并清空选择的字母;
 * ctrl-v将当前剪贴板里的字母输出到屏幕;
 * ctrl-a选择当前屏幕上的所有字母。
 *
 * 1. 剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 2. 当屏幕上没有字母时，ctrl-a无效
 * 3. 当没有选择字母时，ctrl-c和ctrl-x无效
 * 4. 当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
 1 1 5 1 5 2 4 4
 1 1 5 1 5 2 4 4
 */
public class Interview41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int screen = 0,plate = 0,choose = 0;
        for (int i = 0; i < split.length; i++) {
            char cur = split[i].charAt(0);
            if(cur == '1'){
                //当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
                //screen = choose > 0 ? 1 : screen + 1;
                //screen += 1;
                screen -= choose;
                choose = 0;
                screen += 1;
            }else if(cur == '2'){
                //ctrl-c将当前选择的字母复制到剪贴板;
                //当没有选择字母时，ctrl-c和ctrl-x无效
                if(choose == 0)continue;
                plate = choose;
            }else if(cur == '3'){
                //ctrl-x将当前选择的字母复制到剪贴板，并清空选择的字母;
                //当没有选择字母时，ctrl-c和ctrl-x无效
                if(choose == 0)continue;
                screen -= choose;
                plate = choose;
                choose = 0;
            }else if(cur == '4'){
                //ctrl-v将当前剪贴板里的字母输出到屏幕;
                //当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
                screen -= choose;
                choose = 0;
                screen += plate;
            }else if(cur == '5'){
                //ctrl-a选择当前屏幕上的所有字母。
                //当屏幕上没有字母时，ctrl-a无效
                if(screen == 0)continue;
                choose = screen;
            }
        }
        System.out.println(screen);

    }
}
