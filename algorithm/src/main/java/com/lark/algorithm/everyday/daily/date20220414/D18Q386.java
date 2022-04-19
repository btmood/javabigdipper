package com.lark.algorithm.everyday.daily.date20220414;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author btmood
 * @date 2022-04-18 9:06
 * @Description Q386:字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 5 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D18Q386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            res.add(num);
            //一直深入到最后一个存在的节点
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num >= n || num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }

    public List<Integer> lexicalOrder2(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i+"");
        }
        Collections.sort(res);
        return res.stream().map(e -> Integer.valueOf(e)).collect(Collectors.toList());
    }

    private List<Integer> res;
    public List<Integer> lexicalOrder3(int n) {
        res=new ArrayList<Integer>(n);
        for(int i=1;i<=9;i++){
            dfs(i,n);
        }
        return res;
    }
    //获取以start为根节点且小于n的下一级左子树
    public void dfs(int start,int n){
        if(start>n)return;
        res.add(start);
        for(int i=0;i<=9;i++){
            if(start*10+i>n)break;
            dfs(start*10+i,n);
        }
    }

    public static void main(String[] args) {
        D18Q386 d = new D18Q386();
        List<Integer> integers = d.lexicalOrder2(34);
        System.out.println(integers);
    }
}
