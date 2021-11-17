package money.heist.model;

import javax.persistence.*;

@Entity
public class Heist {
  private String name;
  private String location;
  private String startTime;
  private String endTime;
  private String skills;
  private HeistStatus status;
  private Long id;

  public Heist() {}

  public Heist(String name, String location, String startTime, String endTime, String skills, HeistStatus status) {
    this.name = name;
    this.location = location;
    this.startTime = startTime;
    this.endTime = endTime;
    this.skills = skills;
    this.status = status;
  }

  @Enumerated(EnumType.STRING)
  public HeistStatus getStatus() {
    return status;
  }

  public void setStatus(HeistStatus status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
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
