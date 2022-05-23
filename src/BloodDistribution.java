import java.util.HashMap;
import java.util.Scanner;

public class BloodDistribution {

    public static void main(String args[]) {
        String[] bloodTypes = {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};

        Scanner input = new Scanner(System.in);

        System.out.print("Enter values of units of blood available:");
        HashMap<String, Integer> availableBlood = new HashMap<>();
        for(int i = 0; i < bloodTypes.length; i++){
            availableBlood.put(bloodTypes[i], input.nextInt());
        }
        System.out.println(availableBlood);

        System.out.print("Enter number of patients:");
        HashMap<String, Integer> numberOfPatients = new HashMap<>();
        for(int i = 0; i < bloodTypes.length; i++){
            numberOfPatients.put(bloodTypes[i], input.nextInt());
        }
        System.out.println(numberOfPatients);

        int receivedBlood = 0;

        receivedBlood = checkONegative(availableBlood, numberOfPatients, "O-");
        receivedBlood += checkOPositive(availableBlood, numberOfPatients, "O+");
        receivedBlood += checkANegative(availableBlood, numberOfPatients, "A-");
        receivedBlood += checkAPositive(availableBlood, numberOfPatients, "A+");
        receivedBlood += checkBNegative(availableBlood, numberOfPatients, "B-");
        receivedBlood += checkBPositive(availableBlood, numberOfPatients, "B+");
        receivedBlood += checkABNegative(availableBlood, numberOfPatients, "AB-");
        receivedBlood += checkABPositive(availableBlood, numberOfPatients, "AB+");
        System.out.println("Total patients who received blood: " + receivedBlood);
    }

    public static int checkONegative(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalONegBlood = availableBlood.get("O-");

        int receivedBlood;
        if(totalONegBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalONegBlood -= totalPatients; //update amount of O- blood left

            availableBlood.put("O-", totalONegBlood);
            numberOfPatients.put(patientType, 0);
        }else{
            //totalOPatients > totalONegBlood
            receivedBlood = totalONegBlood;
            totalPatients -= totalONegBlood;

            availableBlood.put("O-", 0);
            numberOfPatients.put(patientType, totalPatients);
        }
        return receivedBlood;
    }

    public static int checkOPositive(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalOPosBlood = availableBlood.get("O+");
        int receivedBlood;
        if(totalOPosBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalOPosBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put("O+", totalOPosBlood);
            numberOfPatients.put(patientType, 0);
        }else{
            receivedBlood = totalOPosBlood;
            totalPatients -= totalOPosBlood;
            availableBlood.put("O+", 0);
            numberOfPatients.put(patientType, totalPatients);
            receivedBlood += checkONegative(availableBlood, numberOfPatients, "O+");
        }
        return receivedBlood;
    }

    public static int checkANegative(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalANegBlood = availableBlood.get("A-");
        int receivedBlood;
        if(totalANegBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalANegBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put(patientType, totalANegBlood);
            numberOfPatients.put(patientType, 0);
        }else{
            receivedBlood = totalANegBlood;
            totalPatients -= totalANegBlood;
            availableBlood.put("A-", 0);
            numberOfPatients.put(patientType, totalPatients);
            receivedBlood += checkONegative(availableBlood, numberOfPatients, "A-");
        }
        return receivedBlood;
    }

    public static int checkAPositive(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalAPosBlood = availableBlood.get("A+");

        int receivedBlood;
        if(totalAPosBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalAPosBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put("A+", totalAPosBlood);
            numberOfPatients.put("A+", 0);
        }else{
            receivedBlood = totalAPosBlood;
            totalPatients -= totalAPosBlood;
            availableBlood.put("A+", 0);
            numberOfPatients.put("A+", totalPatients);

            receivedBlood += checkONegative(availableBlood, numberOfPatients, "A+");
            receivedBlood += checkOPositive(availableBlood, numberOfPatients, "A+");
            receivedBlood += checkANegative(availableBlood, numberOfPatients, "A+");
        }
        return receivedBlood;
    }

    public static int checkBNegative(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalBNegBlood = availableBlood.get("B-");
        int receivedBlood;
        if(totalBNegBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalBNegBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put(patientType, totalBNegBlood);
            numberOfPatients.put(patientType, 0);
        }else{
            receivedBlood = totalBNegBlood;
            totalPatients -= totalBNegBlood;
            availableBlood.put("B-", 0);
            numberOfPatients.put(patientType, totalPatients);
            receivedBlood += checkONegative(availableBlood, numberOfPatients, "B-");
        }
        return receivedBlood;
    }

    public static int checkBPositive(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalBPosBlood = availableBlood.get("B+");

        int receivedBlood;
        if(totalBPosBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalBPosBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put("B+", totalBPosBlood);
            numberOfPatients.put("B+", 0);
        }else{
            receivedBlood = totalBPosBlood;
            totalPatients -= totalBPosBlood;
            availableBlood.put("B+", 0);
            numberOfPatients.put("B+", totalPatients);
            receivedBlood += checkONegative(availableBlood, numberOfPatients, "B+");
            receivedBlood += checkOPositive(availableBlood, numberOfPatients, "B+");
            receivedBlood += checkBNegative(availableBlood, numberOfPatients, "B+");
        }
        return receivedBlood;
    }

    public static int checkABNegative(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalABNegBlood = availableBlood.get("AB-");
        int receivedBlood;
        if(totalABNegBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalABNegBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put(patientType, totalABNegBlood);
            numberOfPatients.put(patientType, 0);
        }else{
            receivedBlood = totalABNegBlood;
            totalPatients -= totalABNegBlood;
            availableBlood.put("AB-", 0);
            numberOfPatients.put(patientType, totalPatients);
            receivedBlood += checkONegative(availableBlood, numberOfPatients, "AB-");
            receivedBlood += checkANegative(availableBlood, numberOfPatients, "AB-");
            receivedBlood += checkBNegative(availableBlood, numberOfPatients, "AB-");
        }
        return receivedBlood;
    }

    public static int checkABPositive(HashMap<String, Integer> availableBlood, HashMap<String, Integer> numberOfPatients, String patientType){
        int totalPatients = numberOfPatients.get(patientType);
        int totalABPosBlood = availableBlood.get("AB+");

        int receivedBlood;
        if(totalABPosBlood > totalPatients){
            receivedBlood = totalPatients; //amount of patients who received blood;
            totalABPosBlood -= totalPatients; //update amount of O- blood left
            availableBlood.put("AB+", totalABPosBlood);
            numberOfPatients.put("AB+", 0);
        }else{
            receivedBlood = totalABPosBlood;
            totalPatients -= totalABPosBlood;
            availableBlood.put("AB+", 0);
            numberOfPatients.put("AB+", totalPatients);

            receivedBlood += checkONegative(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkOPositive(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkANegative(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkAPositive(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkBNegative(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkBPositive(availableBlood, numberOfPatients, "AB+");
            receivedBlood += checkABNegative(availableBlood, numberOfPatients, "AB+");

        }
        return receivedBlood;
    }
}