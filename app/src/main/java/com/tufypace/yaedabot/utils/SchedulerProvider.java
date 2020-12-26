package com.tufypace.yaedabot.utils;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler competition();

    Scheduler io();

    Scheduler ui();
}
