package money.heist.model;

import javax.persistence.*;

@Entity
public class HeistMember {
  private String name;
  private Sex sex;
  private String email;
  private String skills;
  private String mainSkill;
  private Status status;

  private Long id;

  public HeistMember() {}

  public HeistMember(String name, Sex sex, String email, String skills, String mainSkill, Status status) {
    this.name = name;
    this.sex = sex;
    this.email = email;
    this.skills = skills;
    this.mainSkill = mainSkill;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Enumerated(EnumType.STRING)
  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  public String getMainSkill() {
    return mainSkill;
  }

  public void setMainSkill(String mainSkill) {
    this.mainSkill = mainSkill;
  }

  @Enumerated(EnumType.STRING)
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }
}
