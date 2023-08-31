create database quiz_database;
use quiz_database;

create table questions(
id int auto_increment primary key,
question text,
option1 text,
option2 text,
option3 text,
option4 text,
correct_option_index int
);

insert into questions(question,option1,option2,option3,option4,correct_option_index) values
("1. Who invented Java Programming?","Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup",2),
("2. Number of primitive data types in Java are ?","6","7","8","9",3),
("3. What is the size of float and double in java?","32 and 64","32 and 32","64 and 64","64 and 32",1),
("4. Automatic type conversion is possible in which of the possible cases?","byte to int","int to long","long to int","short to int",2),
("5. When an array is passed to a method, what does the method receive?","The reference of the array","A copy of the array","Length of the array","Copy of first element",1),
("6. Select the valid statement to declare and initialize an array.","int[ ] A={}","int[ ] A={1,2,3}","int[ ] A=(1,2,3)","int[ ][ ]A={1,2,3}",2),
("7. Arrays in java are-","Object references","Objects","Primitive Data type","None",2),
("8. When is the object created with new keyword?","At run time","At compile time","Depends on code","None",1),
("9. In which of the following is toString() method defined?","java.lang.Object","java.lang.String","java.lang.util","None",1),
("10. Identify the return type of a method that does not return any value.","int","void","double","none",2),
("11. Identify the modifier which cannot be used for constructor.","public","protected","private","static",4),
("12. What is the variables declared in a class for the use of all methods of the class called?","Object","Instance Variable","Reference Variable","None",2),
("13. What is the implicit return type of constructor?","No return type","A class in which it is defined","void","None",2),
("14. When is the finalize() method called?","Before garbage collection","Before object goes out of scope","Before variable goes out of scope","None",1),
("15. What is Runnable?","Abstract Class","Interface","Class","Method",2),
("16. Exception created by try block is caught in which block","catch","throw","final","none",1),
("17. Which of the following exception is thrown when divided by zero statement is executed?","NullPointerException","NumberFormatException","ArithmeticException","None",3),
("18. Which of the following is a superclass of every class in Java? ","ArrayList","Abstract class","Object class","String",3 ),
("19. Which of these keywords is used to define interfaces in Java? ","intf","Intf","interface","Interface",3),
("20. Which of these are selection statements in Java? ","break","continue","for()","if()",4);






