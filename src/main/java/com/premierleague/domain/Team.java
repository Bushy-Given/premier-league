package com.premierleague.domain;

import com.premierleague.constant.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.premierleague.constant.Result.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String name;
    private int round;
    private int played;
    private int won;
    private int loss;
    private int draw;
    private int goals;
    private int points;

    public void addData(Result result, int goals, String name) {
        this.name = name;
        this.played += 1;
        this.goals += goals;
        this.round += 1;
        this.won += isWon(result) ? 1 : 0;
        this.points += isWon(result) ? 3 : isDraw(result) ? 1 : 0;
        this.loss += isLoss(result) ? 1 : 0;
        this.draw += isDraw(result) ? 1 : 0;
    }

    public Team addResult(String teamName, int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore > awayTeamScore) {
            this.addData(Result.WON, homeTeamScore, teamName);
        } else if (homeTeamScore < awayTeamScore) {
            this.addData(Result.LOSS, homeTeamScore, teamName);
        } else {
            this.addData(Result.DRAW, homeTeamScore, teamName);
        }
        return this;
    }
}

