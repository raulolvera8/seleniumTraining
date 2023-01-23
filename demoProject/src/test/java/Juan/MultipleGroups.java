package Juan; 
import org.testng.annotations.Test; 
public class MultipleGroups
{ 
@Test(groups={"Group1"}) 
public void atom() 
{ 
  System.out.println("Smallest particle"); 
} 
@Test(groups = {"Group1", "Group2"}) // The test method "electron" belongs to two groups, Group1 and Group2. 
public void electron()
{ 
  System.out.println("Negative charged particle"); 
} 
@Test(groups = {"Group2"}) 
public void proton()
{ 
  System.out.println("Positive charged particle"); 
} 
@Test(groups = {"Group2"}) 
public void neutron()
{ 
   System.out.println("Neutral particle"); 
 } 
}