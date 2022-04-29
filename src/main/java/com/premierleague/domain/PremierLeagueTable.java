package com.premierleague.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
public class PremierLeagueTable {
    private List<Team> teams;

    public List<Team> getTeams() {

        return Objects.requireNonNull(this.teams).stream()
                .distinct()
                .sorted(Comparator
                        .comparing(Team::getPoints)
                        .thenComparing(Team::getGoals)
                        .thenComparing(Team::getName).reversed()).collect(Collectors.toList());
    }
}
