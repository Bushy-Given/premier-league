package com.premierleague.constant;

public enum Result {
    WON, DRAW, LOSS;

    public static boolean isWon(Result result) {
        return result.equals(Result.WON);
    }

    public static boolean isDraw(Result result) {
        return result.equals(Result.DRAW);
    }

    public static boolean isLoss(Result result) {
        return result.equals(Result.LOSS);
    }
}
