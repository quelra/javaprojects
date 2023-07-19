import java.util.Scanner;

/**
 * This is the main method for creating movie records.
 */
public class MovieRecords {
    public static void main(String[] args) throws NumberFormatException{
        Scanner input = new Scanner(System.in);

        System.out.println("Input number of movies to enter: ");
        int size = readInteger();
        if(size==0){
            size = readInteger();
        }
        Movie[] movie = new Movie[size];

        for (int i = 0, number = 1; i < size; i++, number++) {
            movie[i] = readMovie(number);
        }

        Movie[] moviesCopy = copyListOfMovie(movie);
        Movie[] sorted = sortListOfMovies(moviesCopy);
        showListOfMovies(sorted);


    }

    /**
     * This method reads a valid integer.
     *
     */
    public static int readInteger(){
        Scanner input = new Scanner(System.in);
        int result=0;
        try {
            result = Integer.parseInt(input.next());
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please input an integer.");
            return result = 0;
        } catch (Exception d){
            d.printStackTrace();
        }
        return result;
    }

    /**
     * This method returns an object Movie that is constructed after values for the attributes of a Movie are entered.
     */
    public static Movie readMovie(int number){
        Scanner input = new Scanner(System.in);
        Movie movie = new Movie();

        System.out.println("Input title of movie " + number);
        movie.setTitle(input.next());
        System.out.println("Input name of producer of movie " + number);
        movie.setProducer(input.next());
        System.out.println("Input the size in Megabytes of movie " + number);
        movie.setSize(readInteger());
        return movie;
    }

    /**
     * This method returns a copy of the given array.
     */
    public static Movie[] copyListOfMovie(Movie[] givenArray){
        return givenArray;
    }

    /**
     * This method sorts the movie list.
     * @param arrayOfMovie
     * @return
     */
    public static Movie[] sortListOfMovies(Movie[] arrayOfMovie){
        Movie[] sortedMovie = new Movie[arrayOfMovie.length];

        for(int i = 0; i<sortedMovie.length ; i++){
            for(int j = 1 ; j<sortedMovie.length;j++){
                if(arrayOfMovie[i].getTitle().compareToIgnoreCase(arrayOfMovie[j].getTitle()) > 0){ //
                    Movie x = arrayOfMovie[i];
                    arrayOfMovie[i] = arrayOfMovie[j];
                    arrayOfMovie[j] = x;
                }
            }
        }

        return arrayOfMovie;
    }

    /**
     * This shows the sorted movie list
     * @param arrayOfMovie
     */
    public static void showListOfMovies(Movie[] arrayOfMovie){
        System.out.printf("%-10s%-20s%-5s%n", "Title ", "Producer", "Size");
        for(int i=0; i<arrayOfMovie.length; i++){
            System.out.printf("%-10s%-20s%-5s%n", arrayOfMovie[i].getTitle(),arrayOfMovie[i].getProducer(), arrayOfMovie[i].getSize());
        }
    }

}
