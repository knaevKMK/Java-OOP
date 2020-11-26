package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        Validation.validateName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        Validation.validateInt(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Validation.validateInt(endurance, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Validation.validateInt(endurance, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Validation.validateInt(endurance, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Validation.validateInt(endurance, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return Math.ceil(this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }
}
