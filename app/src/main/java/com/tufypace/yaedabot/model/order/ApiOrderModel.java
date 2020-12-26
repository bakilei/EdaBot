package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiOrderModel {
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    @JsonProperty("payload")
    public OrderModel orderModel;


    public ApiOrderModel() {
        super();
    }

    public OrderModel getOrderModel() {
        return this.orderModel;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setOrderModel(OrderModel orderModel2) {
        this.orderModel = orderModel2;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
