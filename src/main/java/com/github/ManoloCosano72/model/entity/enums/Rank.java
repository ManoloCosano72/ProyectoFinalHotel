package com.github.ManoloCosano72.model.entity.enums;

public enum Rank {
    ADMIN("Admin"),
    CLIENT("Client");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
