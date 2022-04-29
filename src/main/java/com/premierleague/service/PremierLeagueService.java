package com.premierleague.service;

import com.premierleague.domain.PremierLeagueTable;
import lombok.SneakyThrows;

import java.io.IOException;

public interface PremierLeagueService {
    @SneakyThrows(IOException.class)
    PremierLeagueTable getPremierLeagueTable(String csvFilePath);
}
