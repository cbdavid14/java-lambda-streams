package com.innitiatechlab.api.match;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innitiatechlab.api.match.data.MatchRepository;
import com.innitiatechlab.api.match.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class matchCountryApplication {

  public static void main(String[] args) {
    SpringApplication.run(matchCountryApplication.class, args);
  }

  @Autowired
  private MatchRepository matchRepository;

  @Bean
  CommandLineRunner runnerFromFile() {
    return args -> {
      loadFileJson("/data/211028.json");
    };
  }

  private void loadFileJson(String fileName) {
    ObjectMapper mapper = new ObjectMapper();
    InputStream stream = TypeReference.class.getResourceAsStream(fileName);
    try {
      Match matches = mapper.readValue(stream, new TypeReference<Match>() {
      });
      matchRepository.addMatch(matches);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Bean
  CommandLineRunner runnerFromDirectory() {
    return args -> {
      String folder = "/data";
      URL resource = getClass().getResource(folder);

      StopWatch sw = new StopWatch();
      sw.start("runnerFromDirectory");

      Files.walk(Paths.get(resource.toURI()))
        .parallel()
        .filter(Files::isRegularFile)
        .filter(x -> x.toString().endsWith(".json"))
        .map(Path::toFile)
        .forEach(x -> loadFileJson(String.join("/", folder, x.getName())));


      sw.stop();
      System.out.println(sw.prettyPrint());
    };
  }

}
