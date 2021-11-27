package secondTest;

import java.util.ArrayList;

public class TestCatCafe {
    public static void main(String[] args) {
        //初始化猫咪列表
        ArrayList<Cat> cat=new ArrayList<>();
        cat.add(new OrangeCat("Alia",8,"F",true));
        //空顾客列表
        ArrayList<Customer> cus=new ArrayList<>();
        //创建猫咖实例
        MyCatCafe catCafe=new MyCatCafe(560,cat,cus);

        //测试无猫可rua(需把初始化猫咪列表设为空后(即删除第九行）再执行以下语句)
        /*
        Customer c1=new Customer("Awo",5);
        catCafe.treatCus(c1);
         */

        //测试买入猫猫
        //成功买入时
        System.out.println("测试买入猫猫");
        catCafe.buyCat(new OrangeCat("Alan",6,"M",false));
        catCafe.buyCat(new BlackCat("Amy",7,"F"));

        for(int i=0;i<catCafe.getCat().size();i++){
            System.out.println(catCafe.getCat().get(i).toString());
        }
        //余额不足时
        //catCafe.buyCat(new BlackCat("Amy",7,"F"));

        //测试招待顾客
        System.out.println("测试招待顾客");
        Customer c2=new Customer("Steven",10);
        System.out.println("招待顾客前店内余额:"+catCafe.getBalance()+"\n顾客"+c2.getName()+" rua了"+ c2.getRuaNum()+"次");
        catCafe.treatCus(c2);
        System.out.println("招待顾客后店内余额:"+catCafe.getBalance());

        //测试歇业
        catCafe.stop();

    }
}
