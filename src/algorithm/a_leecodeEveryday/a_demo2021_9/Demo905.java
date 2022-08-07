package algorithm.a_leecodeEveryday.a_demo2021_9;

public class Demo905 {
    public int rand7(){
        return 0;
    }
    //470. 用 Rand7() 实现 Rand10()
    public int rand10() {
        while(true) {
            int a = rand7();
            int b = rand7();
            int num = (a - 1) * 7 + b;
            if (num <= 40) {
                return num % 10 + 1;
            }
            num = num - 40;
            num = (num - 1) * 7 + rand7();
            if (num <= 60) return num % 10 + 1;

            num = num - 60;
            num = (num - 1) * 7 + rand7();
            if (num <= 20) return num % 10 + 1;
        }
    }
}
