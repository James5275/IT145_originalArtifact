import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>(); //Dog Array List
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); //Monkey Array List 
    static char userChoice; // user choice on the main menu
   

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	initializeDogList();
        initializeMonkeyList();
        
        while(true) { // loop that displays the menu and accepts user input.
        	displayMenu();
        	userChoice = scanner.next().charAt(0);
        	
        	if(userChoice == '1') { // in take new dog 
        		intakeNewDog(scanner);       		
        	}
        	else if(userChoice == '2') { // in take new monkey
        		intakeNewMonkey(scanner);        		
        	}
        	else if(userChoice == '3') { //reserve animal 
        		reserveAnimal(scanner);
        	}
        	else if((userChoice == '4') || (userChoice == '5') || (userChoice == '6')) { //Print statement options 
        		printAnimals();
        	}
        	else if(userChoice == 'q') { // input for Quit 
        		System.out.println("QUIT");
        		break;
        	}
        	else { // input validation if its anything else (output message)
        		System.out.println("invalid answer, please select 1-6 or q");
        	}
        }
       
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // dog list 
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019",
        		"United States", "in service", false, "England");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", 
        		"United States", "in service", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", 
        		"Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // monkey list
    public static void initializeMonkeyList() {
    	//list of test monkeys
    	Monkey monkey1 = new Monkey("Bobo", "Capuchin", "22", "30", "35", "male", "4", "55", "07-27-2019", 
    			"United States", "in service", false, "england");
    	Monkey monkey2 = new Monkey("George", "Macaque","20", "26", "32", "male", "1", "54", "04-27-2020", 
    			"United States", "in service", false, "United States");
    	Monkey monkey3 = new Monkey("Stella", "Marmoset","24", "28", "36", "female", "2", "45", "07-19-2021", 
    			"Canada", "In service", true, "Canada");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    	
    }

    //in take a new dog
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.next();
        
        for(Dog dog: dogList) { // checking to see if dog is already in list
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nthis dog is already in our system\n");
                System.out.println("Would you like to update the training status?");
                scanner.nextLine();
                String updateStatus = scanner.nextLine();
                if(updateStatus.equalsIgnoreCase("yes")) {
                	System.out.println("What is the new training status?");
                	String newStatus = scanner.nextLine();
                	dog.setTrainingStatus(newStatus);
                }
                else {
                	return;
                }
                return; //returns to menu
            }
        }
        // if dog isn't in the list (gathering information to be added)
        scanner.nextLine();
        
        System.out.println("What is " + name + "'s breed?"); //breed
        String breed = scanner.nextLine();
        
        System.out.println("What is " + name + "'s gender?");//gender
        String gender = scanner.nextLine();
        
        System.out.println("What is " + name + "'s age?");//age
        String age = scanner.nextLine();
        
        System.out.println("What is " + name + "'s weight");//weight
        String weight = scanner.nextLine();
        
        System.out.println("What is " + name + "'s acquisition date?");//Acquisition date
        String acquisitionDate = scanner.nextLine();
        

        System.out.println("What is " + name + "'s acquisition country"); //Acquisition Country
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("What is " + name + "'s training status"); //Training Status 
        String trainingStatus = scanner.nextLine(); 
        
        
        System.out.println("Is " + name + " reserved? (true or false)"); // Reserved 
        String booleanInput = scanner.nextLine();
        if(booleanInput.equalsIgnoreCase("true")) {
        	boolean reserved = true;
        	
            System.out.println("What is " + name + "'s in service country"); // Service Country
            String inServiceCountry = scanner.nextLine();
           
            Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            
            dogList.add(newDog); // adding dog to dogList
            
            System.out.println("Thank you for adding " + name);
            return;
        }
        else if(booleanInput.equalsIgnoreCase("false")) {
        	boolean reserved = false;
        	
            System.out.println("What is " + name + "'s in service country"); // Service Country
            String inServiceCountry = scanner.nextLine();
           
            Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            
            dogList.add(newDog); // adding dog to dogList
            
            System.out.println("Thank you for adding " + name);
            return;
        }
        else {
        	while(true) {
        		System.out.println("that is not a valid response");
        		System.out.println("Is " + name + " reserved? (true or false)"); // Reserved 
        		booleanInput = scanner.nextLine();
                if(booleanInput.equalsIgnoreCase("true")) {
                	boolean reserved = true;
                	
                    System.out.println("What is " + name + "'s in service country"); // Service Country
                    String inServiceCountry = scanner.nextLine();
                   
                    Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                    
                    dogList.add(newDog); // adding dog to dogList
                    
                    System.out.println("Thank you for adding " + name);
                    return;
                }
                else if(booleanInput.equalsIgnoreCase("false")) {
                	boolean reserved = false;
                	
                    System.out.println("What is " + name + "'s in service country"); // Service Country
                    String inServiceCountry = scanner.nextLine();
                   
                    Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                    
                    dogList.add(newDog); // adding dog to dogList
                    
                    System.out.println("Thank you for adding " + name);
                    return;
                }
        		
        	}
        }
    }
    
    //in take a new monkey
    public static void intakeNewMonkey(Scanner scanner) {
    	System.out.println("What is the Monkey's name?");
        String name = scanner.next();
        
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) { //Checking to see if monkey is already in list
            	System.out.println("\nthis monkey is already in our system\n");
                System.out.println("Would you like to update the training status?");
                scanner.nextLine();
                String updateStatus = scanner.nextLine();
                if(updateStatus.equalsIgnoreCase("yes")) {
                	System.out.println("What is the new training status?");
                	String newStatus = scanner.nextLine();
                	monkey.setTrainingStatus(newStatus);
                }
                else {
                	return;
                }
                return; //returns to menu
            }
        }
        System.out.println("What is " + name + "'s" + " species");
        scanner.nextLine();
        String species = scanner.nextLine();
            // make sure species type is allowed
        	if((species.equalsIgnoreCase("Capuchin"))||(species.equalsIgnoreCase("Guenon"))||(species.equalsIgnoreCase("Macaque"))||
            		(species.equalsIgnoreCase("Marmoset"))||(species.equalsIgnoreCase("Tamarin"))||
            		(species.equalsIgnoreCase("Squirrel Monkey"))) {
        		
            	//Collecting information if its an acceptable Species
        		System.out.println("What is " + name + "'s" + " tail Length"); // Tail Length
                String taillength = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " height"); // Height
                String height = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " body length"); // Body Length
                String bodyLength = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " gender"); // Gender
                String gender = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " age"); // Age 
                String age = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " weight"); // Weight
                String weight = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " acquisition date"); //Acquisition date
                String acquisitionDate = scanner.nextLine();
                
                System.out.println("What is " + name + "'s" + " acquisition country"); //Acquistion country
                String acquisitionCountry = scanner.nextLine();
                        
                System.out.println("What is " + name + "'s" + " training status"); // Training Status
                String trainingStatus = scanner.nextLine();
               
                System.out.println("Is " + name + " reserved? (true or false)"); // Reserved 
                String booleanInput = scanner.nextLine();
                if(booleanInput.equalsIgnoreCase("true")) {
                	boolean reserved = true;
                	
                	System.out.println("What is " + name + "'s" + " in service country"); // Service Country
                    String inServiceCountry = scanner.nextLine();
                            
                    Monkey newMonkey = new Monkey(name, species, taillength, height, bodyLength, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                    monkeyList.add(newMonkey); // adding Monkey to monkeyList
                    
                    System.out.println("Thank you for adding " + name);
                    return;
                }
                else if(booleanInput.equalsIgnoreCase("false")) {
                	boolean reserved = false;
                	
                	System.out.println("What is " + name + "'s" + " in service country"); // Service Country
                    String inServiceCountry = scanner.nextLine();
                            
                    Monkey newMonkey = new Monkey(name, species, taillength, height, bodyLength, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                    monkeyList.add(newMonkey); // adding Monkey to monkeyList
                    
                    System.out.println("Thank you for adding " + name);
                    return;
                }
                else {
                	while(true) {
                		System.out.println("that is not a valid response");
                		System.out.println("Is " + name + " reserved? (true or false)"); // Reserved 
                		booleanInput = scanner.nextLine();
                        if(booleanInput.equalsIgnoreCase("true")) {
                        	boolean reserved = true;
                        	
                        	System.out.println("What is " + name + "'s" + " in service country"); // Service Country
                            String inServiceCountry = scanner.nextLine();
                                    
                            Monkey newMonkey = new Monkey(name, species, taillength, height, bodyLength, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                            monkeyList.add(newMonkey); // adding Monkey to monkeyList
                            
                            System.out.println("Thank you for adding " + name);
                            return;
                        }
                        else if(booleanInput.equalsIgnoreCase("false")) {
                        	boolean reserved = false;
                        	
                        	System.out.println("What is " + name + "'s" + " in service country"); // Service Country
                            String inServiceCountry = scanner.nextLine();
                                    
                            Monkey newMonkey = new Monkey(name, species, taillength, height, bodyLength, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                            monkeyList.add(newMonkey); // adding Monkey to monkeyList
                            
                            System.out.println("Thank you for adding " + name);
                            return;
                        }
                	}
                }
            }
            else {
            	System.out.println("Species ist't accepted"); //Telling user its not acceptable if species isn't acceptable
            }
           
    }

    //Reserve an animal
    public static void reserveAnimal(Scanner scanner) {
    	System.out.println("What animal type would you like to reserve?"); // asking type of animal
        String animalType = scanner.next();
        
        // If its a monkey to be reserved
        if (animalType.equalsIgnoreCase("monkey")) { 
        	scanner.nextLine();
        	System.out.println("What is the in service country?"); //asking country 
            String inServiceCountry = scanner.nextLine();
            for(Monkey monkey: monkeyList) { // checking to see if a monkey is available
                if((monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) && (monkey.getReserved() == false) && 
                		(monkey.getTrainingStatus().equalsIgnoreCase("in service"))) { 
                	System.out.println(monkey.getName() + " is avaliable");
                	System.out.println("\nWould you like to reserve this monkey?"); // asking to reserve monkey
                	String reserveAnswer = scanner.next();
                	if(reserveAnswer.equalsIgnoreCase("yes")) { // input validation for yes
                		monkey.setReserved(true);
                        System.out.println("You have reserved " + monkey.getName());
                	}
                	else if (reserveAnswer.equalsIgnoreCase("no")) { // input validation for no 
                		System.out.println("Okay, Ill take you back to the main menu");
                	}
                	else {
                		while(true) { // input validation for anything else besides yes or no
                        	System.out.println("That is an invalid response, please answer (yes or no)");
                        	System.out.println(monkey.getName());
                        	System.out.println("Would you like to reserve this monkey?");
                        	reserveAnswer = scanner.next();
                        	if(reserveAnswer.equalsIgnoreCase("yes")) {
                        		monkey.setReserved(true);
                            	System.out.println("You have reserved " + monkey.getName());
                            	break;
                        	}
                        	else if (reserveAnswer.equalsIgnoreCase("no")){
                        		System.out.println("Okay, I'll bring you back to the main menu");
                        		break;
                        	}
                		}
                	}
                	return;
                }
            }
            System.out.println("We don't have any avaliable monkeys in service in that country"); // output if there isn't a monkey available
        }
            
        else if (animalType.equalsIgnoreCase("dog")) { // if dog is animal type 
            scanner.nextLine();
            System.out.println("What is the in service country?");
            String inServiceCountry = scanner.nextLine();
            for(Dog dog: dogList) { // checking to see if there is an available dog
            	if((dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) && (dog.getReserved() == false) && 
            			(dog.getTrainingStatus().contentEquals("in service"))) { 
            		System.out.println(dog.getName());
            		System.out.println("Would you like to reserve this dog?");
                    String reserveAnswer = scanner.next();
                    if(reserveAnswer.equalsIgnoreCase("yes")) { // input validation for yes
                    	dog.setReserved(true);
                    	System.out.println("You have reserved " + dog.getName());
                    }
                    else if (reserveAnswer.equalsIgnoreCase("no")){ // input validation for no
                    	System.out.println("Okay, I'll bring you back to the main menu");
                    }
                    else {
                    	while(true) { // input validation if not yes or no
                    		System.out.println("That is an invalid response, please answer (yes or no)");
                    		System.out.println(dog.getName());
                    		System.out.println("Would you like to reserve this Dog?");
                    		reserveAnswer = scanner.next();
                    		if(reserveAnswer.equalsIgnoreCase("yes")) {
                    			dog.setReserved(true);
                        		System.out.println("You have reserved " + dog.getName());
                        		break;
                    		}
                    		else if (reserveAnswer.equalsIgnoreCase("no")){
                    			System.out.println("Okay, I'll bring you back to the main menu");
                    			break;
                    		}
                    	}
                    }
                    return;
            	}
            } 
            System.out.println("We don't have any avaliable dogs in service in that country"); // output if there isn't any dogs available
        }
        else {
            System.out.println(animalType + " is an invalid animal, we currently only have Dogs and Monkeys " // output if its not monkey or dog
            		+ "that can be reserved!");
        }
    }
    
    //print animal outputs
    public static void printAnimals() {
    	if(userChoice == '4') {
    		//Print full list of dogs
    		System.out.println("List of all dogs: ");
    		// Include the animal name, status, acquisition country and if the animal is reserved.
    		for(Dog dog: dogList) {
    			System.out.println(dog.getName() + " - Training Status: " + dog.getTrainingStatus() + ", Acquisition Country: " +
    		dog.getAcquisitionLocation() + ", In service location: " + dog.getInServiceLocation() + ", reserved: " + dog.getReserved());
            }
    	}
    	else if (userChoice == '5') {
    		//Print full list of Monkeys 
    		System.out.println("List of all monkeys: ");
    		// Include the animal name, status, acquisition country and if the animal is reserved.
    		for (Monkey monkey: monkeyList) {
    			System.out.println(monkey.getName() + " - Training Status: " + monkey.getTrainingStatus() + ", Acquisition Country: " + 
    		monkey.getAcquisitionLocation() + ", In service location: " + monkey.getInServiceLocation() + ", reserved: " + monkey.getReserved());
    		}	
    	}
    	else if(userChoice == '6') {
    		// available - prints a combined list of all animals that are
    	    // fully trained ("in service") but not reserved 
    		System.out.println("List of all animials avaliable: ");
    		System.out.println("Monkey: " );
    		for (Monkey monkey: monkeyList) {
    			if((monkey.getReserved() == false) && (monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
    				System.out.println(monkey.getName());
    			}
    		}
    		System.out.println("\nDog: " );
    		for (Dog dog: dogList) {
    			if((dog.getReserved() == false) && (dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
    					System.out.println(dog.getName());
    			}
    		}
    	}
    }
}

