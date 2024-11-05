/*
 * CMPT270 T27 MedProc - Medical Procedure class
 */
package com.example.demo.DataClasses;

 public class MedProc
 {
    // Attributes for MecProc object
    private String procedure;
    private String date;
    private String reason;
    private String product;
    private String dosage;
    private String route;
    private String notes;

    /** Constructor for MedProc objects
     * 
     * @param procedure: the medical procedure (vaccine, medication, surgery, ect.)
     * @param date: the date of the medical procedure dd/mm/yyyy
     * @param reason: the reason for the procedure
     * @param product: what product was used if any
     * @param dosage: what was the dosage
     * @param route: was the dose intravenous, intramuscular, subcutaneous, rectal, inhaled, oral, ect.
     * @param notes: notes for the procedure
     */
    public MedProc (String procedure, String date, String reason, String product, String dosage, String route, String notes)
    {
        this.procedure = procedure;
        this.date = date;
        this.reason = reason;
        this.product = product;
        this.dosage = dosage;
        this.route = route;
        this.notes = notes;
    }

    /** Accessor: the medical procedure
     * 
     * @return the medical procedure
     */
    public String getProcedure()
    {
        return procedure;
    }

    /** Mutator: update the medical procedure
     * 
     * @param updatedProcedure: the updated medical procedure
     */
    public void updateProcedure(String updatedProcedure)
    {
        procedure = updatedProcedure;
    }

    /** Accessor: get the date of the procedure dd/mm/yyyy
     * 
     * @return the date of the procedure dd/mm/yyyy
     */
    public String getDate()
    {
        return date;
    }

    /** Mutator: change the date of the procedure dd/mm/yyyy
     * 
     * @param newDate: the updated date dd/mm/yyyy
     */
    public void updateDate(String newDate)
    {
        date = newDate;
    }

    /** Accessor: get the reason for the medical procedure
     * 
     * @return the reason for the procedure
     */
    public String getReason()
    {
        return reason;
    }

    /** Mutator: update the reason for the procedure
     * 
     * @param newReason: the updated reason for the procedure
     */
    public void updateReason(String newReason)
    {
        reason = newReason;
    }

    /** Acessor: get the product(s) used
     * 
     * @return the product(s) used
     */
    public String getProduct()
    {
        return product;
    }

    /** Mutator: update the product(s) used
     * 
     * @param updatedProduct: the updated product(s) used
     */
    public void updateProduct(String updatedProduct)
    {
        product = updatedProduct;
    }

    /** Accessor: get the dosage used
     * 
     * @return the dosage used
     */
    public String getDosage()
    {
        return dosage;
    }

    /** Mutator: update the dosage used 
     * 
     * @param newDosage: the updated dosage used include units
    */
    public void updateDosage(String newDosage)
    {
        dosage = newDosage;
    }

    /** Accessor: get the route the medication used (IV, IM, Subcutaneous, ect.)
     * 
     * @return the route the medication used
     */
    public String getRoute()
    {
        return route;
    }

    /** Mutator: update the route the medication took
     * 
     * @param newRoute: the updated route
     */
    public void updateRoute(String newRoute)
    {
        route = newRoute;
    }

    /** Accessor: notes
     * 
     * @return any extra notes
     */
    public String getNotes()
    {
        return notes;
    }

    /** Mutator: update the notes
     * 
     * @param newNotes: the updated notes
     */
    public void updateNotes(String newNotes)
    {
        notes = newNotes;
    }

    /** toString()
     * 
     * @return a string of MedProc information in an easy to read format
     */
    public String toString()
    {
        return "Procedure: " + procedure + "\nDate: " + date + "(dd/mm/yyyy)\nReason: "
        + reason + "\nProduct: " + product + "\nDosage: " + dosage + "\nRoute: " + route +
        "\nNotes: " + notes; 
    }

    public static void test_medproc(){
        //public MedProc (String procedure, String date, String reason, String product, String dosage, String route, String notes)
        // Test object
        MedProc testCase = new MedProc("Vaccination", "05-10-2022", "Unvaccinated calf",
                "Vaccine #1", "50mg", "intramuscular injection", "broke needle");

        // Testing getProcedure() for basic functionality
        if (testCase.getProcedure() != "Vaccination") {
            System.out.printf("Error in getProcedure() method or constructor, output incorrect");
        }

        // Testing getDate() for basic functionality
        if (testCase.getDate() != "05-10-2022") {
            System.out.printf("Error in getDate() method or constructor, output incorrect");
        }

        // Testing getReason() for basic functionality
        if (testCase.getReason() != "Unvaccinated calf") {
            System.out.printf("Error in getReason() method or constructor, output incorrect");
        }

        // Testing getProduct() for basic functionality
        if (testCase.getProduct() != "Vaccine #1") {
            System.out.printf("Error in getProduct() method or constructor, output incorrect");
        }

        // Testing getDosage() for basic functionality
        if (testCase.getDosage() != "50mg") {
            System.out.printf("Error in getDosage() method or constructor, output incorrect");
        }

        // Testing getRoute() for basic functionality
        if (testCase.getRoute() != "intramuscular injection") {
            System.out.printf("Error in getRoute() method or constructor, output incorrect");
        }

        // Testing getNotes() for basic functionality
        if (testCase.getNotes() != "broke needle") {
            System.out.printf("Error in getNotes() method or constructor, output incorrect");
        }

        // Testing updateProcedure() for basic functionality
        testCase.updateProcedure("Administered Antibiotics");
        if (testCase.getProcedure() != "Administered Antibiotics") {
            System.out.printf("Error in updateProcedure() method, output incorrect");
        }

        // Testing updateDate() for basic functionality
        testCase.updateDate("01-01-2020");
        if (testCase.getDate() != "01-01-2020") {
            System.out.printf("Error in updateDate() method, output incorrect");
        }

        // Testing updateReason() for basic functionality
        testCase.updateReason("Leg Infection");
        if (testCase.getReason() != "Leg Infection") {
            System.out.printf("Error in updateReason() method, output incorrect");
        }

        // Testing updateProduct() for basic functionality
        testCase.updateProduct("Penicillin");
        if (testCase.getProduct() != "Penicillin") {
            System.out.printf("Error in updateProduct() method, output incorrect");
        }

        // Testing updateRoute() for basic functionality
        testCase.updateRoute("Oral Administration");
        if (testCase.getRoute() != "Oral Administration") {
            System.out.printf("Error in updateRoute() method, output incorrect");
        }

        // Testing updateDosage() for basic functionality
        testCase.updateDosage("1kg");
        if (testCase.getDosage() != "1kg") {
            System.out.printf("Error in updateDosage() method, output incorrect");
        }

        // Testing updateNotes() for basic functionality
        testCase.updateNotes("Went Smoothly");
        if (testCase.getNotes() != "Went Smoothly") {
            System.out.printf("Error in updateNotes() method, output incorrect");
        }

        System.out.println("Medproc tests complete\n");
    }
    // Main method for testing/debugging
    public static void main(String[] args) {

    }


 }
