package com.tufypace.yaedabot.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tufypace.yaedabot.model.balance.BalanceHistory;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceHistoryModels {

    public List<BalanceHistory> bankAccountHistoryItems;

    public List<BalanceHistory> getContent() {
        return this.bankAccountHistoryItems;
    }

    public void setContent(List<BalanceHistory> list) {
        this.bankAccountHistoryItems = list;
    }
}
