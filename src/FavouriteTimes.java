import java.util.Scanner;
//Run the code and you will be prompted to


public class FavouriteTimes {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the duration: ");
        int duration = input.nextInt();
        int minute = 0;
        int hour = 12;
        int count = 0;
        for(int i = 0; i <= duration; i++) {
            minute++;
            if (minute >= 60) {
                //increment hour count by 1 and reset minute count
                hour++;
                minute = 0;
                if (hour > 12) {
                    //when hour > 12 reset back down to remainder
                    hour = hour % 12;
                }
            }
            String formattedMinute = "";
            if (minute < 10) {
                //add leading zeros
                formattedMinute = String.format("%02d", minute);
            } else {
                formattedMinute = Integer.toString(minute);
            }
            String formattedHour = Integer.toString(hour);
            if(checkSequence(formattedHour, formattedMinute)){
                count++;
            };
        }
        System.out.println(count);
    }

    public static boolean checkSequence(String formattedHour, String formattedMinute){
        String time = formattedHour + formattedMinute;
        if(time.length() == 3){
            //eg: 1:23 if the difference between each digit is the same then it is a sequence
            if(time.charAt(2) - time.charAt(1) == time.charAt(1) - time.charAt(0)){
                return true;
            }
        }else{
            //eg: 12:34
            if(time.charAt(3) - time.charAt(2) == time.charAt(2) - time.charAt(1)
                    && time.charAt(2) - time.charAt(1) == time.charAt(1) - time.charAt(0)
                    && time.charAt(3) - time.charAt(2) == time.charAt(1) - time.charAt(0)){
                return true;
            }
        }
        return false;
    }
}