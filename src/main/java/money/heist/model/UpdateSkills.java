package money.heist.model;

public class UpdateSkills {
  private String skill;

  public UpdateSkills() {}

  public UpdateSkills(String skill) {
    this.skill = skill;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }
}
