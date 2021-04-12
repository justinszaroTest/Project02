public class DeathArtifact extends People{

    public DeathArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.reaper, lifePoints);
        myDescription = "\tDeath";
    }
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
