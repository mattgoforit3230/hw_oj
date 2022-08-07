package algorithm.huawei.interview;

/**
 TLV解析 Ⅱ
 描述:两端通过TLV格式的报文来通信，现在收到对端的一个TLV格式的消息包，要求生成匹配后的(tag, length, valueOffset)列表。

 具体要求如下:

 (1)消息包中多组tag、length、value紧密排列，其中tag,length各占1字节(uint8_t) , value所占字节数等于length的值

 (2)结果数组中tag值已知，需要填充每个tag对应数据的length和valueOffset值(valueOffset为value在原消息包中的起始偏移量（从0开始，以字节为单位))，

 即将消息包中的tag与结果数组中的tag进行匹配（可能存在匹配失败的情况，若结果数组中的tag在消息包中找不到，则length和valueOffset都为0)

 (3)消息包和结果数组中的tag值都按升序排列，且不重复

 (4)此消息包未被篡改，但尾部可能不完整，不完整的一组TLV请丢弃掉

 解答要求

 时间限制:C/C++ 1000ms | 其他语言:2000ms | 内存限制:C/C++ 32MB | 其他语言:64MB

 输入

 第一行: 一个字符串，代表收到的消息包。字符串长度在10000以内。
 说明1: 字符串使用十六进制文本格式（字母为大写）来展示消息包的数据，如0F04ABABABAB代表一组TLV:前两个字符(0F）代表tag值为15，
 接下来两个字符（04）代表length值为4字节，接下来8个字符即为4字节的value。
 说明2: 输入字符串中，每一组TLV紧密排列，中间无空格等分隔符
 第二行: 需要匹配的tag数量n (0 < n <1000) 。
 后面n行: 需要匹配的n个tag值（十进制表示)，递增排列。
 输出

 和需要匹配的n个tag对应的n行匹配结果，每一行由长度和偏移量组成。
 样例 1

 输入

 0F04ABABABAB

 1

 15

 输出

 4 2

 解释

 tag15(十六进制0F)对应数据的长度为4，其value从第三个字节开始，因此偏移量为2

 样例2

 输入

 0F04ABABABAB1001FF

 2

 15

 17

 输出

 4 2

 0 0

 解释

 第二个tag匹配失败


 */
public class Interview135H {
}
