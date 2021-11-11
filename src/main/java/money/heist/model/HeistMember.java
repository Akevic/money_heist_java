package money.heist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HeistMember {
  private String name;
  private String sex;
  private String email;
  private String skills;
  private String mainSkill;
  private String status;
  private Long id;

  public HeistMember() {}

  public HeistMember(String name, String sex, String email, String skills, String mainSkill, String status) {
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }
}
