package secondTest;

import java.util.Scanner;

public class Regemail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个邮箱地址");
        String email = sc.next();
        if(isEmail(email)) System.out.println("输入成功");
        else System.out.println("邮箱格式不合法");

    }

    public static boolean isEmail(String email) {
          return email.matches("[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-zA-Z]+");

    }
}
