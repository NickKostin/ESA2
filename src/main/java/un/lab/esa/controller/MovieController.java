package un.lab.esa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import un.lab.esa.model.Movie;
import un.lab.esa.service.MovieService;

@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired(required = true)
    @Qualifier(value = "movieService")
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "movies", method = RequestMethod.GET)
    public String listMovies(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("listMovies", this.movieService.listMovies());

        return "movies";
    }
}
