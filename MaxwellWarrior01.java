public class MaxwellWarrior01 extends People {


    public MaxwellWarrior01(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        String myDescription = "\tMax's Warrior";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

