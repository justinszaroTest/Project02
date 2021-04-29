/**
 * Death will reap the souls of people with less than ten health. However, he can only do this three times.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class DeathArtifact extends People {
    /**
     * Instantiates a DeathArtifact Object and establishes its properties.
     * @param nation the nations name
     * @param tribe the tribes name
     * @param lifePoints the number of lifepoints
     */
    public DeathArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.reaper, lifePoints, "Death");
        myDescription = "\tDeath attempts to reap a soul!";
    }
    /**
     * If the opponents heath is less than ten, Death reaps their souls. If he does this, he loses 1 health point.
     * @param otherPerson Other Person who is involved in the encounter
     * @return lifepoints number of lifepoints to be used in the encounter.
     */
    @Override
    public int encounterStrategy(People otherPerson) {
        if (otherPerson.getLifePoints() < 10) {
            otherPerson.setDead();
            otherPerson.modifyLifePoints(-otherPerson.getLifePoints());
            this.modifyLifePoints(-1);
        }
        return 0;
    }
}
