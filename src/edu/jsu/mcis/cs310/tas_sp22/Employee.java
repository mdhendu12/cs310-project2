
package edu.jsu.mcis.cs310.tas_sp22;
import java.util.HashMap;

public class Employee 
{
    private String id, description; 
    
 public Employee(HashMap<String, String> params)
 {
     this.id = params.get("id");
     this.description= params.get("description"); 
 }
 
 public String getId()
 {
     return id;
 }
 
 public String getDescription() 
 {
     return description;          
 
}
}
