package com.example.DebuggApp;

public class Test {
    public static void main(String[] args) {
        System.out.println("Debugging simple java application");
        int myarr[]={2,5,7,81};
        int ans=getSum(myarr);
        System.out.println(ans);
    }

    public static int getSum(int arr[]){
        int sum=0;
        for(int i : arr){
            sum+=i;
        }
        sum+=3;
        return sum;
    }
}
