public class MaxwellWarrior02 extends People {


    public MaxwellWarrior02(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, person, lifePoints);
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

