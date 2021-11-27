package secondTest;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int ruaNum;
    private LocalDate time = LocalDate.now();

    public Customer(String name, int ruaNum) {
        this.name = name;
        this.ruaNum = ruaNum;
    }

    public LocalDate getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getRuaNum() {
        return ruaNum;
    }

    public void setRuaNum(int ruaNum) {
        this.ruaNum = ruaNum;
    }

    @Override
    public String toString() {
        return "顾客:"+this.name+
                "\nrua猫次数："+this.ruaNum+
                "\n进店时间: "+this.time;
    }
}
