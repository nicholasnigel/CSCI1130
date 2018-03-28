class Employee {
  // two fields in the object
  public int    salary;
  public String name;

  // constructor version 1
  Employee()
  {
    name   = "Anonymous";
    salary = 10000;
  }
  
  // constructor version 2
  Employee(String new_name)
  {
    name   = new_name;
    salary = 10000;
  }
}
