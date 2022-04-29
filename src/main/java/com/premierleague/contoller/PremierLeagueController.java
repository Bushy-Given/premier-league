package com.premierleague.contoller;

import com.premierleague.domain.PremierLeagueTable;
import com.premierleague.service.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/premier-league")
@RequiredArgsConstructor
public class PremierLeagueController {

    private final PremierLeagueService premierLeagueService;

    @PostMapping("/upload-csv")
    public PremierLeagueTable getPremierLeagueTable(@RequestParam("file") MultipartFile file) {
        throw new IllegalStateException("not yet implemented");
    }
}
