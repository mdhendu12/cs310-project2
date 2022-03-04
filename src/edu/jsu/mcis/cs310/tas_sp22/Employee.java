
package edu.jsu.mcis.cs310.tas_sp22;
import java.util.HashMap;

public class Employee 
{
    private String description; 
    private int id; 
    
 public Employee(HashMap<String, String> params, HashMap<String, Integer> larams)
 {
     this.id = larams.get("id");
     this.description= params.get("description"); 
 }
 
 public Integer getId()
 {
     return id;
 }
 
 public String getDescription() 
 {
     return description;          
 
}
 
 @Override
 public String toString()
 {
     StringBuilder result =  new StringBuilder(); 
     result.append("#").append(id).append(" (").append(description).append(")"); 
     return result.toString();
 }
}
