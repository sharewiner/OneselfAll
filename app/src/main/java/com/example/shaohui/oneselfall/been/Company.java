package com.example.shaohui.oneselfall.been;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司类
 */
public class Company {

    private List<Staff> allStaffs = new ArrayList<>();

    public void addStaff(Staff per) {
        allStaffs.add(per);
    }

    public void showAllStaffs() {
        for (Staff staff : allStaffs) {
            System.out.println("Obj :" + staff.toString());
        }
    }
}
