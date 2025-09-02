import java.util.Scanner;
import java.util.ArrayList;

public class VotingSystem {

	public static String apcCandidate;
	public static String pdpCandidate;
	public static String adpCandidate;
	public static String adcCandidate;
	public static String lpCandidate;

	public static ArrayList<String> usedVotersCards = new ArrayList<>();

	public static int apc = 0;
	public static int pdp = 0;
	public static int adp = 0;
	public static int adc = 0;
	public static int lp = 0;


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
        Scanner input = new Scanner(System.in);
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

public static void main(String... makaveli) {
Scanner input = new Scanner(System.in);
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


String doYouwantToQuit = "yes";
while (!doYouwantToQuit.equalsIgnoreCase("No")) {
System.out.println("Press C to register a candidate or V to register a voter or No to Quit?");
String answer = input.next().toUpperCase();

	if (answer.equalsIgnoreCase("C")) {
		System.out.print("What is candidate name?:   ");
                String candidateName = input.next().toUpperCase();
                while (!isStringOnly(candidateName)) {
			System.out.println("Invalid name!... only letters are allowed");
                    	candidateName = input.next().toUpperCase();
                }

                System.out.print("How old are you?:  ");
                int age = input.nextInt();
                if (age < 35 || age > 100) {
                    System.out.println("You are ineligible to run for any position in this country!!");
                    continue;
                }

                System.out.println(getCardNumber());

                System.out.print("What is your nationality?:  ");
                String nationality = input.next();
                while (!isStringOnly(nationality)) {
			System.out.println("Invalid input! Only letters allowed.");
                    	nationality = input.next();
                }

                if (!nationality.equalsIgnoreCase("Nigerian")) {
                    System.out.println("You are ineligible to run for any position in this country!!");
                    continue;
                }

                System.out.print("What is the name of your party:   ");
                String candidateParty = input.next().toUpperCase();
                System.out.println(getCandidateParty(candidateParty, candidateName));
                displayWaiting();


	} else if (answer.equalsIgnoreCase("V")) {
                System.out.print("What is the voters name?:   ");
                String votersName = input.next().toUpperCase();
                while (!isStringOnly(votersName)) {
			System.out.println("Invalid name!... only letters are allowed");
                    	votersName = input.next().toUpperCase();
                }

                System.out.print("How old are you?:   ");
                int age = input.nextInt();
                if (age < 18 || age > 100) {
                    System.out.println("You are ineligible to vote");
                    continue;
                }

                System.out.print("What is your nationality?:  ");
                String nationality = input.next();
                while (!isStringOnly(nationality)) {
			System.out.println("Invalid input! Only letters allowed.");
                    	nationality = input.next();
                }

                if (!nationality.equalsIgnoreCase("Nigerian")) {
                    System.out.println("You can not vote in this country!!");
                    continue;
                }

                System.out.println(getCardNumber());

                System.out.print("What party do you want to vote for?:   ");
                String votersAnswer = input.next().toUpperCase();
                votingProcess(votersAnswer);
                displayWaiting();

            } else if (!answer.equalsIgnoreCase("No")) {
                System.out.println("Invalid input.....run it again!");
                continue;
            }
            doYouwantToQuit = answer;
        }
        System.out.println(getElectionResult());
    }
}
