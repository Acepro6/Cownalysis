/*
 * CMPT270 T27 Cow Class
 */
package com.example.demo.DataClasses;

 import com.example.demo.Enums.Category;
 import com.example.demo.Enums.Gender;

 import java.text.SimpleDateFormat;
 import java.time.Period;
 import java.time.format.DateTimeFormatter;
 import java.util.ArrayList;
 import java.time.LocalDate;
 import java.util.Locale;

@SuppressWarnings("GrazieInspection")
public class Cow
 {
    // Attributes for Cow objects
    private String ID;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Category category;

    private ArrayList<Weight> weightRecords;
    private ArrayList<MedProc> medicalHistory;
    private Cow dam;
    private Cow sire;
    private ArrayList<Cow> children;
    private ArrayList<String> childrenIDs;
    private Herd herd;
    private Gender gender;
    private String farmTag;

    private ArrayList<FieldData> locations;


     public Cow(String ID, String farmTag, LocalDate dateOfBirth, Category category, Cow dam, Cow sire, Herd herd, Gender gender) {
         this.ID = ID;
         this.dateOfBirth = dateOfBirth;
         this.category = category;
         this.weightRecords = new ArrayList<>();
         this.medicalHistory = new ArrayList<>();
         this.dam = dam;
         this.sire = sire;
         this.children = new ArrayList<>();
         this.herd = herd;
         this.gender = gender;
         this.farmTag = farmTag;
         this.locations = new ArrayList<>();
     }

     public Gender getGender() {
         return this.gender;
     }

     public String getID() {
         return ID;
     }

     public void setID(String ID) {
         this.ID = ID;
     }

     public LocalDate getDateOfBirth() {
         return dateOfBirth;
     }

     public LocalDate getDateOfDeath() {return dateOfDeath;}

     public void setDateOfBirth(LocalDate dateOfBirth) {
         //Can only work if it's before the DOD
         if(dateOfBirth != null && dateOfBirth.isBefore(this.dateOfDeath)){
             this.dateOfBirth = dateOfBirth;
         }

     }

     public void setDateOfDeath(LocalDate d) {
         //Can only work if it's after the DOB
         if(d != null && d.isAfter(this.dateOfBirth)){
             this.dateOfDeath = d;
         }

         }

     public Category getCategory() {
         return category;
     }
     public String getGenderString() {
         String stri = gender.name().toLowerCase();
         String cap = stri.substring(0, 1).toUpperCase() + stri.substring(1);
         return cap;
     }
     public String getCategoryString() {
         String str = category.name().toLowerCase();
         String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
         return cap;
     }
    public String getFarmTag() {
         return farmTag;
    }
    public int getAge() {
         LocalDate currentDate = LocalDate.now();
         if ((this.dateOfBirth != null) && (currentDate != null)) {
             int value = Period.between(dateOfBirth, currentDate).getYears();
             return value;
         }
         else {
             return 0;
         }
    }
    public String getBirthdateString() {
        if (dateOfBirth != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            String formattedDate = formatter.format(dateOfBirth);
            return formattedDate;
        }
        else {
            return null;
        }
    }
     public String getDeathdateString() {
         if (dateOfDeath != null){
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
             String formattedDate = formatter.format(dateOfDeath);
             return formattedDate;
         }
         else {
             return null;
         }
     }
    public boolean isDead() {
         if (this.dateOfDeath == null) {
             return false;
         } else {
             return true;
         }
    }
    public String getCurrentLocationString() {
         if (herd != null) {
             return herd.getLocation();
         }
         else {
             return "No Location Data";
         }
    }
    public String getCurrentWeightString() {
         if (!weightRecords.isEmpty()) {
             return Float.toString(weightRecords.get(0).getWeight());
         }
         else {
             return "No Weight Data";
         }
    }

    public double getCurrentWeight() {
         if (weightRecords.isEmpty()) {
             return -1;
         }
         return weightRecords.get(0).getWeight();} // probably need a null check
    public String getLastMedicalTreatmentString() {
         return "Vaccination: Mad Cow";
    }
     public void setCategory(Category category) {
         this.category = category;
     }

     public ArrayList<Weight> getWeightRecords() {
         return weightRecords;
     }

     public void setWeightRecords(ArrayList<Weight> weightRecords) {
         this.weightRecords = weightRecords;
     }

     public void addWeightRecord(Weight w) {
         this.weightRecords.add(w);
     }

     public ArrayList<MedProc> getMedicalHistory() {
         return medicalHistory;
     }

     public void addToMedicalHistory(MedProc medicalHistory) {
         this.medicalHistory.add(medicalHistory);
     }

     public Cow getDam() {
         return dam;
     }

     public void setDam(Cow dam) {
         this.dam = dam;
     }

     public Cow getSire() {
         return sire;
     }

     public void setSire(Cow sire) {
         this.sire = sire;
     }

     public ArrayList<Cow> getChildren() {
         return children;
     }

     public void addChild(Cow child) {
         this.children.add(child);
     }

     public Herd getHerd() {
         return herd;
     }

     public void setHerd(Herd herd) {
         if (herd != null) {
             this.herd = herd;
             this.herd.addCow(this);
         }
     }

     public static void test_cowClass(){

         //public Cow(String ID, String farmTag, LocalDate dateOfBirth, Category category, Cow dam, Cow sire, Herd herd, Gender gender) {
         //

         //MAKING FIRST TEST COW:
         String ID = "1234";
         String farmTag = "5678";
         LocalDate DOB = LocalDate.of(2018, 1, 1);

         Cow testCow1 = new Cow(ID, farmTag, DOB, Category.COW, null, null, null, Gender.FEMALE);

         //Test getters
         if(!testCow1.getID().equals(ID)){
             System.out.println("ID is incorrect for testCow1 calling " +
                     "getID() - got " + testCow1.getID());
         }

         if(!testCow1.getFarmTag().equals(farmTag)){
             System.out.println("farmtag is incorrect for testCow1 calling " +
                     "getfarmtag - got " + testCow1.getFarmTag());
         }

         if(!testCow1.getDateOfBirth().equals(DOB)){
             System.out.println("DOB is incorrect for testCow1 calling " +
                     "getDOB - got " + testCow1.getDateOfBirth());
         }

         if(!testCow1.getCategoryString().equals("Cow")){
             System.out.println("Category is incorrect for testCow1 calling " +
                     "getCategoryString - got " + testCow1.getCategoryString());
         }

         if(!testCow1.getCategory().equals(Category.COW)){
             System.out.println("Category is incorrect for testCow1 calling " +
                     "getCategory - got " + testCow1.getCategory());
         }


         if(testCow1.getHerd() != null){
             System.out.println("Herd is incorrect for testCow1 calling " +
                     "getHerd - got " + testCow1.getHerd());
         }

         if(testCow1.getSire() != null){
             System.out.println("Sire is incorrect for testCow1 calling " +
                     "getSire - got " + testCow1.getSire());
         }


         if(testCow1.getDam() != null){
             System.out.println("Dam is incorrect for testCow1 calling " +
                     "getDam - got " + testCow1.getDam());
         }

         if(!testCow1.getGenderString().equals("Female")){
             System.out.println("Gender is incorrect for testCow1 calling " +
                     "getGenderString - got " + testCow1.getGenderString());
         }

         if(!testCow1.getGender().equals(Gender.FEMALE)){
             System.out.println("Gender is incorrect for testCow1 calling " +
                     "getGender - got " + testCow1.getGender());
         }





         //Done testing the basic constructor stuff -
         // We have to start setting the other stuff manually
         // if we want to test it:

         //Testing setters too now:

         //First, a real test of setting the DOD,
         //Then we try one that's before the DOB
         LocalDate DOD = LocalDate.of(2019, 1, 1);
         testCow1.setDateOfDeath(DOD);

         if(!testCow1.getDateOfDeath().equals(DOD)){
             System.out.println("DOD is incorrect for testCow1 calling " +
                     "getDOD - got " + testCow1.getDateOfDeath());
         }

         //Set DOD to a new thing:
         LocalDate DOD2 = LocalDate.of(2017, 1, 1);
         testCow1.setDateOfDeath(DOD2);

         if(testCow1.getDateOfDeath().equals(DOD2)){
             System.out.println("DOD is incorrect, it shouldn't be before the DOb -  for testCow1 calling " +
                     "getDOD - got " + testCow1.getDateOfDeath());
         }

         //Test for if the setDOD method can handle null
         testCow1.setDateOfDeath(null);

         if(testCow1.getDateOfDeath() == null){
             System.out.println("getDOD is incorrect, null should be handled -  for testCow1 calling " +
                     "getDOD - got " + testCow1.getDateOfDeath());
         }

         //Test for if the setDOB method can handle null
         testCow1.setDateOfBirth(null);

         if(testCow1.getDateOfBirth() == null){
             System.out.println("getDOB is incorrect, null should be handled -  for testCow1 calling " +
                     "getDOB - got " + testCow1.getDateOfBirth());
         }

         //Testing a DOB after the DOD:

         LocalDate DOB2 = LocalDate.of(2022, 1, 1);
         testCow1.setDateOfBirth(DOB2);

         if(testCow1.getDateOfBirth().equals(DOB2)){
             System.out.println("DOB is incorrect, it shouldn't be after the DOD -  for testCow1 calling " +
                     "getDOB - got " + testCow1.getDateOfBirth());
         }


         //Hard to test Age as the current time always changes.
         //Here, if you uncomment, you can see the age of the cow
         //With DOB Jan 1, 2016 (if you're testing
         // this in 2022, the output of getAge() should be 6:

         //testCow1.setDateOfBirth(LocalDate.of(2016, 1, 1));
         //System.out.println(testCow1.getAge());


         //Testing the date strings:
         System.out.println(testCow1.getBirthdateString());
         System.out.println(testCow1.getDeathdateString());

         if(testCow1.getDeathdateString().equals("01/01/2019")){
             System.out.println("DOD string is incorrect,  for testCow1 calling " +
                     "getDODString - got " + testCow1.getDeathdateString());
         }

         if(testCow1.getBirthdateString().equals("01/01/2018")){
             System.out.println("DOB string is incorrect,  for testCow1 calling " +
                     "getDOBString - got " + testCow1.getBirthdateString());
         }



         //Currently no herd, so should get "No Location Data" for getCurrentLocationString()

         if(!testCow1.getCurrentLocationString().equals("No Location Data")){
             System.out.println("Location string is incorrect,  for testCow1 calling " +
                     "getCurrentLocationString" +
                     " - got " + testCow1.getCurrentLocationString());
         }

         //Later we will make a herd to test this again



         testCow1.setID("testID");

         if(!testCow1.getID().equals("testID")){
             System.out.println("After setting, ID is incorrect for testCow1 calling " +
                     "getID() - got " + testCow1.getID());
         }

         System.out.println("Testing for the Cow class is complete\n");


     }


 public static void main(String[] args)
 {
     /*

    Weight weight = new Weight(185.7f, "04/10/2022");
    Cow dad = new Cow("CowGuy", "24/11/1989", "male", false, true, 189.7f);
    Cow mom = new Cow("CowGril", "19/01/0900", "female", false, true, 18.9f);
    Cow baby = new Cow("CowBaby", "04/10/2022", "male", false, false, 22.91f, mom, dad);
    System.out.println("did this do anything?");
    System.out.println(weight);
    System.out.print(mom);
    System.out.print(dad);
    System.out.print(baby);*/
}

     public void setFarmTag(String farmTag) {
         this.farmTag = farmTag;
     }

     public void setGender(Gender gender) {
         this.gender = gender;
     }

     public void setMedicalRecords(ArrayList<MedProc> medicalItems) {
         this.medicalHistory = medicalItems;
     }

     public void setChildrenIDs(ArrayList<String> childrenIDs) {
         this.childrenIDs = childrenIDs;
     }
 }