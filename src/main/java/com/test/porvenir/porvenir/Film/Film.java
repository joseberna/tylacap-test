package com.test.porvenir.porvenir.Film;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Film {

  @Id
  private Integer episode_id;
  @Basic
  private String title;
  private String release_date;
  private boolean status;


  public Integer getEpisode_id() {
    return episode_id;
  }

  public void setEpisode_idd(Integer episodeId) {
    this.episode_id = episodeId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getReleaseDate() {
    return release_date;
  }

  public void setReleaseDate(String releaseDate) {
    this.release_date = releaseDate;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

}
