package com.superay.patterns.flyweight;

public class FinancialReportManager implements IReportManager {
    protected String tenantId = null;

    public FinancialReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "this is financial report";
    }
}
