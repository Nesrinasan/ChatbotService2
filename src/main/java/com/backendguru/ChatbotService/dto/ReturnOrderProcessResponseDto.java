package com.backendguru.ChatbotService.dto;


import jdk.jfr.Description;

public class ReturnOrderProcessResponseDto {

    private String returnCode;
    private String shippingInformation;

    @Description("REJECTED ve SUCCESS değerlerini alabilir")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(String shippingInformation) {
        this.shippingInformation = shippingInformation;
    }
}
