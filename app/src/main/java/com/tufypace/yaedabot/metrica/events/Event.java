package com.tufypace.yaedabot.metrica.events;

import java.util.Map;

public interface Event {
    Map<String, Object> getAttrs();

    String getTitle();
}
