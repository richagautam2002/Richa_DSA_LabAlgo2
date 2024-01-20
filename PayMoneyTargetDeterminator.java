package paymoney.tgt.determinator;

import java.util.Scanner;

public class PayMoneyTargetDeterminator {
	Integer[] transactionList;

    Integer dailyTarget;

    Scanner input;

    public PayMoneyTargetDeterminator() {
        input = new Scanner(System.in);
    }

    //add a method - collect transaction values from user 
    //size of the transaction list-input
    private void collectTransactionList() {
        System.out.println("Trnsaction List : ");
        System.out.println("Enter the size of transaction list : ");
        Integer transactionListSize = input.nextInt();

        transactionList = new Integer[transactionListSize];

        // get each transaction value - input
        for (int index = 0; index<transactionListSize; index++) {
            System.out.printf("Enter the transaction value : %d / %d", (index+1), transactionListSize);
            System.out.println();

            transactionList[index] = input.nextInt(); 
        }
    }

    //method for collecting daily target -input
    private void collectDailyTarget() {
        System.out.println("Daily Target..");
        System.out.println("Enter the value for daily target : ");
        dailyTarget = input.nextInt();

    }

    public void determine() {

        collectTransactionList();

        collectDailyTarget();

        determineTarget();
    }

    void determineTarget() {

        int currentsumofTransactionValue = 0;

        boolean dailyTargetAchieved = false;

        int counter = 0;

        //iterate through the transaction
        for(int index = 0; index < transactionList.length; index++) {
            
            counter++;
            //get the value of each transation
            int transactionValue = transactionList[index];
            
            //compute the sum
            currentsumofTransactionValue = currentsumofTransactionValue + transactionValue;

            System.out.printf("Current sum of transaction value : %d", currentsumofTransactionValue);
            System.out.println();

            if (currentsumofTransactionValue >= dailyTarget) {

                dailyTargetAchieved = true; 
                break;
            }
        }

        if(dailyTargetAchieved) {
            System.out.printf("Daily Target of %d achieved after %d transactions",dailyTarget, counter);
            System.out.println();
        }
        else {
            System.out.printf("Daily target of %d is not achieved", dailyTarget);
            System.out.println();
        }

    }

}

