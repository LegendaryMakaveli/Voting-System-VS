import java.util.Scanner;
import java.util.ArrayList;

public class VotingSystem {

	public static String apcCandidate;
	public static String pdpCandidate;
	public static String adpCandidate;
	public static String adcCandidate;
	public static String lpCandidate;

	public static ArrayList<String> usedVotersCards = new ArrayList<>();
	public static Scanner input = new Scanner(System.in);

	public static int apc = 0;
	public static int pdp = 0;
	public static int adp = 0;
	public static int adc = 0;
	public static int lp = 0;

	public static long currentStartHour;
	public static long currentStartMinute;	
	public static long currentStartSecond;



public static void displayWaiting() {
	for (int count = 1; count <= 3; count++) {
		try {
			System.out.print("wait for it....");
			Thread.sleep(1000);
		} catch (InterruptedException error) {
			System.out.println("An error occurred");
	}
	}
	System.out.println("Successful!!");
}


public static boolean isStringOnly(String input) {
	return input.matches("[a-zA-Z]+");
}


public static boolean isNumberOnly(String input) {
	return input.matches("\\d+");
}


public static String registerCandidate(String candidateName) {
	return "Name added!!";
}

public static String getCandidateParty(String candidateParty, String candidateName) {
	if (candidateParty.equalsIgnoreCase("APC")) {
            apcCandidate = candidateName;
        } else if (candidateParty.equalsIgnoreCase("PDP")) {
            pdpCandidate = candidateName;
        } else if (candidateParty.equalsIgnoreCase("ADP")) {
            adpCandidate = candidateName;
        } else if (candidateParty.equalsIgnoreCase("ADC")) {
            adcCandidate = candidateName;
        } else if (candidateParty.equalsIgnoreCase("LP")) {
            lpCandidate = candidateName;
        } else {
            return "Your party nur dey here!!";
        }
        return "Candidate added successfully";
 }


public static String votingProcess(String votersAnswer) {
        if (votersAnswer.equalsIgnoreCase("APC")) {
            apc++;
        } else if (votersAnswer.equalsIgnoreCase("PDP")) {
            pdp++;
        } else if (votersAnswer.equalsIgnoreCase("ADP")) {
            adp++;
        } else if (votersAnswer.equalsIgnoreCase("ADC")) {
            adc++;
        } else if (votersAnswer.equalsIgnoreCase("LP")) {
            lp++;
        } else {
            System.out.println("Who you wan vote for nur contest!!!");
        }
        return "Done";
    }




public static String getElectionResult() {
        int winner = 0;
        String win = "No candidate";

        if (apc > winner && apcCandidate != null) {
            winner = apc;
            win = apcCandidate;
        }
        if (pdp > winner && pdpCandidate != null) {
            winner = pdp;
            win = pdpCandidate;
        }
        if (adp > winner && adpCandidate != null) {
            winner = adp;
            win = adpCandidate;
        }
        if (adc > winner && adcCandidate != null) {
            winner = adc;
            win = adcCandidate;
        }
        if (lp > winner && lpCandidate != null) {
            winner = lp;
            win = lpCandidate;
        }

        return win + " is the winner!";
}





public static String getCardNumber() {
        System.out.print("Enter your votersCard number:   ");
        String votersCard = input.next();

        while (!isNumberOnly(votersCard) || votersCard.length() != 10 || usedVotersCards.contains(votersCard)) {
            if (usedVotersCards.contains(votersCard)) {
                System.out.println("Card number has already been used");
            } else {
                System.out.println("Check the number length (must be 10 digits)");
            }
            System.out.print("Enter voters card number:   ");
            votersCard = input.next();
        }
        usedVotersCards.add(votersCard);
        return "Ok";
 }





public static String GetLocalGovernment(){
System.out.print("What is your local government?:    ");
String localGovernment = input.next().toUpperCase();

while(!isStringOnly(localGovernment)) {
	System.out.print("Invalid input....only letters are allowed!");
	localGovernment = input.next().toUpperCase();
}
return "Ok";
}




public static String validateCandidate(){
System.out.print("Swear with ogun say if you win this Election you nur go misbehave(press yes for i wont) (press No for i will)?:     ");
String answer = input.next().toUpperCase();
if(answer.equalsIgnoreCase("Yes")){
	System.out.println("  ");
	System.out.println("Wetin your werey go talk before!!");
} else if(answer.equalsIgnoreCase("No")){
	System.out.println("  ");
	System.out.println("God bless you for not lying!!....But you don buy form, make your money nur waste....shay dey go!!");
} else if(!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No")) {
	System.out.println("  ");
	System.out.print("You nur dey this world??");
}
return "Everywhere good";
}




public static String displayResult(){

System.out.println(apcCandidate + " " + "get" + " " + apc + " " + "votes");
System.out.println(pdpCandidate + " " + "get" + " " + pdp + " " + "votes");
System.out.println(adpCandidate + " " + "get" + " " + adp + " " + "votes");
System.out.println(adcCandidate + " " + "get" + " " + adc + " " + "votes");
System.out.println(lpCandidate + " " + "get" + " " + lp + " " + "votes");

return "You self go don know winner nah....But as eyeNeck nur be you go tell me wetin i go do";
}






public static void getStartTime(){
    long startTimeInSecond = System.currentTimeMillis() / 1000;
    currentStartSecond = startTimeInSecond % 60;

    long startTimeInMinute = startTimeInSecond / 60;
    currentStartMinute = startTimeInMinute % 60;

    long startTimeInHour = startTimeInMinute / 60;
    currentStartHour = startTimeInHour % 24;

}



public static void displayStopTime(){

long stopTimeInSecond = System.currentTimeMillis() / 1000;
long currentStopSecond= stopTimeInSecond  % 60;

long stopTimeInMinute =  stopTimeInSecond / 60;
long currentStopMinute = stopTimeInMinute % 60; 

long stopTimeInHour = stopTimeInMinute / 60;
long currentStopHour = stopTimeInHour  % 24;

long timeSpentInHr =currentStopHour  - currentStartHour;
long timeSpentInMinute = currentStopMinute  - currentStartMinute;
long timeSpentInSeconds = currentStopSecond - currentStartSecond;

System.out.println("Total time spent on the election is: " + timeSpentInHr + "hrs" + " " + timeSpentInMinute + "mins" + " " + timeSpentInSeconds + "secs");

}





public static String getNames(String candidateName){
System.out.print("What is your name?:   ");
                candidateName = input.next().toUpperCase();
                while (!isStringOnly(candidateName)) {
			System.out.println("Invalid name!... only letters are allowed");
                    	candidateName = input.next().toUpperCase();
                }
return "Saved successfully";
}




public static String getNationality(String nationality) {
	System.out.print("What is the candidate nationality?:  ");
	 nationality = input.next();
	while (!isStringOnly(nationality)) {
		System.out.println("Invalid input! Only letters allowed.");
		nationality = input.next();
         }

	if (!nationality.equalsIgnoreCase("Nigerian")) {
		System.out.println("You are ineligible to run for any position in this country!!");
                }
return "Saved successfully";
}


public static String getAge(int age) {
	System.out.print("How old are you?:   ");
	 age = input.nextInt();
	if (age < 18 || age > 100) {
		System.out.println("You are ineligible");
	}
return "Age saved succesfully";
}



public static String castVote(String votersAnswer) {
	System.out.print("Pls cast your vote?:   ");
	 votersAnswer = input.next().toUpperCase();
	if(!votersAnswer.equalsIgnoreCase("APC") || !votersAnswer.equalsIgnoreCase("PDP") || !votersAnswer.equalsIgnoreCase("ADP") || !votersAnswer.equalsIgnoreCase("ADC") || !votersAnswer.equalsIgnoreCase("LP")) {
		System.out.println("Cofirm your choice again..(APC, PDP, ADP, ADC, LP)?:   ");
		votersAnswer = input.next().toUpperCase();
	}
return "Vote counted";
}


public static void displayMenu(){
System.out.println("""
	Welcome to today's presidential election!!
	These are the parties running for presidential positions in your country.
	Choose one and choose wisely......

            		1 -> APC
            		2 -> PDP
            		3 -> ADP
            		4 -> ADC
            		5 -> LP
Vote wisely......
  """);

}
















public static void main(String... makaveli) {

    String doYouwantToQuit = "YES";

    while (!doYouwantToQuit.equalsIgnoreCase("NO")) {
        System.out.println("Press C to register a candidate or V to register a voter or NO to Quit?");
        String answer = input.next().toUpperCase();

        if (answer.equalsIgnoreCase("C")) {
            System.out.println(validateCandidate());
            System.out.println(GetLocalGovernment());
            System.out.println(getCardNumber());
            System.out.println(getNames("")); 

            System.out.print("Enter candidate party (APC, PDP, ADP, ADC, LP): ");
            String candidateParty = input.next().toUpperCase();

            System.out.print("Enter candidate name again to confirm: ");
            String candidateName = input.next().toUpperCase();

            System.out.println(getCandidateParty(candidateParty, candidateName));
            displayWaiting();

        } else if (answer.equalsIgnoreCase("V")) {
            System.out.println(GetLocalGovernment());
            System.out.println(getCardNumber());

            displayMenu();
            String votersAnswer = castVote(""); 
            votingProcess(votersAnswer);
            displayWaiting();

        } else if (answer.equalsIgnoreCase("NO")) {
            doYouwantToQuit = "NO";
            break;

        } else {
            System.out.println("Invalid input.....run it again!");
        }

        doYouwantToQuit = answer; 
    }

    System.out.println();
    System.out.println(displayResult());
    displayWaiting();

    System.out.println();
    System.out.println(getElectionResult());
}
}