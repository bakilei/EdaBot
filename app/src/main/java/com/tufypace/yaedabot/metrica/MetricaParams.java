package com.tufypace.yaedabot.metrica;

public class MetricaParams {
    public static final MetricaParams INSTANCE = new MetricaParams();

    public static final class EventAttributes {
        public static final String ATTR_ACTIVITY_TRANSITION = "activityTransition";
        public static final String ATTR_ACTIVITY_TYPE = "activityType";
        public static final String ATTR_ALLOWANCE_GEO = "allowanceGeo";
        public static final String ATTR_AVAILABLE_GEO = "availableGeo";
        public static final String ATTR_BLOCK_UNTIL_TIME = "blockUntilTime";
        public static final String ATTR_CONNECTION_STATE = "connectionState";
        public static final String ATTR_COURIER_BILLING_TYPE = "courierBillingType";
        public static final String ATTR_COURIER_ID = "courierId";
        public static final String ATTR_COURIER_STATUS = "courierStatus";
        public static final String ATTR_COURIER_TYPE = "courierType";
        public static final String ATTR_ENDS_AT = "endsAt";
        public static final String ATTR_EVENT_TIME = "eventTime";
        public static final String ATTR_FAKE_GEO = "fakeGeo";
        public static final String ATTR_FLIGHT_MODE = "flightMode";
        public static final String ATTR_FROM_CACHE = "fromCache";
        public static final String ATTR_LOCATION_PROVIDER = "locationProvider";
        public static final String ATTR_MINUTES_UNTIL = "minutesUntil";
        public static final String ATTR_ONLINE_STATUS = "online";
        public static final String ATTR_OPENED_SHIFT = "openedShift";
        public static final String ATTR_ORDER_ID = "orderId";
        public static final String ATTR_ORDER_STATUS = "orderStatus";
        public static final String ATTR_RESOLUTION_RESULT = "resolutionResult";
        public static final String ATTR_SCREEN_NAME_FROM = "screenNameFrom";
        public static final String ATTR_SCREEN_NAME_TO = "screenNameTo";
        public static final String ATTR_SELECTED_DATE = "selectedDate";
        public static final String ATTR_SERVICE_STATE = "serviceState";
        public static final String ATTR_SHIFT_ID = "shiftId";
        public static final String ATTR_SHIFT_IDS = "shiftIds";
        public static final String ATTR_STARTS_AT = "startAt";
        public static final String ATTR_START_POINT_ID = "startPointId";
        public static final String ATTR_START_POINT_IDS = "startPointIds";
        public static final String ATTR_TIME_DIFF = "timeDiff";
        public static final String ATTR_TIME_ZONE = "timeZone";
        public static final String ATTR_TYPE_REMOVE_ORDER = "typeRemove";
        public static final String ATTR_USER_COORDINATES = "userCoordinates";
        public static final String ATTR_USER_ORDERS = "userOrders";
        public static final EventAttributes INSTANCE = new EventAttributes();

        private EventAttributes() {
        }
    }

    /* compiled from: MetricaParams.kt */
    public static final class EventTitles {
        public static final String EVENT_2GIS_MAPS = "2gis_maps";
        public static final String EVENT_ALLOW_GEO_PERMISSION = "allow_geo_permission";
        public static final String EVENT_AUTHENTICATION = "authentication";
        public static final String EVENT_BACKGROUND_MODE_OFF = "background_mode_off";
        public static final String EVENT_BACKGROUND_MODE_ON = "background_mode_on";
        public static final String EVENT_CHANGE_ACTIVITY_RECOGNITION = "change_courier_activity";
        public static final String EVENT_CHANGE_ORDER_STATUS_NOTIFICATION = "change_order_status_notification";
        public static final String EVENT_CHANGE_ORDER_STATUS_NOTIFICATION_OPENED = "change_order_status_notification_opened";
        public static final String EVENT_CHANGE_ORDER_STATUS_REMINDER = "change_order_status_reminder";
        public static final String EVENT_CLICK_ACCEPTED_BUTTON = "click_accepted_button";
        public static final String EVENT_CLICK_APPLY_SHIFT_CHANGES_BUTTON = "click_apply_shift_changes_button";
        public static final String EVENT_CLICK_ARRIVED_TO_COSTUMER_BUTTON = "click_arrived_to_costumer_button";
        public static final String EVENT_CLICK_ARRIVED_TO_PLACE_BUTTON = "click_arrived_to_place_button";
        public static final String EVENT_CLICK_DECLINE_SHIFT_CHANGES_BUTTON = "click_decline_shift_changes_button";
        public static final String EVENT_CLICK_DELIVERED_BUTTON = "click_delivered_button";
        public static final String EVENT_CLICK_HIDE_BUTTON = "click_hide_button";
        public static final String EVENT_CLICK_SHIFTS_DATE = "click_shifts_date";
        public static final String EVENT_CLICK_SHIFT_PAUSE_STATUS_BAR = "click_shift_pause_status_bar";
        public static final String EVENT_CLICK_SHIFT_REFUSE_BUTTON = "click_shift_refuse_button";
        public static final String EVENT_CLICK_SHIFT_SAVE_BUTTON = "click_shifts_save_button";
        public static final String EVENT_CLICK_SHIFT_START_BUTTON = "click_shift_start_button";
        public static final String EVENT_CLICK_SHIFT_START_STATUS_BAR = "click_shift_start_status_bar";
        public static final String EVENT_CLICK_SHIFT_STOP_STATUS_BAR = "click_shift_close_status_bar";
        public static final String EVENT_CLICK_SHIFT_UNPAUSE_STATUS_BAR = "click_shift_unpause_status_bar";
        public static final String EVENT_CLICK_TAKEN_AT_BUTTON = "click_taken_at_button";
        public static final String EVENT_CLICK_UPDATE_ORDERS_NOTIFICATION = "click_update_orders_notification";
        public static final String EVENT_DARK_MODE = "dark_mode";
        public static final String EVENT_FOREGROUND_SERVICE_STATE = "foreground_service_state";
        public static final String EVENT_GEO_AVAILABLE = "geo_available";
        public static final String EVENT_GEO_SPECIFIED = "geo_specified";
        public static final String EVENT_GET_DEVICE_COORDINATES = "get_device_coordinates";
        public static final String EVENT_LIGHT_MODE = "light_mode";
        public static final String EVENT_LOG_OUT = "log_out";
        public static final String EVENT_NAVIGATOR_MAPS = "yandex_navigator_maps";
        public static final String EVENT_ORDER_NOTIFICATION = "order_notification";
        public static final String EVENT_ORDER_NOTIFICATION_OPENED = "order_notification_opened";
        public static final String EVENT_ORDER_REMOVED = "order_removed";
        public static final String EVENT_SCREEN_OPENED = "screen_opened";
        public static final String EVENT_SEND_FORM = "send_form";
        public static final String EVENT_SHIFT_CHANGES_NOTIFICATION = "shift_changes_notification";
        public static final String EVENT_SHIFT_CHANGES_NOTIFICATIONS = "shift_changes_notifications";
        public static final String EVENT_SHIFT_CHANGES_NOTIFICATIONS_OPENED = "shift_changes_notifications_opened";
        public static final String EVENT_SHIFT_CHANGES_NOTIFICATION_OPENED = "shift_changes_notification_opened";
        public static final String EVENT_SHIFT_LOCATIONS_SAVE = "shift_locations_save";
        public static final String EVENT_SHIFT_PULL_TO_REFRESH = "shift_pull_to_refresh";
        public static final String EVENT_SHOW_BLOCKED_UNTIL_INFO = "show_blocked_until_info";
        public static final String EVENT_SUCCESS_CLICK_ACCEPTED_BUTTON = "success_click_accepted_button";
        public static final String EVENT_SUCCESS_CLICK_ARRIVED_TO_COSTUMER_BUTTON = "success_click_arrived_to_costumer_button";
        public static final String EVENT_SUCCESS_CLICK_ARRIVED_TO_PLACE_BUTTON = "success_click_arrived_to_place_button";
        public static final String EVENT_SUCCESS_CLICK_DELIVERED_BUTTON = "success_click_delivered_button";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_CHANGES_BUTTON = "success_click_apply_shift_changes_button";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_PAUSE_STATUS_BAR = "success_click_shift_pause_status_bar";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_REFUSE_BUTTON = "success_click_shift_refuse_button";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_SAVE_BUTTON = "success_click_shift_save_button";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_START_BUTTON = "success_click_shift_start_button";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_START_STATUS_BAR = "success_click_shift_start_status_bar";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_STOP_STATUS_BAR = "success_click_shift_close_status_bar";
        public static final String EVENT_SUCCESS_CLICK_SHIFT_UNPAUSE_STATUS_BAR = "success_click_shift_unpause_status_bar";
        public static final String EVENT_SUCCESS_CLICK_TAKEN_AT_BUTTON = "success_click_taken_at_button";
        public static final String EVENT_SUCCESS_UNPLANNED_SHIFT_START = "success_click_unplanned_shift_start_status_bar";
        public static final String EVENT_TOKEN_EXPIRED = "token_expired";
        public static final String EVENT_UNPLANNED_SHIFT_START = "click_unplanned_shift_start_status_bar";
        public static final String EVENT_WRONG_COORDINATES_DATA = "wrong_coordinates_data";
        public static final String EVENT_YANDEX_MAPS = "yandex_maps";
        public static final EventTitles INSTANCE = new EventTitles();

        private EventTitles() {
        }
    }

    /* compiled from: MetricaParams.kt */
    public static final class EventValues {
        public static final String ALLOW = "allow";
        public static final String DENY = "deny";
        public static final String DISABLE = "disable";
        public static final String ENABLE = "enable";
        public static final EventValues INSTANCE = new EventValues();
        public static final String ORDER_CANCELED = "canceled";
        public static final String ORDER_UNASSIGNED = "unassigned";
        public static final String SERVICE_CREATED = "created";
        public static final String SERVICE_DESTROYED = "destroyed";
        public static final String START_ACTIVITY = "start_activity";
        public static final String STOP_ACTIVITY = "stop_activity";

        private EventValues() {
        }
    }

    private MetricaParams() {
    }
}
