
public class Monkey extends RescueAnimal {

	// Instance variable
	private String species;
    private String tailLength;
    private String height;
    private String bodyLength;
    
    

    // Constructor
    public Monkey(String name, String species, String tailLength, 
    String height, String bodyLength, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

    // Accessor Method
    public String getSpecies(String species) {
        return species;
    }
    public String getTailLength(String tailLength) {
    	return tailLength;
    }
    public String getHeight(String height) {
    	return height;
    }
    public String getBodyLength(String bodyLength) {
    	return bodyLength;
    }
    
    // Mutator Method
    public void setSpecies(String monkeySpecies) {
    	species = monkeySpecies;
    }
    public void setTailLength(String t) {
    	tailLength = t;
    }
    public void setHeight(String h) {
    	height = h;
    }
    public void setBodyLength(String b) {
    	bodyLength = b;
    }
}
