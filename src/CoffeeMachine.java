import java.util.Scanner;

public class CoffeeMachine {

        static int allGood = 111;

        public static void main(String[] args) {
            // put your code here
            Scanner scanner = new Scanner(System.in);
            int water = 400;
            int milk = 540;
            int coffeeBeans = 120;
            int cups = 9;
            int money = 550;
            boolean exitBool = true;

            String firstChoice;

            do {
                System.out.print("Write action (buy, fill, take, remaining, exit): ");
                firstChoice = scanner.next();

                switch (firstChoice) {

                    case "remaining": {
                        displayRemaining(water, milk, coffeeBeans, cups, money);
                        break;
                    }


                    case "buy": {
                        System.out.print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String secondChoice = scanner.next();
                        switch (secondChoice) {
                            case "1": {
                                int result = checkResourcesAndDisplayForEspresso(water, coffeeBeans, cups);
                                if(result == allGood){
                                    money += 4;
                                    water -= 250;
                                    coffeeBeans -= 16;
                                    cups -= 1;
                                    System.out.println("I have enough resources, making you a coffee!\n");

                                }
                                break;
                            }

                            case "2": {
                                int result = checkResourcesAndDisplayForLatte(water, milk, coffeeBeans, cups);
                                if(result == allGood){
                                    money += 7;
                                    water -= 350;
                                    milk -= 75;
                                    coffeeBeans -= 20;
                                    cups -= 1;
                                    System.out.println("I have enough resources, making you a coffee!\n");
                                }
                                break;
                            }

                            case "3": {
                                int result = checkResourcesAndDisplayForCappuccino(water, milk, coffeeBeans, cups);
                                if(result == allGood){
                                    money += 6;
                                    water -= 200;
                                    milk -= 100;
                                    coffeeBeans -= 12;
                                    cups -= 1;
                                    System.out.println("I have enough resources, making you a coffee!\n");
                                }
                                break;
                            }

                            case "back": {
                                break;
                            }
                        }
                        break;
                    }

                    case "fill": {
                        System.out.print("\nWrite how many ml of water do you want to add: ");
                        int addWater = scanner.nextInt();
                        System.out.print("Write how many ml of milk do you want to add: ");
                        int addMilk = scanner.nextInt();
                        System.out.print("Write how many grams of coffee beans do you want to add: ");
                        int addCoffeeBeans = scanner.nextInt();
                        System.out.print("Write how many disposable cups of coffee do you want to add: ");
                        int addCups = scanner.nextInt();
                        System.out.println();

                        water += addWater;
                        milk += addMilk;
                        coffeeBeans += addCoffeeBeans;
                        cups += addCups;
                        break;
                    }

                    case "take": {
                        System.out.println("\nI gave you $" + money + "\n");
                        money = 0;
                        break;
                    }

                    case "exit": {
                        exitBool = false;
                        break;
                    }


                }

            } while (exitBool);

        }

        static int checkResourcesAndDisplayForCappuccino(int water, int milk, int coffeeBeans, int cups) {
            if (water - 200 < 0) {
                System.out.println("Sorry, not enough water!\n");
            }
            else if (milk - 100 < 0) {
                System.out.println("Sorry, not enough milk!\n");
            }
            else if (coffeeBeans - 12 < 0) {
                System.out.println("Sorry, not enough coffee beans!\n");
            }
            else if (cups - 1 < 0) {
                System.out.println("Sorry, not enough cups!\n");
            }
            else {
                return allGood;
            }
            return 1;
        }

        static int checkResourcesAndDisplayForLatte(int water, int milk, int coffeeBeans, int cups) {
            if (water - 350 < 0) {
                System.out.println("Sorry, not enough water!\n");
            }
            else if (milk - 75 < 0) {
                System.out.println("Sorry, not enough milk!\n");
            }
            else if (coffeeBeans - 20 < 0) {
                System.out.println("Sorry, not enough coffee beans!\n");
            }
            else if (cups - 1 < 0) {
                System.out.println("Sorry, not enough cups!\n");
            }
            else {
                return allGood;
            }
            return 1;
        }

        static int checkResourcesAndDisplayForEspresso(int water, int coffeeBeans, int cups) {
            if (water - 250 < 0) {
                System.out.println("Sorry, not enough water!\n");
            }
            else if (coffeeBeans - 16 < 0) {
                System.out.println("Sorry, not enough coffee beans!\n");
            }
            else if (cups - 1 < 0) {
                System.out.println("Sorry, not enough cups!\n");
            }
            else {
                return allGood;
            }
            return 1;
        }


        static void displayRemaining(int water, int milk, int coffeeBeans, int cups, int money){
            System.out.println("\nThe coffee machine has:\n" +
                    water +" of water\n" +
                    milk  +" of milk\n" +
                    coffeeBeans +" of coffee beans");

            if (money == 0) {

                System.out.println(cups + " of disposable cups\n" + money + " of money\n");
            } else {
                System.out.println(cups + " of disposable cups\n$" + money + " of money\n");

            }
        }




}
