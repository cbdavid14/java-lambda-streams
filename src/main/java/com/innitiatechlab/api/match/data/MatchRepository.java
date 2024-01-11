package com.innitiatechlab.api.match.data;

import com.innitiatechlab.api.match.model.Match;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchRepository {
  private List<Match> matches;

  public MatchRepository() {
    matches = new ArrayList<>();
  }

  public void addMatch(Match match) {
    if(matches == null) {
      matches = new ArrayList<>();
    }
    matches.add(match);
  }

  public List<Match> getMatches() {
    if(matches == null) {
      matches = new ArrayList<>();
    }
    return matches;
  }
}
