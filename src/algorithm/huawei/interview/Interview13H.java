package algorithm.huawei.interview;

import java.util.Scanner;

/**
 统计文本数量
 题目描述
 有一个文件，包含以一定规则写作的文本，请统计文件中包含的文本数量。
 规则如下:
 1. 文本以";"分隔，最后一条可以没有";"，但空文本不能算语句，比如"COMMAND A; ;"只能算一条语 句
 注意，无字符/空白字符/制表符都算作"空"文本;
 2. 文本可以跨行，比如下面，是一条文本，而不是三条;
 3. 文本支持字符串，字符串为成对的单引号(')或者成对的双引号(")，字符串可能出现用转义字符(\)处 理的单双引号("your input is\"")和转义字符本身，
 比如 COMMAND A "Say \"hello\"";
 4. 支持注释，可以出现在字符串之外的任意位置注释以"--"开头，到换行结束，比如
 注意字符串内的"--"，不是注释。

 COMMAND TABLE IF EXISTS "UNITED STATE";
 COMMAND A GREAT (
 ID ADSAB,
 download_length INTE-GER, -- test
 file_name TEXT,
 guid TEXT,
 mime_type TEXT,
 notifica-tionid INTEGER,
 original_file_name TEXT,
 pause_reason_type INTERGER,
 resumable_flag INTERGER,
 start_time INTERGER,
 state INTERGER,
 folder TEXT,
 path TEXT,
 total_length INTE-GER, url TEXT
 );
 */
public class Interview13H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean flag = false;
        boolean start = false,end = false;
        int res = 0;
        for(int i = 0; i < s.length();i++){
            char cur = s.charAt(i);
            if(cur != ' ' && cur !=';' && cur != '\t')flag = true;
            if(cur == '-'){
                if(!start && !end && i != s.length()-1 && s.charAt(i+1)!='-')
                    continue;
            }else if(!start && !end && cur == ';' && flag){
                res++;
                flag = false;
            }else if(cur == '\"' && i > 0 && s.charAt(i-1) != '\\'){
                start ^= true;
            }else if(cur == '\"' && i > 0 && s.charAt(i-1) != '\\' && !start){
                end ^= true;
            }
        }
        System.out.println(res);
    }
}
