package secondTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double balance;
    private final ArrayList<Cat> cat;
    private final ArrayList<Customer> customer;

    public MyCatCafe(double balance,ArrayList<Cat> cat,ArrayList<Customer> customer) {
        this.balance = balance;
        this.cat=cat;
        this.customer=customer;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Cat> getCat() {
        return cat;
    }
    public ArrayList<Customer> getCustomer() {
        return customer;
    }


    //买入猫猫
    @Override
    public void buyCat(Cat kind) {
        if (kind.getPrice() > balance) {
            throw new InsufficientBalanceException("余额不足");
        } else {
            cat.add(kind);
            balance -= kind.price;
        }

    }

    //招待顾客
    @Override
    public void treatCus(Customer cus) {
        customer.add(cus);//新顾客加入列表
        if (cat.size() <= 0) {
            throw new CatNotFoundException("真的很抱歉，我们没有猫猫可rua了");
        } else {
            //随机rua猫
            for (int i = 0; i < cus.getRuaNum(); i++) {
                Random random = new Random();
                int index = random.nextInt(cat.size());
                System.out.println(cat.get(index).toString());
            }
            //收入up
            balance += cus.getRuaNum() * 15;
        }
    }


    @Override
    public void stop() {
        int count = 0;//rua猫总次数
        for (Customer value : customer) {
            //判断是否哪些顾客是当天的
            if (value.getTime().isEqual(LocalDate.now())) {
                System.out.println(value.toString());
                count += value.getRuaNum();//顾客总rua猫次数
            }
        }
        System.out.println("今天利润：" + count * 15 + "元");
    }
}
