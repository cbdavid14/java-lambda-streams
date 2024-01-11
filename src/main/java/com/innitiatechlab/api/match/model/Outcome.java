package com.innitiatechlab.api.match.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Outcome {

  private By by;
  private String bowl_out;
  private String result;
  private String winner;

  @Getter
  @Setter
  @NoArgsConstructor
  private class By {
    private String runs;
    private String wickets;
  }
}
