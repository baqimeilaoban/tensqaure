package com.tensquare.test;

public class Solution4{
    public static void main(String[] args) {
        Breakfast f1 = new ChangFen();
        Breakfast f2 = new Huntun();
        Breakfast f3 = new HeFen();
        Waiter w = new Waiter();
        w.setChangFen(f1); //设置肠粉菜单
        w.setHunTun(f2); //设置馄饨菜单
        w.setHeFen(f3); //设置河粉菜单
        w.chooseChangFen(); //选择肠粉
        w.chooseHunTun(); //选择馄饨
        w.chooseHeFen(); //选择河粉
    }
}
//服务员
class Waiter{
    private Breakfast changFen,hunTun,heFen;
    public void setChangFen(Breakfast f){
        changFen = f;
    }

    public void setHunTun(Breakfast f){
        hunTun = f;
    }

    public void setHeFen(Breakfast f){
        heFen = f;
    }

    public void chooseChangFen(){
        changFen.cooking();
    }

    public void chooseHunTun(){
        hunTun.cooking();
    }

    public void chooseHeFen(){
        heFen.cooking();
    }
}

//抽象命令：早餐
interface Breakfast{
    public abstract void cooking();
}

//具体命令：肠粉
class ChangFen implements Breakfast{
    private ChangFenChef receiver;

    ChangFen(){
        receiver = new ChangFenChef();
    }

    public void cooking(){
        receiver.cooking();
    }
}

//具体命令：馄饨
class Huntun implements Breakfast{
    private HuntunChef receiver;

    Huntun(){
        receiver = new HuntunChef();
    }

    public void cooking(){
        receiver.cooking();
    }
}

//具体命令：河粉
class HeFen implements Breakfast{
    private HeFenChef receiver;

    HeFen(){
        receiver = new HeFenChef();
    }

    public void cooking(){
        receiver.cooking();
    }
}

//接收者：肠粉厨师
class ChangFenChef{
    ChangFenChef(){
        super();
    }

    public void cooking(){
        System.out.println("煮肠粉");
    }
}

//接收者：馄饨厨师
class HuntunChef{
    HuntunChef(){
        super();
    }

    public void cooking(){
        System.out.println("煮馄饨");
    }
}

//接收者：肠粉厨师
class HeFenChef{
    HeFenChef(){
        super();
    }

    public void cooking(){
        System.out.println("煮河粉");
    }
}