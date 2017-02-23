package com.simple.msg;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/9.
 */
public class Test {

//    static int[] arry = {5, 3, 2, 6, 1, 4};
    static int[] arry = {1, 2, 3, 4, 5, 6};

    /**
     * 从左边开始 , 比较 0 和 1位置的元素 , 如果0号元素比1号元素大 , 则交换位置 , 否则不做操作
     * 然后再进行1 和 2位置的元素 , 以此类推 . 这样一次排序后 , 最大的元素就在最后了 .
     * 再进行第二趟排序 , 不同的是 , 刚才被挑出的元素不再进行比较 .
     * 举例 :
     * 下面站了一排橄榄球队员 , 一号跟二号撞 , 一号明显KO二号 , 一号撞过去了 , 此时一号变为二号 .
     * 再拿二号跟三号撞 , 撞不动 ...
     * 然后换三号上上场了 , 三号把四号撞成肉馅儿了都 . 所以交换位置 .
     * .....
     * 第一场下来 , 个儿最大的那个队员撞到了最后 .
     */
    public static void 冒泡排序() {
        for (int out = arry.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {

                if (arry[in] > arry[in + 1]) {
                    int temp = arry[in];
                    arry[in] = arry[in + 1];
                    arry[in + 1] = temp;
                }

            }
        }
        Log.i("冒泡", Arrays.toString(arry));
    }


    /**
     * 举例:
     * 现在 , 橄榄球联赛推出了扫描系统!~ 省去了毫无意义的比赛 .
     * 它只要将全体队员扫描一遍 , 便可以找出最弱的那个 , 但一次只能找出一个 .
     * 下图是他的工作方式 .
     * 从第一个开始遍历 , 只要遇见比他小的就记录他 , 之前那个就被覆盖了 , 等到遍历完一遍之后就得到了最小的那个
     * 把他放到最左边 , 然后再从第二个开始遍历
     */
    public static void 选择排序() {
        int min;
        for (int out = 0; out < arry.length - 1; out++) {
            min = out;
            for (int in = out + 1; in < arry.length; in++) {
                if (arry[in] < arry[min]) {
                    min = in;
                }
            }
            int temp = arry[out];
            arry[out] = arry[min];
            arry[min] = temp;
        }
        Log.i("选择", Arrays.toString(arry));
    }


    /**
     * 在大多数情况下,  插入排序是基本排序算法中最快的一种 .
     * 举例:
     *      这个算法我们要举一个玩牌的例子 .
     *      假设你在玩扑克牌的时候会将一手牌按照大小从左到右排列 .
     *      现在你取到了一张黑桃尖和一张梅花3 , 这时候又来了一张方片2 , 你会下意识的将它插进已有的两张牌中间 .
     *      这就是插入排序了 , 而计算机并没有这样的意识 , 他是怎么做的 ?
     *      他会先那这张方片2跟梅花3比 , 如果比方片2大 , 那就接着比梅花3的前一张牌
     *      如果依然比方片2大,那就接着比较前一张牌, 如果前面没牌了,就将方片2插入到第一个位置 .
     *      而在这个例子中, 比较完梅花3之后接着就是黑桃A,比方片2小了,那就将这个方片2插入到这张牌的后面.
     *      这里需要注意的是 , 当前手中的两张牌已经是有序的了.
     *      如果现在手中牌的顺序是3 1 2 5呢?
     *      初始为:
     *      3 1 2 5
     *      首先拿第二张牌, 也就是1跟前面的牌比较 , 比完之后得到了:
     *      1 3 2 5
     *      这时候1和3已经是有序的了是么? 然后在拿到第三张牌 , 然后跟前面的比, 得到了:
     *      1 2 3 5
     *      前三个已经有序了 , 然后是第四张牌 , 得到了 :
     *      1 2 3 5
     *      排序完成.
     */
    public static void 插入排序(){
        int temp , in;
        for (int out = 1; out < arry.length; out++) {
            temp = arry[out];
            in = out;
            while (in > 0 && temp <= arry[in - 1]){
                arry[in] = arry[in - 1];
                in--;
            }
            arry[in] = temp;
        }
        Log.i("插入", Arrays.toString(arry));
    }

    /**
     * 快速排序是最流行的一种排序
     * 以下代码的主题思想就是:
     * 选中第一个数作为基准 , 然后最左边为低位 , 最右边为高位
     * 分别循环低位和高位 , 直到低位遇到比基准数大的数 , 高位遇到比基准数小的数 , 以确定高低位的角标 .
     * 然后让高低位的元素交互位置 , 然后继续 , 直到低位 >= 高位时停止 . 然后将基准数与低位所在角标的元素交换
     * (因为我们选的是第一个数)
     * 这时 , 基准数的左侧都是比他小的数 , 右侧都是比他大的数. 然后递归的调用自己 , 将左边部分和右边部分传进去 .
     * 直到排序完成.
     */
    public static void 快速排序(int[] arry , int start , int end){
        if (start >= end)return;
        int povit = start , temp;
        int l = start , h = end;
        while (l < h){
            while (arry[povit] < arry[h] && l < h){
                h--;
            }
            while (arry[povit] > arry[l] && l < h){
                l++;
            }
            if (l != h) {
                temp = arry[h];
                arry[h] = arry[l];
                arry[l] = temp;
            }else{
                temp = arry[h];
                arry[povit] = arry[h];
                arry[h] = temp;
                povit = h;
            }
        }
        快速排序(arry , povit + 1 , end);
        快速排序(arry , start , povit - 1);
    }

    public static void 二分排序(){
    }



}

