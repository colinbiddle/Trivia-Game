
/**
 * This is the main driver class for this project. For more, please see readme.txt.
 *
 * Colin Biddle
 * colinbiddle at protonmail dot com
 * v1.0.090818
 */
public class Trivia
{
    public static void main(String[] args) {
        try {
            KeepScore test = new KeepScore();
        } catch (Exception ex) {
            System.out.println("We're currently experiencing technical difficulties...");
            ex.printStackTrace();
        }
    }
}
