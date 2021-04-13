/**
 * The People class instantiates a new person and assigns its nation, tribe, Peopletype, gets its Description from
 * PeopleType.java, and assigns the persons lifepoints. The class also includes getters for the Person's PeopleType,
 * Tribe, Nation, and Lifepoints. The isPersonAlive() method checks to see if the persons lifepoints > 0 and the
 * modifyLifePoints()  method reduces the person's Lifepoints. The toString() method outputs the current person's
 * values. The encounterStrategy method currently does nothing.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public abstract class People
{
    private final String myNation;
    private final String myTribe;
    private final PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    private boolean dead;

    /**
     * Instantiates a new person.
     * The constructor makes a new person and assigns their nation, tribe, PeopleType, and amount of lifepoints.
     * @param nation name of the nation
     * @param tribe name of the tribe
     * @param person type of created person
     * @param lifePoints total lifepoints of person
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
    }

    public void setDead()
    {
        dead = true;
    }

    public boolean getDead()
    {
        return dead;
    }

    /**
     * Returns a persons PeopleType
     * @return me Returns PeopleType of person
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns a person's Tribe
     * @return myTribe Returns the Person's Tribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns a persons Nation
     * @return myNation Returns Person's nation
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Determines whether or not a person is alive
     * @return bool Returns true if lifepoints are greater than 0, if =< 0, returns false
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Returns the current lifepoints of the Person
     * @return  myLifePoints Returns lifepoints of Person.
     */
    public int getLifePoints() { return myLifePoints;}

    /**
     * Reduces or increases the Person's Lifepoints by the parameter points. A person's lifepoints is capped at 100.
     * @param points Number of points a Persons LifePoints should be reduced by.
     */
    public void modifyLifePoints(int points)
    {
       if ((myLifePoints + points ) > 100) {
           myLifePoints = 100;
       }
       else{
           myLifePoints += points;
       }
    }

    /**
     * Abstract method to makes an encounter strategy for a particular person.
     * @param otherPerson Other Person who is involved in the encounter
     */
    public abstract int encounterStrategy(People otherPerson);


    /**
     * Returns the variable values for the Person.
     * @return result Returns a summary of a Person's characteristics.
     */
    public String toString()
    {
        return new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
    }
}

