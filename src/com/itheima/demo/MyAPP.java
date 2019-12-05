package com.itheima.demo;

import java.util.ArrayList;
import java.util.Random;

public class MyAPP {
    public static void main(String[] args) {
        //1:创建自定义类型的界面类的子类对象,即可让界面显示出来
        MyJFreame m = new MyJFreame("发红包啦啦啦");
        //2:创建OpenMode接口的实现类对象;(目的是为了能打开红包)
        //使用匿名内部类的形式,直接创建接口的实现类对象
        //3:修改群主名称的方法
        m.setOwnerName("吴彦祖");
        //4:设置红包的发放规则
        m.setOpenWay(new OpenMode(){
            //发红包规则的方法,平均发
      /*      public ArrayList<Integer> divide(int totalMoney, int totalCount) {
                //totalMoney  总金额(已经自动转成了分)   totalCount  总个数
                ArrayList<Integer> li = new ArrayList<Integer>();
                //1:先平均发totalCount-1 个
                for (int i = 0; i <totalCount-1 ; i++) {
                    li.add(totalMoney/totalCount);
                }
                //2:发最后一个红包
                if(totalMoney%totalCount==0){
                    li.add(totalMoney/totalCount);
                }else{
                    li.add(totalMoney/totalCount+totalMoney%totalCount);
                }
                return li;
            }*/
            //随机红包的规则
            public ArrayList<Integer> divide(int totalMoney, int totalCount) {
                //totalMoney  总金额(已经自动转成了分)   totalCount  总个数
                ArrayList<Integer> li = new ArrayList<Integer>();
                //  每次发的时候,最多是当前红包总数量的平均金额的2倍 ,最少是1分
                //使用随机数即可
                //1:先随机发totalCount-1个红包
                for (int i = 0; i <totalCount-1 ; i++) {
                    int max=totalMoney/(totalCount-i)*2;//红包和钱的数量都在变化!!!!!!
                    int money=new Random().nextInt(max)+1;
                    li.add(money);
                    totalMoney-=money;
                }
                //塞最后一个红包
                li.add(totalMoney);
                return li;
            }
        });
    }
}
