package assignment7;

public class Student {
	
	//instance variables
	//Should be marked private because they force the user to use methods (more organization)
		//organization, makes it so it can only be accessed within the class which limits any issues 
	private String firstName;
	private String lastName;
	private int studentID;
	private int totalPassingCredits;
	private int totalAttemptedCredits;
	private double qualityPoints;
	private double bearBucks;
	
	
	
	//default constructor
	public Student() {
		
		
	}
	
	//constructor
	public Student(String firstName, String lastName, int studentID) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	
	
	
	/**
	 * Sets qualityPoints.
	 * @param qualityPoints credits multiplied by the grade points
	 */
	public void setQualityPoints(int qualityPoints) {
		this.qualityPoints = qualityPoints;
	}
	
	/**
	 * Sets totalPassingCredits.
	 * @param totalPassingCredits passing credits, credits for which the student 
	 * received at least a 1.7 grade
	 */
	public void setTotalPassingCredits(int totalPassingCredits) {
		this.totalPassingCredits = totalPassingCredits;
	}
	
	/**
	 * Sets totalAttemptedCredits.
	 * @param totalAttemptedCredits total credits attempted (passing or failed)
	 */
	public void setTotalAttemptedCredits(int totalAttemptedCredits) {
		this.totalAttemptedCredits = totalAttemptedCredits;
		
	}
	
	/**
	 * Sets bearBucks balance.
	 * @param bearBucks represents how many Bear Bucks (WashU Currency) you have in balance.  
	 */
	public void setBearBucksBalance(double bearBucks) {
		this.bearBucks = bearBucks;
	}
	
	
	
	/**
	 * Gets students full name.
	 * @return Students first and last name 
	 */
	public String getFullName() {
		
		return this.firstName + " " + this.lastName; 
		
	}
	
	/**
	 * Gets students WashU ID.
	 * @return WashU ID  
	 */
	public int getId() {
		
		return this.studentID;
		
	}
	
	/**
	 * Gets quality points.
	 * @return quality points (credits multiplied by grade points)  
	 */
	public double getQualityPoints() {
		return this.qualityPoints;
	}

	/**
	 * Gets total attempted credits. 
	 * @return total attempted credit (no matter passing or failing)  
	 */
	public int getTotalAttemptedCredits() {
		
		return this.totalAttemptedCredits;
		
	}
	
	/**
	 * Gets total passing credits. 
	 * @return total passing credits (where student got a 1.7 and up)  
	 */
	public int getTotalPassingCredits() {
		
		return this.totalPassingCredits;
	}
	
	
	/**
	 * Gets your class standing depending on many credits you have earned. 
	 * First year - less than 30
	 * Sophomore - 30 to 59
	 * Junior - 60  to 89 
	 * Senior - 90+
	 * @return class standing (first year, sophomore, junior, senior)
	 */
	public String getClassStanding() {
		
		String classStanding = "";
		
		if(this.getTotalPassingCredits() < 30)
		{
			classStanding = "First Year";
		}
		else if(this.getTotalPassingCredits() >= 30 && this.getTotalPassingCredits() < 60)
		{
			classStanding = "Sophomore";
		}
		else if(this.getTotalPassingCredits() >= 60 && this.getTotalPassingCredits() < 90)
		{
			classStanding = "Junior";
		}
		else
		{
			classStanding = "Senior";
		}
		
		return classStanding;
	}
	
	/**
	 * Gets students bear buck balance. 
	 * @return bear bucks balance (WashU currency) 
	 */
	public double getBearBucksBalance() {
		
		return this.bearBucks;
		
	}
	
	//Methods
	
	
	/**
	 *  this method takes in a course grade (as a value between 0 and 4) and the number of credits 
	 *  for a course, and updates the students GPA accordingly.
	 * 
	 * @param grade students grade (in terms of points)
	 * @param credits the number of credits for a course
	 */
	public void submitGrade(double grade, int credits) {
		
		this.qualityPoints += grade * credits;
		this.totalAttemptedCredits += credits;
		
			if(grade >= 1.7)
			{
				this.totalPassingCredits += 1;
			}
	}
	
	
	/**
	 * Returns the GPA. GPA is computed as the sum of all of the quality points for each course the student has taken 
	 * divided by the total number of attempted credits. 
	 * 
	 * @return Students GPA (quality points divided by total attempted credits)
	 */
	public double calculateGradePointAverage() {
		
		
		return (this.qualityPoints/this.getTotalAttemptedCredits());
		
		
	}
	
	/**
	 * Determines if the student is eligible  for PhiBetaKappa. A student who has completed at least 98 credits with a cumulative GPA of at least 3.60 
	 * and a student who has completed at least 75 credits with a cumulative GPA of at least 3.80 is eligible.
	 * @return true if eligible, false if not eligible 
	 */
	public boolean isEligibleForPhiBetaKappa() {
	
		boolean isEligible = false;
		if(this.getTotalAttemptedCredits() >= 98 && this.calculateGradePointAverage() >= 3.60)
		{
			isEligible = true;
		}
		else if(this.getTotalAttemptedCredits() >= 75 && this.calculateGradePointAverage() >= 3.80)
		{
			isEligible = true;
		}
		else
		{
			isEligible = false;
		}
		
		return isEligible;
		
	}
	
	/**
	 * Increases the Bear Bucks balance by amount you want
	 * 
	 * @param amount the amount of money they want to add to their account.  
	 */
	public void depositBearBucks(double amount) {
		
		this.bearBucks = this.bearBucks + amount;
		
	}
	
	
	/**
	 * Decreases the Bear Bucks balance by amount
	 * 
	 * @param amount the amount of money they want to take out of their their account.  
	 */
	public void deductBearBucks(double amount) {
		
		this.bearBucks = this.bearBucks - amount;
	}

	
	/**
	 * Zero out the Bear Bucks balance and return the appropriate amount as (previously) 
	 * specified in the Terms of Service for Bear Bucks
	 * 
	 * @return the amount of bear bucks they had in their account after fees and such 
	 */
	public double cashOutBearBucks() {
		
		double refund = 0.0;
		
		if(this.getBearBucksBalance() > 10)
		{
			refund = this.getBearBucksBalance() - 10.0;
			this.setBearBucksBalance(0.0);
		}
		else
		{
			refund = 0.0;
			this.setBearBucksBalance(0.0);
		}
		
		return refund;
	}
	
	
	
	/**
	 * Makes a legacy child and transfers parents unused Bear Bucks (with fees and everything taken out) 
	 * to a legacy.
	 * @param first name first name of the person
	 * @param other the other parent that went to WashU
	 * @param isHypendated checks if students last name should be hyphenated
	 * @param id persons id 
	 * @return legacy child
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
	
		//Student parent1 = new Student(this.firstName,this.lastName,this.studentID);
		
		String studentlastName = "";
		
		if(isHyphenated == true)
		{
			studentlastName = this.lastName + "-" + other.lastName;
		}
		else
		{
			studentlastName = this.lastName;
		}
		
		Student child = new Student(firstName,studentlastName,id);	
		
		child.depositBearBucks(this.cashOutBearBucks());
		child.depositBearBucks(other.cashOutBearBucks());
				
		return child;
		
	}
	
	/**
	 * Returns the students full name and student ID
	 * 
	 * @retrun students full name and student ID   
	 */
	public String toString() {
		
		return this.firstName + " " + this.lastName +  " " + this.studentID;
	}
	
}