package com.premierleague;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.premierleague.domain.PremierLeagueTable;
import com.premierleague.service.PremierLeagueService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PremierLeagueApplication {
    //to can change this to your own local path where you stored your inputCSV
    public static final String CSV_PATH = "C:\\Users\\bushy\\Downloads\\premier-league\\premier-league\\src\\main\\resources\\data\\input.csv";

    public static void main(String[] args) {
        SpringApplication.run(PremierLeagueApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(PremierLeagueService premierLeagueService, ObjectMapper mapper) {
        return args -> {
            PremierLeagueTable premierLeagueTable = premierLeagueService.getPremierLeagueTable(CSV_PATH);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(premierLeagueTable);
            System.out.println(jsonString);
        };
    }
}
