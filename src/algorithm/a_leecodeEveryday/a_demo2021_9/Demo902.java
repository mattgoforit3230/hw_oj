package algorithm.a_leecodeEveryday.a_demo2021_9;

public class Demo902 {
    //9.1的题目
    //165. 比较版本号
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int a  = split1.length,b = split2.length;
        int i = 0,j = 0;
        while(i < a || j < b){
            //可以初始化
            int sp1 = 0,sp2 = 0;
            if(i < a)sp1 = Integer.parseInt(split1[i++]);
            if(j < b)sp2 = Integer.parseInt(split2[j++]);
            if(sp1 != sp2)return sp1>sp2?1:-1;
        }
        return 0;
    }
}
