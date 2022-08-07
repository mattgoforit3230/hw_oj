package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * VLAN资源池】
 * VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094 之间的整数)的概念。
 * 定义一个VLAN ID的资源池(下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN 表示，
 * 不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。 现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，
 * 需要你输出从VLAN资源池中移 除申请的VLAN后的资源池。
 */
public class Interview20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int target = Integer.parseInt(scanner.nextLine().trim());
        int[] vlan = new int[4094];
        String[] split = str.split(",");
        for(String s:split){
            if(s.contains("-")){
                String[] split1 = s.split("-");
                int start = Integer.parseInt(split1[0]);
                int end = Integer.parseInt(split1[1]);
                for(int i = start;i <= end;i++){
                    if(i != target)vlan[i] = 1;
                }
            }else{
                int temp = Integer.parseInt(s);
                if(target == temp)continue;
                vlan[temp] = 1;
            }
        }
        StringBuilder res = new StringBuilder();
        int start = -1,end = -1;
        for(int i = 0;i < 4094;i++){
            if(vlan[i] == 1){
                if(start >= 0){
                    end = i;
                }else{
                    start = i;
                }
            }else{
                if(start >= 0 && end >= 0){
                    res.append(start);
                    res.append("-");
                    res.append(end);
                    res.append(",");
                }else if(start >= 0){
                    res.append(start);
                    res.append(",");
                }
                start = -1;
                end = -1;
            }
        }
        if(start >= 0 && end >= 0){
            res.append(start);
            res.append("-");
            res.append(end);
            res.append(",");
        }else if(start >= 0){
            res.append(start);
            res.append(",");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
