
package edu.jsu.mcis.cs310.tas_sp22;
import java.time.*;
import java.util.HashMap;

public class Employee 
{
    private String badgeid, firstname, middlename, lastname; 
    private int id, employeetypeid, departmentid, shiftid; 
    private LocalTime active, inactive; 
    
 public Employee(HashMap<String, String> s, HashMap<String, Integer> i, HashMap<String, LocalTime> l)
 {
     this.id = i.get("id");
     this.employeetypeid = i.get("employeetypeid");
     this.departmentid = i.get("department"); 
     this.shiftid = i.get("shift"); 
     this.badgeid = s.get("badge"); 
     this.firstname = s.get("fist"); 
     this.middlename = s.get("middle"); 
     this.lastname = s.get("last"); 
     this.active = l.get("active"); 
     this.inactive = l.get("inactive"); 
 }
 
 public int getId()
 {
     return id;
 }
 
 public int getEmployeetypeid()
 {
     return employeetypeid;
 }
 
 public int getDepartmentid()
 {
     return departmentid; 
 }
 
 public int getShiftid()
 {
     return shiftid;
 }
 
 public String getBadge()
 {
     return badgeid; 
 }
 
 public String getFirst()
 {
     return firstname; 
 }
 
 public String getMiddle()
 {
     return middlename;
 }
 
 public String getLast()
 {
     return lastname; 
 }
 
 public LocalTime getActive()
 {
     return active;
 }
 
 public LocalTime getInactive()
 {
     return inactive;
 }
 
 
 @Override
 public String toString()
 {
     StringBuilder result =  new StringBuilder(); 
     result.append("#").append(badgeid).append("(").append(lastname).append(", ").append(firstname);
     result.append(" ").append(middlename).append("): employeetypeid: ").append(employeetypeid);
     result.append(", departmentid: ").append(departmentid).append(", shiftid: ").append(shiftid); 
     result.append(shiftid).append(", active: ").append(active).append(", inactive: ").append(inactive);
     return result.toString();
 }
}
