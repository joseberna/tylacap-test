package com.test.porvenir.porvenir.Film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmInterface {

  private Integer episode_id;
  private String title;
  private String release_date;

  public Integer getEpisode_id() {
    return episode_id;
  }

  public void setEpisode_id(Integer episode_id) {
    this.episode_id = episode_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRelease_date() {
    return release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

}
