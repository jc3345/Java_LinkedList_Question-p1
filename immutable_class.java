/**
* @author      Jiachao Chen <jc3345@cornell.edu>

*<p>
* what is an immutable class: 
* 1. Immutable class means that once an object is created, we cannot change its content.
* 2. The class must be declared as final 
* 3. Data members in the class must be declared as final
* 4. A parameterized constructor
* 5. Getter method for all the variables in it and No setters
* Reference: retrieved from GeeksforGeeks: https://www.geeksforgeeks.org/create-immutable-class-java/
*<p>


 */


public final class Cars { 
    final String type; 
    final String name;
    final int price; 
  
    Cars(String type, String name, int price) { 
        this.type = type; 
        this.name = name;
        this.prqice = price; 
    } 

    public String getType() { 
        return type; 
    }

    public String getName() { 
        return name; 
    } 

    public int getPrice() { 
        return price; 
    } 
} 
