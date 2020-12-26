package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderModel implements Persistable {
    public static final String NUMBER = "orderNumber";
    public static final String STATUS = "status";
    @JsonProperty("cartItems")
    public List<CartItem> cards = null;
    @JsonProperty("changeOn")
    public int changeOn;
    @JsonProperty("changeTotal")
    public int changeTotal;
    @JsonProperty("customer")
    public Customer client;
    @JsonProperty("clientTotal")
    public int clientTotal;
    @JsonProperty("courierType")
    public String courierType;
    @JsonProperty("createdAt")
    public String createdAt;
    @JsonProperty("currency")
    public Currency currency;
    @JsonProperty("deliveryDateTime")
    public String deliveryDateTime;
    @JsonProperty("deliveryFee")
    public int deliveryFee;
    @JsonProperty("discount")
    public int discount;
    @JsonProperty("isAdopted")
    public boolean isAdopted;
    @JsonProperty("isAsap")
    public boolean isAsap;
    @JsonProperty("isSelected")
    public boolean isSelected = false;

    @JsonProperty("maxArriveToCustomerAt")
    public String maxArriveToCustomerAt;
    @JsonProperty("maxArriveToPlaceAt")
    public String maxArriveToPlaceAt;
    @JsonProperty("modelId")
    public String modelId;
    @JsonProperty("additionalNumber")
    public String orderAdditionalNumber;
    @JsonProperty("orderNr")
    public String orderNumber;
    @JsonProperty("originId")
    public String originId;
    @JsonProperty("personsQuantity")
    public int persons;
    @JsonProperty("placeOrderStatus")
    public String placeOrderStatus;
    @JsonProperty("placeOrderStatusUpdatedAt")
    public String placeOrderStatusUpdatedAt;
    @JsonProperty("place")
    public Place restaurant;
    @JsonProperty("status")
    public String status;
    @JsonProperty("subtotal")
    public int subtotal;
    @JsonProperty("courierPlannedArrivedToPlaceAt")
    public String toRestDateTime;
    @JsonProperty("total")
    public int total;
    @JsonProperty("unassigned")
    public boolean unassigned;


    public OrderModel() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderModel that = (OrderModel) o;
        return changeOn == that.changeOn &&
                changeTotal == that.changeTotal &&
                clientTotal == that.clientTotal &&
                deliveryFee == that.deliveryFee &&
                discount == that.discount &&
                isAdopted == that.isAdopted &&
                isAsap == that.isAsap &&
                isSelected == that.isSelected &&
                persons == that.persons &&
                subtotal == that.subtotal &&
                total == that.total &&
                unassigned == that.unassigned &&
                Objects.equals(cards, that.cards) &&
                Objects.equals(client, that.client) &&
                Objects.equals(courierType, that.courierType) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(deliveryDateTime, that.deliveryDateTime) &&
                Objects.equals(maxArriveToCustomerAt, that.maxArriveToCustomerAt) &&
                Objects.equals(maxArriveToPlaceAt, that.maxArriveToPlaceAt) &&
                Objects.equals(modelId, that.modelId) &&
                Objects.equals(orderAdditionalNumber, that.orderAdditionalNumber) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(originId, that.originId) &&
                Objects.equals(placeOrderStatus, that.placeOrderStatus) &&
                Objects.equals(placeOrderStatusUpdatedAt, that.placeOrderStatusUpdatedAt) &&
                restaurant.equals(that.restaurant) &&
                status.equals(that.status) &&
                Objects.equals(toRestDateTime, that.toRestDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, changeOn, changeTotal, client, clientTotal, courierType, createdAt, currency, deliveryDateTime, deliveryFee, discount, isAdopted, isAsap, isSelected, maxArriveToCustomerAt, maxArriveToPlaceAt, modelId, orderAdditionalNumber, orderNumber, originId, persons, placeOrderStatus, placeOrderStatusUpdatedAt, restaurant, status, subtotal, toRestDateTime, total, unassigned);
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "cards=" + cards +
                ", changeOn=" + changeOn +
                ", changeTotal=" + changeTotal +
                ", client=" + client +
                ", clientTotal=" + clientTotal +
                ", courierType='" + courierType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", currency=" + currency +
                ", deliveryDateTime='" + deliveryDateTime + '\'' +
                ", deliveryFee=" + deliveryFee +
                ", discount=" + discount +
                ", isAdopted=" + isAdopted +
                ", isAsap=" + isAsap +
                ", isSelected=" + isSelected +
                ", maxArriveToCustomerAt='" + maxArriveToCustomerAt + '\'' +
                ", maxArriveToPlaceAt='" + maxArriveToPlaceAt + '\'' +
                ", modelId='" + modelId + '\'' +
                ", orderAdditionalNumber='" + orderAdditionalNumber + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", originId='" + originId + '\'' +
                ", persons=" + persons +
                ", placeOrderStatus='" + placeOrderStatus + '\'' +
                ", placeOrderStatusUpdatedAt=" + placeOrderStatusUpdatedAt +
                ", restaurant=" + restaurant +
                ", status='" + status + '\'' +
                ", subtotal=" + subtotal +
                ", toRestDateTime=" + toRestDateTime +
                ", total=" + total +
                ", unassigned=" + unassigned +
                '}';
    }

    public OrderModel(OrderModel orderModel, List<CartItem> cards, int changeOn, int changeTotal, Customer client, int clientTotal, String courierType, String createdAt, Currency currency, String deliveryDateTime, int deliveryFee, int discount, boolean isAdopted, boolean isAsap, boolean isSelected, String maxArriveToCustomerAt, String maxArriveToPlaceAt, String modelId, String orderAdditionalNumber, String orderNumber, String originId, int persons, String placeOrderStatus, String placeOrderStatusUpdatedAt, Place restaurant, String status, int subtotal, String toRestDateTime, int total, boolean unassigned) {
        this.cards = cards;
        this.changeOn = changeOn;
        this.changeTotal = changeTotal;
        this.client = client;
        this.clientTotal = clientTotal;
        this.courierType = courierType;
        this.createdAt = createdAt;
        this.currency = currency;
        this.deliveryDateTime = deliveryDateTime;
        this.deliveryFee = deliveryFee;
        this.discount = discount;
        this.isAdopted = isAdopted;

        this.isAsap = isAsap;
        this.isSelected = isSelected;
        this.maxArriveToCustomerAt = maxArriveToCustomerAt;
        this.maxArriveToPlaceAt = maxArriveToPlaceAt;
        this.modelId = modelId;
        this.orderAdditionalNumber = orderAdditionalNumber;
        this.orderNumber = orderNumber;
        this.originId = originId;
        this.persons = persons;
        this.placeOrderStatus = placeOrderStatus;
        this.placeOrderStatusUpdatedAt = placeOrderStatusUpdatedAt;
        this.restaurant = restaurant;
        this.status = status;
        this.subtotal = subtotal;
        this.toRestDateTime = toRestDateTime;
        this.total = total;
        this.unassigned = unassigned;
    }

    @Override
    public void writeExternal(DataOutput dataOutput) {

    }

    @Override
    public void readExternal(DataInput dataInput) {

    }

    @Override
    public Persistable deepClone() {
        return null;
    }
}
