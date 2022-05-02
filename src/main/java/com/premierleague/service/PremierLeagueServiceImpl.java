package com.premierleague.service;

import com.premierleague.domain.PremierLeagueTable;
import com.premierleague.domain.Team;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Service
public class PremierLeagueServiceImpl implements PremierLeagueService {

    @Override
    @SneakyThrows(IOException.class)
    public PremierLeagueTable getPremierLeagueTable(String csvFilePath) {
        List<String> lines = Files.readAllLines(Path.of(csvFilePath));
        List<Team> teamsDistinct = lines.stream()
                .skip(1L)
                .map(round -> round.split(","))
                .flatMap(teams -> Stream.of(teams)
                        .skip(1L)
                        .map(teamResults(new Team(), teams[0]))
                        .collect(toSet()).stream())
                .collect(Collectors.toList());

        return PremierLeagueTable.builder().teams(teamsDistinct).build();
    }

    private Function<String, Team> teamResults(Team team, String teamName) {
        return line -> {
            String[] scores = line.split("-");
            int home = Integer.parseInt(scores[0].trim());
            int away = Integer.parseInt(scores[1].trim());
            return team.addResult(teamName, home, away);
        };
    }
}
