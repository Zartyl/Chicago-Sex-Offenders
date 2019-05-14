
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Offenders {

	public static void main(String[] args) throws FileNotFoundException {

		// From here is just importing the files from the pc to arrays
		String minorsArray[] = new String[1091];
		BufferedReader minor = new BufferedReader(new FileReader("minors.txt"));
		int number = 0;
		try {
			String line;

			while ((line = minor.readLine()) != null) {
				minorsArray[number] = line;
				number++;
			}
		} catch (IOException e) {
		} finally {
			/*
			 * try { lastName.close(); } catch (IOException e) { }
			 */
		}
		int number1 = 0;
		String firstNames[] = new String[1081];
		BufferedReader firstName = null;
		try {
			firstName = new BufferedReader(new FileReader("firstName.txt"));
			String line1;

			while ((line1 = firstName.readLine()) != null) {
				firstNames[number1] = line1;
				number1++;
			}
		} catch (IOException e) {
		} finally {
			/*
			 * try { firstName.close(); } catch (IOException e) { }
			 */
		}
		// BufferedReader genders = new BufferedReader(new FileReader());
		int number2 = 0;
		BufferedReader genders = new BufferedReader(new FileReader("gender.txt"));

		String gendersArray[] = new String[1091];
		try {
			String line2;

			while ((line2 = genders.readLine()) != null) {
				gendersArray[number2] = line2;
				number2++;
			}
		} catch (IOException e) {
		} finally {
			try {
				genders.close();
			} catch (IOException e) {
			}
		}
		BufferedReader races = new BufferedReader(new FileReader("races.txt"));
		int number3 = 0;
		String racesArray[] = new String[1092];
		try {
			String line3;

			while ((line3 = races.readLine()) != null) {
				racesArray[number3] = line3;
				number3++;
			}
		} catch (IOException e) {
		} finally {
			/*
			 * try { races.close(); } catch (IOException e) { }
			 */
		}

		// From here the categories will begin

		Scanner input = new Scanner(System.in);
		int category;
		boolean categoryTrue = false;
		int answerFinal = 0;

		while (categoryTrue == false) {
			System.out.println("What category would you like to search by:");
			System.out.println("(1) Gender");
			System.out.println("(2) Race");
			System.out.println("(3) Minor Victims");
			int answer = input.nextInt();

			if (answer > 0 && answer < 4) {
				categoryTrue = true;
				answerFinal = answer;
			} else {
				System.out.println("You entered an invalid number. Please pick a number between 1 and 4"
						+ " to search by a category");
			}
		}

		int gendersArrayFinal[] = new int[1091];
		int racesArrayFinal[] = new int[1091];
		int minorssArrayFinal[] = new int[1091];
		int testing14[] = new int[1091];
		int testing12[] = new int[1091];
		int testing13[] = new int[1092];

		switch (answerFinal) {

		case 1:

			boolean genderTrue = false;
			String genderChoiceUse = "";

			while (genderTrue == false) {
				// String genderChoice = JOptionPane.showInputDialog("Which gender will you
				// search by?");
				Scanner genderChoiceScanner = new Scanner(System.in);
				System.out.println("Which gender will you search by?");
				String genderChoice = genderChoiceScanner.nextLine();

				boolean maleCheck = genderChoice.equalsIgnoreCase("male");
				boolean femaleCheck = genderChoice.equalsIgnoreCase("female");

				if (maleCheck == true || femaleCheck == true) {
					genderTrue = true;
					genderChoiceUse = genderChoice;
				} else
					System.out.println("Please pick either female or male");
			}

			double counter1 = 0;
			double counter1Use = 0;

			for (int i = 0; i < gendersArray.length; i++) {
				boolean trial1 = genderChoiceUse.equalsIgnoreCase(gendersArray[i]);
				if (trial1 == true) {
					counter1++;
					counter1Use = counter1;
					trial1 = false;
				}
			}
			int vars = 0;

			for (int i = 0; i < gendersArray.length; i++) {
				boolean trial35 = genderChoiceUse.equalsIgnoreCase(gendersArray[i]);
				if (trial35 == true) {
					vars = i;
					// gendersArrayFinal[boys] = iNeed;
				}
				testing12[i] = vars;
				vars = 0;
			}
			int x = -1;
			for (int i = 0; i < counter1Use; i++) {
				if (testing12[i] > 0) {
					x++;
					gendersArrayFinal[x] = testing12[i];
				}
			}

			double genderPercent = (counter1Use / 1091) * 100;

			System.out.print("\n" + genderChoiceUse + "s makes up about ");
			System.out.printf("%.2f", genderPercent);
			System.out.println("% of sex offenders in Chicago");

			Scanner trialString = new Scanner(System.in);

			System.out.println("\nWhat second category would you like to search by? (Either race or minor)");
			String answerThree = trialString.nextLine();

			boolean raceCheck1 = answerThree.equalsIgnoreCase("Race");
			boolean minorCheck1 = answerThree.equalsIgnoreCase("Minor");

			String raceArrayFinal[] = new String[1091];

			if (raceCheck1 == true) {

				String raceChoiceFinal1Use = new String();

				for (int i = 0; i < gendersArrayFinal.length; i++) {
					raceArrayFinal[i] = racesArray[gendersArrayFinal[i]];
				}

				boolean raceCheckSecond = false;
				Scanner whichRaceSecond = new Scanner(System.in);

				while (raceCheckSecond == false) {
					System.out.println("Which race would you like to search by?");
					String raceChoiceFinal1 = whichRaceSecond.nextLine();
					raceChoiceFinal1Use = raceChoiceFinal1;

					boolean raceChoiceFinal1Check = false;

					if (raceChoiceFinal1.equalsIgnoreCase("white") || raceChoiceFinal1.equalsIgnoreCase("black")
							|| raceChoiceFinal1.equalsIgnoreCase("asian")
							|| raceChoiceFinal1.equalsIgnoreCase("hispanic")) {
						raceCheckSecond = true;
					} else {
						System.out.println("Please choose either black, white, asian or hispanic:");
					}
				}

				double counter55 = 0;

				for (int i = 0; i < raceArrayFinal.length; i++) {
					boolean trial55 = raceChoiceFinal1Use.equalsIgnoreCase(raceArrayFinal[i]);
					if (trial55 == true) {
						counter55++;
						trial55 = false;
					}
				}

				double percentRaceToday;
				percentRaceToday = (counter55 / 1092) * 100;

				System.out.printf("%.2f", percentRaceToday);
				System.out.println("% of the " + genderChoiceUse + "s are " + raceChoiceFinal1Use);
			}

			String minorArrayFinal[] = new String[1091];

			if (minorCheck1 == true) {

				String wave = "";

				for (int i = 0; i < gendersArrayFinal.length; i++) {
					minorArrayFinal[i] = minorsArray[gendersArrayFinal[i]];
				}

				boolean raceCheckSecond = false;
				Scanner whichRaceSecond = new Scanner(System.in);

				String minorChoiceYN;
				while (raceCheckSecond == false) {
					System.out.println("Minor victims (Enter Y or N)");
					minorChoiceYN = whichRaceSecond.nextLine();
					// raceChoiceFinal1Use = minorChoiceYN;
					wave = minorChoiceYN;

					boolean raceChoiceFinal1Check = false;

					if (minorChoiceYN.equalsIgnoreCase("Y") || minorChoiceYN.equalsIgnoreCase("N")) {
						raceCheckSecond = true;
					} else {
						System.out.println("Please choose either Y or N:");
					}
				}

				double counter55 = 0;

				for (int i = 0; i < raceArrayFinal.length; i++) {
					boolean trial55 = wave.equalsIgnoreCase(minorArrayFinal[i]);
					if (trial55 == true) {
						counter55++;
						trial55 = false;
					}
				}

				double percentRaceToday;
				percentRaceToday = (counter55 / 1092) * 100;

				System.out.printf("%.2f", percentRaceToday);
				if (wave.equalsIgnoreCase("n"))
					System.out.println("% of the " + genderChoiceUse + "s are no for minors");
				else {
					System.out.println("% of the " + genderChoiceUse + "s are yes for minors");
				}
			}
			break;

		case 2:

			boolean raceChoiceTest = false;
			Scanner raceChoiceScanner = new Scanner(System.in);
			String raceChoice2 = "";
			while (raceChoiceTest == false) {
				System.out.println("Which race will you search by?");
				raceChoice2 = raceChoiceScanner.nextLine();

				boolean blackChoice1 = raceChoice2.equalsIgnoreCase("black");
				boolean whiteChoice1 = raceChoice2.equalsIgnoreCase("white");
				boolean hispanicChoice1 = raceChoice2.equalsIgnoreCase("hispanic");
				boolean asianChoice1 = raceChoice2.equalsIgnoreCase("asian");

				if (blackChoice1 == true || whiteChoice1 == true || hispanicChoice1 == true || asianChoice1 == true) {
					raceChoiceTest = true;
				} else {
					System.out.println("Please pick black, white, hispanic or asian");
				}
			}

			double counter12 = 0;

			for (int i = 0; i < racesArray.length; i++) {
				boolean trial12 = raceChoice2.equalsIgnoreCase(racesArray[i]);
				if (trial12 == true) {
					counter12++;
					trial12 = false;
				}
			}

			double raceFinalPercent = (counter12 / 1092) * 100;
			int vars1 = 0;

			for (int i = 0; i < racesArray.length; i++) {
				boolean trial15 = raceChoice2.equalsIgnoreCase(racesArray[i]);
				if (trial15 == true) {
					vars1 = i;
				}
				testing13[i] = vars1;
				vars1 = 0;
			}

			int y = -1;
			for (int i = 0; i < counter12; i++) {
				if (testing13[i] > 0) {
					y++;
					racesArrayFinal[y] = testing13[i];
				}
			}

			System.out.print("\n" + raceChoice2 + "s makes up about ");
			System.out.printf("%.2f", raceFinalPercent);
			System.out.println("% of sex offenders in Chicago");

			Scanner trial2ScannerFinal = new Scanner(System.in);

			System.out.println("\nWhat second category will you choose by (gender or minor)?");
			String answerFour = trial2ScannerFinal.nextLine();

			boolean genderFinalCheck = answerFour.equalsIgnoreCase("gender");
			boolean minorFinalCheck = answerFour.equalsIgnoreCase("minor");

			String genderArrayFinal[] = new String[1091];

			if (genderFinalCheck == true) {
				String genderChoiceUseFour = new String();

				for (int i = 0; i < racesArrayFinal.length; i++) {
					genderArrayFinal[i] = gendersArray[racesArrayFinal[i]];
				}

				boolean genderCheckFinal = false;
				Scanner test123 = new Scanner(System.in);
				String genderChoice200 = "";

				while (genderCheckFinal == false) {
					System.out.println("What gender would you like to search by?");
					genderChoice200 = test123.nextLine();

					boolean test1234 = false;

					if (genderChoice200.equalsIgnoreCase("male") || genderChoice200.equalsIgnoreCase("female")) {
						genderCheckFinal = true;
					} else {
						System.out.println("Please pick either male or female:");
					}
				}

				double counter77 = 0;

				for (int i = 0; i < genderArrayFinal.length; i++) {
					boolean trial55 = genderChoice200.equalsIgnoreCase(genderArrayFinal[i]);
					if (trial55 == true) {
						counter77++;
						trial55 = false;
					}
				}

				double percentGenderinRace = (counter77 / 1092) * 100;

				System.out.printf("%.2f", percentGenderinRace);
				System.out.println("% of the " + raceChoice2 + "s are " + genderChoice200);
			}

			String minorsArrayFinal[] = new String[1091];

			if (minorFinalCheck == true) {

				String wave = "";

				for (int i = 0; i < gendersArrayFinal.length; i++) {
					minorsArrayFinal[i] = minorsArray[racesArrayFinal[i]];
				}

				boolean raceCheckSecond = false;
				Scanner whichRaceSecond = new Scanner(System.in);

				String minorChoiceYN;
				while (raceCheckSecond == false) {
					System.out.println("Minor victims (Enter Y or N)");
					minorChoiceYN = whichRaceSecond.nextLine();
					// raceChoiceFinal1Use = minorChoiceYN;
					wave = minorChoiceYN;

					boolean raceChoiceFinal1Check = false;

					if (minorChoiceYN.equalsIgnoreCase("Y") || minorChoiceYN.equalsIgnoreCase("N")) {
						raceCheckSecond = true;
					} else {
						System.out.println("Please choose either Y or N:");
					}
				}

				double counter55 = 0;

				for (int i = 0; i < minorsArrayFinal.length; i++) {
					boolean trial55 = wave.equalsIgnoreCase(minorsArrayFinal[i]);
					if (trial55 == true) {
						counter55++;
						trial55 = false;
					}
				}

				double percentRaceToday;
				percentRaceToday = (counter55 / 1092) * 100;

				System.out.printf("%.2f", percentRaceToday);
				if (wave.equalsIgnoreCase("n"))
					System.out.println("% of the " + raceChoice2 + "s are no for minors");
				else {
					System.out.println("% of the " + raceChoice2 + "s are yes for minors");
				}
			}
			break;

		case 3:

			boolean minorCheckChoice = false;
			Scanner minorsChoiceInputScanner = new Scanner(System.in);
			String minorsChoiceInput = "";
			while (minorCheckChoice == false) {
				System.out.println("Do you want to search for minors? (Y or N)");
				minorsChoiceInput = minorsChoiceInputScanner.nextLine();

				boolean Ytest = minorsChoiceInput.equalsIgnoreCase("Y");
				boolean Ntest = minorsChoiceInput.equalsIgnoreCase("N");

				if (Ytest == true || Ntest == true) {
					minorCheckChoice = true;
				} else {
					System.out.println("Please choose either Y or N:");
				}
			}

			double counter13 = 0;

			for (int i = 0; i < minorsArray.length; i++) {
				boolean trial2 = minorsChoiceInput.equalsIgnoreCase(minorsArray[i]);
				if (trial2 == true) {
					counter13++;
					trial2 = false;
				}
			}

			double percentMinors = (counter13 / 1092) * 100;

			if (minorsChoiceInput.equalsIgnoreCase("Y")) {
				System.out.println("Sex Offenders with minor victims make up about ");
			} else {
				System.out.println("Sex Offenders without minor victims make up about ");
			}
			System.out.printf("%.2f", percentMinors);
			System.out.println("% of all the sex offenders in Chicago.");

			int vars3 = 0;

			for (int i = 0; i < minorsArray.length; i++) {
				boolean trial67 = minorsChoiceInput.equalsIgnoreCase(minorsArray[i]);
				if (trial67 == true) {
					vars3 = i;
				}
				testing14[i] = vars3;
				vars3 = 0;
			}

			int z = -1;
			for (int i = 0; i < counter13; i++) {
				if (testing14[i] > 0) {
					z++;
					minorssArrayFinal[z] = testing14[i];
				}
			}

			Scanner inputFinal = new Scanner(System.in);
			System.out.println("\nWhat second category will you choose by (gender or race)?");
			String answerFinalOne = inputFinal.nextLine();

			boolean genderFinalChecks = answerFinalOne.equalsIgnoreCase("gender");
			boolean raceFinalCheck = answerFinalOne.equalsIgnoreCase("race");

			String[] genderArrayActualFinal = new String[1091];

			if (genderFinalChecks == true) {
				String genderChoiceUseFour = new String();

				for (int i = 0; i < minorssArrayFinal.length; i++) {
					genderArrayActualFinal[i] = gendersArray[minorssArrayFinal[i]];
				}

				boolean genderCheckFinal = false;
				Scanner test123 = new Scanner(System.in);
				String genderChoice200 = "";

				while (genderCheckFinal == false) {
					System.out.println("What gender would you like to search by?");
					genderChoice200 = test123.nextLine();

					boolean test1234 = false;

					if (genderChoice200.equalsIgnoreCase("male") || genderChoice200.equalsIgnoreCase("female")) {
						genderCheckFinal = true;
					} else {
						System.out.println("Please pick either male or female:");
					}
				}

				double counter77 = 0;

				for (int i = 0; i < genderArrayActualFinal.length; i++) {
					boolean trial55 = genderChoice200.equalsIgnoreCase(genderArrayActualFinal[i]);
					if (trial55 == true) {
						counter77++;
						trial55 = false;
					}
				}

				double percentGenderinRace = (counter77 / 1092) * 100;

				System.out.printf("%.2f", percentGenderinRace);
				System.out.print("% of ");
				if (minorsChoiceInput.equalsIgnoreCase("Y")) {
					System.out.print("sex offenders with minor victims are ");
				} else {
					System.out.print("sex offenders without minor victims are ");
				}

				System.out.print(genderChoice200);
			}

			String raceArrayFinalOne[] = new String[1091];

			if (raceFinalCheck == true) {
				String raceChoiceFinal1Use = new String();

				for (int i = 0; i < minorssArrayFinal.length; i++) {
					raceArrayFinalOne[i] = racesArray[minorssArrayFinal[i]];
				}

				boolean raceCheckSecond = false;
				Scanner whichRaceSecond = new Scanner(System.in);

				while (raceCheckSecond == false) {
					System.out.println("Which race would you like to search by?");
					String raceChoiceFinal1 = whichRaceSecond.nextLine();
					raceChoiceFinal1Use = raceChoiceFinal1;

					boolean raceChoiceFinal1Check = false;

					if (raceChoiceFinal1.equalsIgnoreCase("white") || raceChoiceFinal1.equalsIgnoreCase("black")
							|| raceChoiceFinal1.equalsIgnoreCase("asian")
							|| raceChoiceFinal1.equalsIgnoreCase("hispanic")) {
						raceCheckSecond = true;
					} else {
						System.out.println("Please choose either black, white, asian or hispanic:");
					}
				}

				double counter55 = 0;

				for (int i = 0; i < raceArrayFinalOne.length; i++) {
					boolean trial55 = raceChoiceFinal1Use.equalsIgnoreCase(raceArrayFinalOne[i]);
					if (trial55 == true) {
						counter55++;
						trial55 = false;
					}
				}

				double percentRaceToday;
				percentRaceToday = (counter55 / 1092) * 100;

				System.out.printf("%.2f", percentRaceToday);
				System.out.print("% of ");
				if (minorsChoiceInput.equalsIgnoreCase("Y")) {
					System.out.print("sex offenders with minor victims are ");
				} else {
					System.out.print("sex offenders without minor victims are ");
				}

				System.out.print(raceChoiceFinal1Use);
			}
			break;
		}

		System.out.println ("Thank you for using Aditya's data analysis code!");
	}
}