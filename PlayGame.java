/**
 * Starts a game. Creates the world and starts a war.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class PlayGame
{
    /**
     * Instantiates a new game. Makes a World object and calls its war class.
     */
    public PlayGame()
    {
        World earth = new World();
        earth.war();
    }
}
