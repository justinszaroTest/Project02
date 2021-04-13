
public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    cleric ("Healer"),
    angel ("Angel"),
    reaper ("Death"),
    TheFlash("The Flash"),
    curse ("Curse");

    private final String description;

    PeopleType (String types)
    {
        description = types;
    }

    public String getDescription()
    {
        return description;
    }
}
