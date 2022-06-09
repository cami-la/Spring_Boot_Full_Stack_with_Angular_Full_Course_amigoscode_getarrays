package tech.getarrays.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Employee implements Serializable {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long id;
  private String name;
  private String email;
  private String jobTitle;
  private String phone;
  private String imageUrl;
  @Column(nullable = false, updatable = false)
  private String employeeCode;

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", jobTitle='" + jobTitle + '\'' +
        ", phone='" + phone + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", employeeCode='" + employeeCode + '\'' +
        '}';
  }
}
