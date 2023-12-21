package com.test.porvenir.porvenir;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.test.porvenir.porvenir.Film.Film;
import com.test.porvenir.porvenir.Film.FilmRepository;
import com.test.porvenir.porvenir.Film.FilmServices;
import org.junit.Before;

@SpringBootTest
class PorvenirApplicationTests {
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private FilmServices filmSrv;
	@Mock
	private FilmRepository filmRepo;

	@Test
	void contextLoads() {
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGETFilmId(){
		when(filmRepo.findById(1)).thenReturn(Optional.of(new Film()));
		Long idFilm = (long) 1;
		ResponseEntity<?> result = filmSrv.getFilm(idFilm);
		verify(filmRepo, times(1)).findById(1);
		if(result != null){
			assertTrue(true);
		}
		
	}

	@Test
	public void testUPDFilm() {
		Film objFilm = new Film();
		objFilm.setEpisode_id(1);
		objFilm.setReleaseDate("1977-05-25");
		objFilm.setTitle("Mi Movie");
		when(filmRepo.findById(1)).thenReturn(Optional.of(new Film()));
		when(filmRepo.save(any(Film.class))).thenReturn(new Film());
		ResponseEntity<?> result = filmSrv.updateFilm(1, objFilm);
		assertNotNull(result);
	}

	@Test
	public void testDELETEFilm() {
		filmSrv.deleteFilmById(1);
		verify(filmRepo, times(1)).deleteById(1);
	}

}
