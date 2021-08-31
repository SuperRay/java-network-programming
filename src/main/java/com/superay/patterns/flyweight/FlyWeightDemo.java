package com.superay.patterns.flyweight;


public class FlyWeightDemo {
    /**
     * @Author Superay
     * @Description
     * @Date 23:20 2021/8/31
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager rm = rmf.getFinancialReportManager("A");

        System.out.println(rm.createReport());
    }
}
