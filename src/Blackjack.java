//kevin wang ufid 13583000
//if statement myMove == 2 my friend Rohan helped me with this if statement
import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        P1Random rng = new P1Random();

        int myHand = 0; //myHand is the combine value of all the cards in your hand
        double winsForPercent = 0; //the number of wins, which is used to calculate win percentage
        int numberOfWins = 0;
        int numberOfTies = 0;
        int numberOfLosses = 0;
        int myMove = 1; //start at myMove == 1 in loop
        int numberOfGames = 1;

        System.out.println("START GAME #" + numberOfGames + "\n");

        while (myMove <= 4) //while loop
        {
            if (myMove != 1) //menu
            {
                System.out.println("\n1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit\n");
                System.out.print("Choose an option: ");
                myMove = input.nextInt();
                System.out.println(); //skip line

                if  (myMove > 4) //invalid input if player input a number higher than 4
                {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    myMove = 0; //go to menu
                }
                else if (myMove < 1) //invalid input if player input a number lower than 1
                {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    myMove = 0; //go to menu
                }
            }
            if (myMove == 1) //draw random card and add to myHand
            {
                int randomCard = rng.nextInt(13) + 1; //a random number in range [1,13]

                //if the random card is between 2 and 10, display number.
                if (randomCard >= 2 && randomCard <=10)
                {
                    System.out.println("Your card is a " + randomCard + "!");
                }
                //if the random card is an ACE or a face card, display ACE or face card rather than actual number
                else if (randomCard == 1)
                {
                    System.out.println("Your card is a ACE!");
                }
                else if (randomCard == 11)
                {
                    System.out.println("Your card is a JACK!");
                    randomCard = 10;
                }
                else if (randomCard == 12)
                {
                    System.out.println("Your card is a QUEEN!");
                    randomCard = 10;
                }
                else if (randomCard == 13)
                {
                    System.out.println("Your card is a KING!");
                    randomCard = 10;
                }
                myHand += randomCard; //combine the value of the randomCard drawn with the total value of myHand
                System.out.println("Your hand is: " + myHand);
                myMove = 0; //go to the line with "myMove != 1" or go to the menu

                if (myHand == 21) //if your hand is equal to 21, you win and the game resets
                {
                    System.out.println("\nBLACKJACK! You win!\n");
                    numberOfWins += 1;
                    numberOfGames += 1;
                    winsForPercent += 1;
                    myHand = 0; //resets myHand
                    myMove = 1; //resets game
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
                else if (myHand > 21) //if your hand is greater than 21, you lose and game resets.
                {
                    System.out.println("\nYou exceeded 21! You lose.\n");
                    numberOfLosses += 1;
                    numberOfGames += 1;
                    myHand = 0; //resets myHand
                    myMove = 1; //resets game
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
            }

            else if (myMove == 2) //hold hand
            {
                int dealerHand; //the total value of the dealer's hand
                dealerHand = rng.nextInt(11) + 16; //a random number in range [16,26] for dealer's hand
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + myHand + "\n");

                if (dealerHand > 21) //if the value of the dealer's hand is greater than 21, then you win.
                {
                    System.out.println("You win!\n");
                    numberOfWins += 1;
                    numberOfGames += 1;
                    winsForPercent += 1;
                    myMove = 1; //resets game
                    myHand = 0; //resets myHand
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
                else if (dealerHand < myHand) //if the value of the dealer's hand is less than your hand, you win.
                {
                    System.out.println("You win!\n");
                    numberOfWins += 1;
                    numberOfGames += 1;
                    winsForPercent += 1;
                    myHand = 0; //resets myHand
                    myMove = 1; //resets game
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
                else if (dealerHand > myHand) //if the value of the dealer's hand is greater than your hand, you lose.
                {
                    System.out.println("Dealer wins!\n");
                    numberOfLosses += 1;
                    numberOfGames += 1;
                    myHand = 0; //resets myHand
                    myMove = 1; //resets game
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
                else if (dealerHand == myHand) //if the value of the dealer's hand is equal to your hand, you tie.
                {
                    System.out.println("It's a tie! No one wins!\n");
                    numberOfTies += 1;
                    numberOfGames += 1;
                    myHand = 0; //resets myHand
                    myMove = 1; //resets game
                    System.out.println("START GAME #" + numberOfGames + "\n");
                }
            }
            else if (myMove == 3) //print statistics
            {
                int totalOfGames;
                totalOfGames = numberOfLosses + numberOfTies + numberOfWins; //the total number of games that has been played
                double winPercent;
                winPercent = (winsForPercent / totalOfGames) * 100; //win percentage formula
                winPercent = Math.round(winPercent * 10) / 10.0; //round win percentage to one decimal place
                System.out.println("Number of Player wins: " + numberOfWins);
                System.out.println("Number of Dealer wins: " + numberOfLosses);
                System.out.println("Number of tie games: " + numberOfTies);
                System.out.println("Total # of games played is: " + totalOfGames);
                System.out.println("Percentage of Player wins: " + winPercent + "%");
                /*
                Title: How to round a double number to one decimal digits in Java? - rounding in java
                Author: DeeDoOo toys
                Date: Mar 27, 2017
                Availability: https://www.youtube.com/watch?v=eCdMZ_Jl_kY
                */
            }
            else if (myMove == 4) //exit game
            {
                break;
            }
        }
    }
}