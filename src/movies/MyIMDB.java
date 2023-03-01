package movies;

import cs.Genre;
import cs.TitleType;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * The subclass of the IMDB abstract class that implements all the required
 * abstract query methods.
 *
 * @author RIT CS
 * @author Helena Lynd
 */
public class MyIMDB extends IMDB {
    /** The minimum number of votes a movie needs to be considered for top ranking */
    private final static int MIN_NUM_VOTES_FOR_TOP_RANKED = 1000;

    /**
     * Create IMDB using the small or large dataset.
     *
     * @param small true if the small dataset is desired, otherwise the large one
     * @throws FileNotFoundException
     */
    public MyIMDB(boolean small) throws FileNotFoundException {
        super(small);
    }

    @Override
    public Collection<Movie> getMovieTitleWithWords(String type, String words) {
        // we simply loop over movieList and add to our list the movies that
        // have the same type, and contain the words substring
        List<Movie> result = new LinkedList<>();
        for(int i = 0; i < movieList.size(); i++){
            Movie m = movieList.get(i);
            if (m.getTitle().contains(words) && m.getTitleType().name().equals(type)){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Movie findMovieByID(String ID) {
        Movie result = null;
        if (this.movieMap.containsKey(ID)){
            result = movieMap.get(ID);
        }
        return result;
    }

    @Override
    public Collection<Movie> getMoviesByYearAndGenre(String type, int year, String genre) {
        // we use Movie's natural order comparison which is to order Movie's of a
        // type by title and then year
        Set<Movie> result = new TreeSet<>();
        for (int i = 0; i < this.movieList.size(); i++){
            Movie m = movieList.get(i);
            if (m.getTitleType().name().equals(type) && m.getYear() == year && m.getGenres().contains(Genre.valueOf(genre))){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Collection<Movie> getMoviesByRuntime(String type, int start, int end) {
        // we use a comparator which orders Movie's of a type by descending runtime
        // and then title
        Set<Movie> result = new TreeSet<>(new MovieComparatorRuntime());
        for (int i = 0; i < this.movieList.size(); i++){
            Movie m = movieList.get(i);
            if (m.getTitleType().name().equals(type) && m.getRuntimeMinutes() >= start && m.getRuntimeMinutes() <= end){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Collection<Movie> getMoviesMostVotes(int num, String type) {
        // use a comparator that orders Movie's of a type by descending number
        // of votes

        List<Movie> result = new LinkedList<>();
        TreeSet<Movie> temp = new TreeSet<>(new MovieComparatorVotes());

        for(int i = 0; i < movieList.size(); i++){
                Movie m = this.movieList.get(i);
                if (m.getTitleType().name().equals(type)){
                    temp.add(m);
                 }
        }

        for(int i = 0; i < num; i++){
            result.add(temp.first());
            temp.remove(temp.first());
        }
        return result;
    }
}