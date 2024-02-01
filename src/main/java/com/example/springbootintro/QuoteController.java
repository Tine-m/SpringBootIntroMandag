package com.example.springbootintro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("quotes")
public class QuoteController {

    @GetMapping("/random")
    @ResponseBody
    public String getRandomQuote() {
        Random random = new Random();
        List<String> quotes = new ArrayList<>();
        quotes.add("Bedre sent end aldrig");
        quotes.add("Ude godt, hjemme bedst");
        quotes.add("Den der ler sidst, ler bedst");
        quotes.add("Bedre lille og vågen end stor og doven");
        quotes.add("Det har jeg aldrig gjort før, så det klarer jeg helt sikkert");
        quotes.add("Du misser 100 procent af de skud, du ikke tager");
        return quotes.get(random.nextInt(quotes.size()));
    }

    @GetMapping("/random2")
    public ResponseEntity<Quote> getRandomQuote2() {
        Random random = new Random();
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Bedre sent end aldrig", "Ukendt", "Almen"));
        quotes.add(new Quote("Ude godt, hjemme bedst", "Ukendt", "Almen"));
        quotes.add(new Quote("Den der ler sidst ler bedst", "Ukendt", "Almen"));
        quotes.add(new Quote("Bedre lille og vågen end stor og doven",  "Ukendt", "Almen"));
        quotes.add(new Quote("Det har jeg aldrig gjort før, så det klarer jeg helt sikkert", "Pippi", "Underholdning"));
        quotes.add(new Quote("Du misser 100 procent af de skud, du ikke tager", "Wayne Gretzky", "Sport"));
        return new ResponseEntity<>(quotes.get(random.nextInt(quotes.size())), HttpStatus.OK);
    }

    @GetMapping(value="/random3")
    public ResponseEntity<Object> getRandomQuote3() throws IOException {
        URL url = new URL("https://quote-garden.onrender.com/api/v3/quotes/random");
        BufferedReader inputFromUrl = new BufferedReader(new InputStreamReader(url.openStream()));
        Object quote = new Gson().fromJson(inputFromUrl,Object.class);
        inputFromUrl.close();
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }
}
