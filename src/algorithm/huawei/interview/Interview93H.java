package algorithm.huawei.interview;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 93 内存资源分配
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，
 * 用户会进行一系列内存申请，需要按需分配内存池中的资源返回申请结果成功失败列表。
 * 分配规则如下:
 * 1. 分配的内存要大于等于内存的申请量，存在满足需求的内存就必须分配，优先分配粒度小的， 但内存不能拆分使用;
 * 2. 需要按申请顺序分配，先申请的先分配，有可用内存分配则申请结果为true; 3. 没有可用则返回false。
 * 注意:不考虑内存释放
 64:2,128:1,32:4,1:128
 50,36,64,128,127
 */
public class Interview93H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split1 = scanner.nextLine().trim().split(",");
        String[] split2 = scanner.nextLine().trim().split(",");
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->a-b);
        for (int i = 0; i < split1.length; i++) {
            String[] temp = split1[i].split(":");
            int key = Integer.parseInt(temp[0]);
            int val = Integer.parseInt(temp[1]);
            map.put(key,val);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split2.length; i++) {
            int target = Integer.parseInt(split2[i]);
            if(map.ceilingKey(target) == null)res.append("false");
            else{
                int key = map.ceilingKey(target);
                int val = map.get(key);
                if(val == 1)map.remove(key);
                else map.put(key,val-1);
                res.append("true");
            }
            res.append(",");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
