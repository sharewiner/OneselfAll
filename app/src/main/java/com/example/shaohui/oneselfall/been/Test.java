package com.example.shaohui.oneselfall.been;

public class Test {

    public static void main(String[] args) {
//        Company cp = new Company();
//        //ceo只能通过getCeo函数获取
//        Staff ceo1 = CEO.getCeo();
//        Staff ceo2 = CEO.getCeo();
//        cp.addStaff(ceo1);
//        cp.addStaff(ceo2);
//        //通过new创建VP
//        Staff vp1 = new VP();
//        Staff vp2 = new VP();
//        //通过new创建staff对象
//        Staff staff1 = new Staff();
//        Staff staff2 = new Staff();
//        Staff staff3 = new Staff();
//
//
//        cp.addStaff(vp1);
//        cp.addStaff(vp2);
//        cp.addStaff(staff1);
//        cp.addStaff(staff2);
//        cp.addStaff(staff3);
//
//
//        cp.showAllStaffs();

        Builder builder = new MacbookBuilder();
        Director director = new Director(builder);
        director.connstruct("因特尔主板","索尼显示器");
        System.out.println("Computer Info :" + builder.create().toString());


    }
}
