package com.innitiatechlab.api.match.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
  private String city;
  private List<Date> dates;
  private String gender;
  private String matchType;
  private String neutral_venue;
  private Outcome outcome;
  private Integer overs;
  private List<String> player_of_match;
  private List<String> teams;
  private Toss toss;
  private List<String> umpires;
  private String venue;
}
