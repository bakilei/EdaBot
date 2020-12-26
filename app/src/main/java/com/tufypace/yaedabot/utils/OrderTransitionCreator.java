package com.tufypace.yaedabot.utils;

import kotlin.jvm.internal.Intrinsics;

public final class OrderTransitionCreator {
    public final String getOrderTransitionByIntentAction(String str) {
        Intrinsics.checkNotNull(str, "action");
        switch (str) {
            case "ru.foodfox.courier.acceptOrder":
                return "accept";
            case "ru.foodfox.courier.deliverOrder":
                return "deliver";
            case "ru.foodfox.courier.arriveToClient":
                return "arriveToClient";
            case "ru.foodfox.courier.arriveToRestaurant":
                return "arriveToRestaurant";

        }
        return "";
    }

    public final String getOrderTransitionByStatus(String str) {
        Intrinsics.checkNotNull(str, "status");
        switch (str) {
            case "accepted":
                return "arriveToRestaurant";

            case "arrivedToRestaurant":
                return "take";

            case "new":
                return "accept";

            case "taken":
                return "arriveToClient";
            case "arrivedToClient":
                return "deliver";
        }
        return "";
    }
}
