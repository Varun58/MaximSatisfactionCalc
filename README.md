#MaximSatisfactionCalc : Approach Taken

#Assumptions Made
The same algo / program has been written taking into consideration that 
1. t can be in minutes
2. t can be in seconds

#Algorithmic Approach for Calculation
Greedy Approach has been followed to calculate the same. We need to get the maximum satisfaction in the given time from certain number of dishes which can be possible by choosing the dish which has maximum satisfaction in minimum time.
There are so many dishes which might have approximate numbers for the satisfaction and the minimum time. In order to decide between the both we need to understand their satisfaction in time ratio which is simply as

SatisfactionInTimeRatio = [Satisfaction Value]/[Time]  

We need to first store the Satisfaction Values for Dishes and calculate the ratio using the above formula.

The list of dishes is then sorted on the basis of the Satisfaction Index , the largest being the first choice. For this we sort the list of dishes based upon the ratio in descending order and start picking up the ones from the start. This takes place through the use of Knapsack Algorithm where we select the dish which gives us maximum satisfaction in minm time.

#Input
Input  to the program contains the three things :
1. The time to eat
2. The number of dishes
3. The list of dishes in the form of Satisfaction Values in time 

Output: Maximum Satisfaction value with comments

#Steps to Create the Same:
1. Create a new Maven Project
2. Configure the Project as a Spring Boot Application by adding dependcies for the boot starter.
3. Add Dependencies for the test starter which would help to run the junit test cases.
4. Add Test files
5. Create Two Classes : Input Reader and Satisfaction Calc.
6. Autowire the same in the Application.java.

#Steps to the Run the same:
1. Run the application by clicking on the file Application.java and Run as Application.
2. Output can be seen on the console.
3. To Run the test cases: 

i) Open the Command Prompt on the Project Working Directory and run the Maven Command : mvn clean test
ii)To Run Individual Test Files , Click on Files having pattern *Tests.java and run as JUNIT Tests.

