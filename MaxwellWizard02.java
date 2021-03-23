public class MaxwellWizard02 extends People {


    public MaxwellWizard02(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        String myDescription = "\tMax's Wizard";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

