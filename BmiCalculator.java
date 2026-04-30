import java.util.Scanner;
import java.util.Locale; 

public class BmiCalculator {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		char repeat = 0;
		
		do {
			
			System.out.println("=================================");
            System.out.println("         BMI CALCULATOR          ");
            System.out.println("=================================");
			
			//All our code
			int unitChoice = getUnitChoice(scanner);
			
			//Input
			double weight = (unitChoice == 1) ? getValidInput(scanner, "Enter your weight in kilograms : ", 10, 600)
					: getValidInput(scanner, "Enter your weight in pounds", 22, 1300);
					
			double height = (unitChoice == 1) ? getValidInput(scanner, "Enter your height in meters : ", 0.5, 2.5)
					: getValidInput(scanner, "Enter your height in inches", 20, 100);
			
			double bmi = calculateBMI(unitChoice, weight, height);
			System.out.println("Your BMI is :\n" + bmi);
			
			//Output formatting
			System.out.println("\n------------ RESULT -------------");
            System.out.printf("BMI Value  : %.2f\n", bmi);
            System.out.printf("Category   : %s\n", determineBMICategory(bmi));
            System.out.println("---------------------------------\n");
			
			//Call method
			String category = determineBMICategory(bmi);
			System.out.println("Category:" + category);	
			
			System.out.println("..................................");
			
			
			//Ask user to repeat
			System.out.println("Do you want to calculate again ? (y/n) : ");
			repeat = scanner.next().charAt(0);
			System.out.println();
			
			//repeat = askToRepeat(scanner);
			System.out.println();
		} while (repeat == 'Y' || repeat == 'y');
		System.out.println("Thank you for using the BMI Calculator!");
		scanner.close();
		
		
	}	
	
	// Unit - Matric and Imperial
	public static int getUnitChoice(Scanner scanner) {
		int choice;
		
		while(true){
			System.out.println("Select preffered unit:\n "
					+ "1. Metric (kg, m)\n"
					+ "2. Imperial (lbs, in)\n"
					+ "3. Please select either option 1 or option 2");
			
			if(scanner.hasNextInt()){
				choice = scanner.nextInt();
				if(choice == 1 || choice == 2){
					break;
					
				} else {
					System.out.println("Invalid choice. Please enter either 1 or 2");
				}	
			} else {
				System.out.println("Invalid input. Please enter a number (1 or 2)");
				scanner.next();
			}	
		}
		
		return choice; 
	
	}
	
	public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
		double value;
		
		while(true){
			System.out.println(prompt);
			
			if(scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if(value >= min && value <= max) {
					break;
				} else {
					System.out.println("Please enter a value between %.1f and %.1f.\n " + min + max);
				}
			} else {
				System.out.println("Invalid input. Please enter a value");
				scanner.next();
						
			}
		}
		
		return value;
	}
	
	public static double calculateBMI(int unitChoice, double weight, double height) {
		 double totalBMI;
		 
		if(unitChoice == 1) {
			 totalBMI = weight / (height * height);	 
		} else {
			totalBMI = (703 * weight) / (height / height);
		}
		
		return totalBMI;
	}
	
	public static String determineBMICategory(double bmi) {
		if (bmi < 18.5) {
			return "Underweight: Gain weight in a healthy way - Eat nutrient-dense foods. ";
			//System.out.println("Gain weight in a healthy way : Eat nutrient-dense foods. ");
		} else if (bmi < 25) {
			return "Normal weight : Maintain a healthy lifestyle - Eat a balanced diet. ";	
			//System.out.println("Maintain a healthy lifestyle : Eat a balanced diet. ");
		} else if (bmi < 30) {
			return "Overweight : Gradual weight loss - Reduce intake of processed foods and sugary drinks.";
			//System.out.println("Gradual weight loss : Reduce intake of processed foods and sugary drinks. ");
		} else if (bmi < 35) {
			return "Obese : Improve health and reduce weight safely - Follow a structured eating plan. "; 	
			//System.out.println("Improve health and reduce weight safely : Follow a structured eating plan. ");
		} else {
			return "Severely Obese : Reduce serious health risks - Consult a doctor or dietician for a personalized plan. ";
			//System.out.println("Reduce serious health risks : Consult a doctor or dietician for a personalized plan. ");
			
		}	
	}		
}		
	
	
	
