
package edu.jsu.mcis.cs310.tas_sp22;
import java.time.*;
import java.util.HashMap;

public class Employee 
{
    private String badge, first, middle, last; 
    private int id, employeetypeid, department, shift; 
    private LocalTime active, inactive; 
    
 public Employee(HashMap<String, String> s, HashMap<String, Integer> i, HashMap<String, LocalTime> l)
 {
     this.id = i.get("id");
     this.employeetypeid = i.get("employeetypeid");
     this.department = i.get("department"); 
     this.shift = i.get("shift"); 
     this.badge = s.get("badge"); 
     this.first = s.get("fist"); 
     this.middle = s.get("middle"); 
     this.last = s.get("last"); 
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
 
 public int getDepartment()
 {
     return department; 
 }
 
 public int getShift()
 {
     return shift;
 }
 
 public String getBadge()
 {
     return badge; 
 }
 
 public String getFirst()
 {
     return first; 
 }
 
 public String getMiddle()
 {
     return middle;
 }
 
 public String getLast()
 {
     return last; 
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
     result.append("#").append(id).append(" (").append(last).append(" ").append(first);
     result.append(" ").append(middle).append(") : ").append(employeetypeid).append(", : ");
     result.append(department).append(", : ").append(shift).append(", : ").append(active); 
     result.append(inactive).append(","); 
     
     return result.toString();
 }
}
