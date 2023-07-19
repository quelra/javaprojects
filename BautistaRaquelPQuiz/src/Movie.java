/**
 * @author BAUTISTA, Raquel S.
 * February 14, 2020
 * TF 9:30 - 11:00 d522
 *
 * Reference class Movie
 */


public class Movie {

    private String title;
    private String producer;
    private int size;

    /**
     * Default constructor
     */
    public Movie(){
        title = "";
        producer = "";
        size = 0;
    }

    /**
     *
     * @param title
     * @param producer
     * @param size
     */
    public Movie(String title, String producer, int size){
        this.title = title;
        this.producer = producer;
        this.size = size;
    }

    /**
     *
     * @param title
     */
    public Movie (String title){
        this.title = title;
        this.producer = "";
    }

    /**
     * Gets title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets producer
     * @return
     */
    public String getProducer (){
        return producer;
    }

    /**
     * gets size
     * @return
     */
    public  int getSize(){
        return size;
    }

    /**
     * sets title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * sets producer
     * @param producer
     */
    public void setProducer(String producer){
        this.producer = producer;
    }

    /**
     * sets size
     * @param size
     */
    public void setSize(int size){
        this.size = size;
    }


}
