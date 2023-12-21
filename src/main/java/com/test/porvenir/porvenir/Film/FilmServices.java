package com.test.porvenir.porvenir.Film;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmServices {

  private final RestTemplate restTemplate;

  private final FilmRepository filmRepository;

  public ResponseEntity<FilmInterface> getFilm(Long id) {
    String url = "https://swapi.dev/api/films/" + id + "/";
    ResponseEntity<FilmInterface> responseEntity = restTemplate.getForEntity(url, FilmInterface.class);
    Film film = new Film();

    if (responseEntity.getStatusCode().is2xxSuccessful()) {
      FilmInterface filmInterface = responseEntity.getBody();

      if (filmInterface != null) {
        film.setEpisode_id(filmInterface.getEpisode_id());
        film.setTitle(filmInterface.getTitle());
        film.setReleaseDate(filmInterface.getRelease_date());
        film.setStatus(true);
        filmRepository.save(film);
      }
    }

    return responseEntity;
  }

  public ResponseEntity<Film> updateFilm(Integer id, Film updatedFilm) {

    Film existingFilm = filmRepository.findById(id).orElse(null);

    if (existingFilm != null) {

      existingFilm.setEpisode_id(existingFilm.getEpisode_id());
      existingFilm.setTitle(updatedFilm.getTitle());
      existingFilm.setReleaseDate(updatedFilm.getReleaseDate());
      existingFilm.setStatus(existingFilm.getStatus());

      Film updatedFilmEntity = filmRepository.save(existingFilm);
      return ResponseEntity.ok(updatedFilmEntity);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

  }

  public void deleteFilmById(Integer id) {
    filmRepository.deleteById(id);
  }

}