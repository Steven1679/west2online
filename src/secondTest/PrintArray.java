package secondTest;

import java.util.Scanner;

public class PrintArray {
    private static final Object lock = new Object();
    private static boolean flag=true;//判断当前数组是否已经打印结束
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //初始化第一个数组
        System.out.println("输入第一个数组长度");
        int l1 = sc.nextInt();
        int[] arr1 = new int[l1];
        System.out.println("输入数组");
        for (int i=0;i<l1;i++) {
            arr1[i] = sc.nextInt();
        }

        //初始化第二个数组
        System.out.println("输入第二个数组长度");
        int l2 = sc.nextInt();
        int[] arr2 = new int[l2];
        System.out.println("输入数组");
        for (int i=0;i<l2;i++) {
            arr2[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        printArr(arr1,arr2);

    }
    public static void printArr(int[] arr1,int[] arr2){
        //线程一
        new Thread(() ->{
            synchronized (lock) {
                for (int i : arr1) {
                   //数组尚未打印完时交替打印
                    if(flag) {
                       System.out.print(i + " ");
                       lock.notify();
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                    //另一个线程数组打印完后继续打印当前线程的数组
                   else{
                       System.out.print(i + " ");
                   }
                }
                //数组打印完后flag置false
                flag=false;
                lock.notify();
            }

        }).start();
        //线程二
        new Thread(() ->{
            synchronized (lock) {
                for (int i : arr2) {
                    if(flag) {
                        System.out.print(i + " ");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.print(i + " ");
                    }
                }
                flag=false;
                lock.notify();
            }

        }).start();

    }


}
