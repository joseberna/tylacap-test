package com.test.porvenir.porvenir.Film;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

  private final FilmServices filmService;

  @GetMapping(path = "{id}")
  public ResponseEntity<?> getFilm(@PathVariable("id") String id) {

    try {

      if (!id.matches("\\d+")) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
      }

      long idFilm = Long.parseLong(id);
      ResponseEntity<FilmInterface> responseEntity = filmService.getFilm(idFilm);

      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        return ResponseEntity.ok(responseEntity.getBody());
      } else {
        return responseEntity;

      }
    } catch (HttpClientErrorException.NotFound e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{ \"error\": \"Algo salió mal\" }");
    }

  }

  @PutMapping(path = "{id}")
  public ResponseEntity<?> updateFilm(@PathVariable String id, @RequestBody Film body) {

    try {
      if (!id.matches("\\d+")) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
      }

      Integer idFilm = Integer.parseInt(id);

      ResponseEntity<Film> responseEntity = filmService.updateFilm(idFilm, body);

      if (responseEntity.getBody() != null) {
        return ResponseEntity.ok(responseEntity.getBody());
      } else {
        return ResponseEntity.status(responseEntity.getStatusCode()).body(null);
      }

    } catch (HttpClientErrorException.NotFound e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{ \"error\": \"Algo salió mal\" }");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteFilmById(@PathVariable String id) {

    try {
      if (!id.matches("\\d+")) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
      }

      Integer idFilm = Integer.parseInt(id);

      filmService.deleteFilmById(idFilm);
      return ResponseEntity.ok("Película eliminada exitosamente");

    } catch (

    HttpClientErrorException.NotFound e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"error\": \"error en la solicitud\" }");
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{ \"error\": \"Algo salió mal\" }");
    }

  }
}
