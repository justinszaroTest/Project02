import java.util.*;

/**
 *Creates the simualtion for the world, and populations. For every round played, the arrays of living and dead populations will be updated.
 * The nations are created and added. One round is played at time, and those nations will follow through with their intended strategies
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class World
{
    private final ArrayList<Nation> allNations = new ArrayList<>();

    Dice dice;
    ArrayList<People> worldCreatedPeople = new ArrayList<>();



    public World()
    {
        // seed for pseudo-random number generator
        Date seed = new Date();
        dice = new Dice(seed.getTime());
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }
/**
 * War is called from PlayGame. For each round, the arrays of surviving people are reset, if the arrays  are at least
 * greater than 1 and 2, then a round is played, if not then the game is over*/
    public void war()
        {
            ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

            int numberOfRounds = 4000;
            for(int round = 1; round < numberOfRounds; round++)
            {
                System.out.println("Round number: " + round);
                worldSurvivingPeople.clear();
                worldSurvivingPeople.addAll(getWorldSurvivingPeople());
                Set<String> survivingNations = new HashSet<>(getSurvivingNations());
                if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1) )
                    playOneRound(worldSurvivingPeople);
                else
                {
                    System.out.print("Game is over! Winning Nation is: ");
                    if (survivingNations.size() == 0)
                    {
                        System.out.println("All Nations Destroyed.");
                    }
                    else
                    {
                        System.out.println(survivingNations);
                        System.out.println("The survivors are:");
                        for (Integer worldSurvivingPerson : worldSurvivingPeople) {
                            System.out.println(worldCreatedPeople.get(worldSurvivingPerson));
                        }
                    }
                    break;
                }

            }

    }



    public void createWorld()
    {
        int worldLifePoints = 4000;
        allNations.add(new Nation("Maxwell's Nation", (worldLifePoints / 4)));
        allNations.add(new Nation("Justin's Nation", (worldLifePoints) / 4));
        allNations.add(new Nation("Elizabeth's Nation", (worldLifePoints / 4)));
        allNations.add(new Nation("Tanishq's Nation", (worldLifePoints) / 4));
        allNations.add(new Nation("Artifact's Nation", 12));

    }

    /**
     * Adds all People of all types per nation and tribe to livingPeople ArrayList
     * @return livingPeople An ArrayList with all people objects in it.
     */
    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for (Nation allNation : allNations) livingPeople.addAll(allNation.getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }

    /**
     * Will return an ArrayList of all the survivors that are in worldCreatePeople*/
    public ArrayList<Integer> getWorldSurvivingPeople()
    {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (int i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivors.add(i);
            }
        }
        return survivors;
    }

    /**
     * Goes through the world created array list, will update the survivingNations HashSet with
     * those people alive in worldCreatedPerson*/
    public Set<String> getSurvivingNations()
    {
        Set<String> survivingNations = new HashSet<>();

        for (People worldCreatedPerson : worldCreatedPeople) {
            if (worldCreatedPerson.isPersonAlive()) {
                survivingNations.add(worldCreatedPerson.getNation());
            }
        }
        return survivingNations;
    }

    /**
     * This is the turn where P1 attacks P2 in the turn
     * Calls their encounter strategies to get the number of lifepoints used, and sets the damage or heath to each
     * player.
     * @param person1 first member of the encounter
     * @param person2 second member of the encounter
     */
    public void encounter(Integer person1, Integer person2)
    {
        int person1LifePointsToUse;
        int person2LifePointsToUse;
        System.out.println("Encounter: " + worldCreatedPeople.get(person1) + worldCreatedPeople.get(person2));

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        person1LifePointsToUse = worldCreatedPeople.get(person1).encounterStrategy(worldCreatedPeople.get(person2));
        person2LifePointsToUse = worldCreatedPeople.get(person2).encounterStrategy(worldCreatedPeople.get(person1));

        // amount of life points actually used is subject to a pseudo-random encounter
        int p1damage =  (int) (dice.roll() * person1LifePointsToUse);
        int  p2damage =  (int) (dice.roll()  * person2LifePointsToUse);


        if ((worldCreatedPeople.get(person1).getNation().equals("Artifact's Nation"))) {
            p2damage =  (int) (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage);
            p1damage =  0;
        }
        else if ((worldCreatedPeople.get(person2).getNation().equals("Artifact's Nation"))) {
            p1damage =  (int) (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage);
            p2damage =  0;
        }
        else if ((p1damage > 0) && (p2damage > 0))  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage =  (int) (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage);
            p1damage =  (int) (dice.roll() * (worldCreatedPeople.get(person2).getType().ordinal()+1)*p2damage);
        }
        else if (p1damage > 0) // person 1 is fighting and person 2 is running
        {
            p2damage =  (int) (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*(p1damage/3));
        }
        else if (p2damage > 0) // person 2 is fighting and person 1 is running
        {
            p1damage =  (int) (dice.roll() * (worldCreatedPeople.get(person2).getType().ordinal()+1)*(p2damage/3));
        }


        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        worldCreatedPeople.get(person1).modifyLifePoints((-p2damage));
        worldCreatedPeople.get(person2).modifyLifePoints((-p1damage ));

        // Both people lose 1 life point per encounter due to aging
        if (!worldCreatedPeople.get(person1).getNation().equals("Artifact's Nation"))
            worldCreatedPeople.get(person1).modifyLifePoints((-1));
        if (!worldCreatedPeople.get(person2).getNation().equals("Artifact's Nation"))
            worldCreatedPeople.get(person2).modifyLifePoints((-1));

    }

    /**
     * Goes through one round of the game and sets up the encounters.
     * Returns all living nations
     * @param combatants An arrayList of living people
     */
    public void playOneRound(ArrayList<Integer> combatants)
    {
        System.out.println(combatants.size());
        int numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size() - 1;
        int combatantIndex = 0;
        while(combatantIndex < numberOfCombatants)
        {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex+1));
            combatantIndex = combatantIndex + 2;
        }
    }



}
