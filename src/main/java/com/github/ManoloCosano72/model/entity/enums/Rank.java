package com.github.ManoloCosano72.model.entity.enums;

public enum Rank {
    MANAGER("Admin"),
    CLIENTUSER("Client");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
