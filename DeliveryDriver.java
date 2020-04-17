/**
 * The <code>DeliveryDriver</code> class is the main driver of objects.
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 **/

import java.util.*;

public class DeliveryDriver 
{
    public static DeliveryList listA = new DeliveryList();
    public static DeliveryList listB = new DeliveryList();
    public static DeliveryList listC = new DeliveryList();
    
    public static Delivery temp;
    
    private static Scanner sc = new Scanner(System.in); 
    
    public static void main(String [] args)
    {
        base();

        System.out.println("Hello, Welcome to the Delinquent Dollar Delivery "
                + "Scheduler.\n");

        System.out.print("Please enter a delivery list to go to (A-C): ");

        chooseList();
    }
    
    public static void base()
    {
        Delivery d1 = new Delivery("China", "India", "Make it free");

        Delivery d2 = new Delivery("USA", "India", "Make it free");

        Delivery d3 = new Delivery("UK", "India", "Make it free");

        Delivery d4 = new Delivery("Japan", "India", "Make it free");

        Delivery d5 = new Delivery("France", "India", "Make it free");

        try
        {
            listA.appendToTail(d1);

            listA.appendToTail(d2);

            listA.appendToTail(d3);

            listA.appendToTail(d4);

            listA.appendToTail(d5);

            System.out.println("We added 5 items to the first list");
        }

        catch(IllegalArgumentException il)
        {
            System.out.println("You entered a wrong value.");
        }
    }
    
    public static void menu()
    {
        System.out.println("Menu:" + "\n"
                + "\t" + "A) Add a Delivery After Cursor" + "\n"
                + "\t" + "R) Remove Delivery At Cursor" + "\n"
                + "\t" + "X) Cut Cursor" + "\n"
                + "\t" + "V) Paste After Cursor" + "\n"
                + "\t" + "H) Cursor to Head" + "\n"
                + "\t" + "T) Cursor to Tail" + "\n"
                + "\t" + "F) Cursor Forward" + "\n"
                + "\t" + "B) Cursor Backward" + "\n"
                + "\t" + "S) Switch Delivery Lists"  + "\n"
                + "\t" + "P) Print current list" + "\n"
                + "\t" + "Q) Quit" + "\n");
    }
    
    public static void chooseList()
    {
        String inputList = sc.next();

        char iList = inputList.toUpperCase().charAt(0);

        switch (iList) 
        {
            case 'A':
                selectOption(listA);
                break;
            case 'B':
                selectOption(listB);
                break;
            case 'C':
                selectOption(listC);
                break;
            default: {
                System.out.print("Invalid list. Please enter the list "
                        + "again (A-C): ");

                chooseList();
            }
        }
    }
    
    public static void selectOption(DeliveryList list)
    {
        menu();
        
        System.out.print("Please select an option: ");

        String in = sc.next();

        char input = in.toUpperCase().charAt(0);
        
        sc.nextLine();

        switch (input) 
        {
            case 'A': 
            {
                System.out.print("\nPlease enter a source: ");
                String source = sc.nextLine();

                System.out.print("\nPlease enter a destination: ");
                String destination = sc.nextLine();

                System.out.print("\nPlease enter any special instructions: ");
                String instruction = sc.nextLine();

                Delivery d1 = new Delivery(source, destination, instruction);
                
                try
                {
                    list.insertAfterCursor(d1);

                    System.out.println("\nDelivery has been added!");

                    end();
                }
                
                catch(IllegalArgumentException il)
                {
                    System.out.println("You entered a wrong value. Please try "
                            + "again.");
                    
                    selectOption(list);
                }
            }
            break;

            case 'H': 
            {
                list.resetCursorToHead();
                
                System.out.println("\nCursor is at the head.");
                
                end();
            }
            break;
            
            case 'T': 
            {
                list.resetCursorToTail();
                
                System.out.println("\nCursor is at the tail.");
                
                end();
            }
            break;

            
            case 'F': 
            {
                try
                {
                    list.cursorForward();
                    
                    System.out.println("\nCursor has been moved forward.");

                    end();
                }
                
                catch(EndOfListException en)
                {
                    System.out.println("\nYou have reached the end if the list. "
                            + "There are no more elements further ahead. "
                            + "Please try again\n");
                    
                    selectOption(list);
                }
               
            }
            break;

            case 'B': 
            {
                try
                {
                    list.cursorBackward();

                    System.out.println("\nCursor has been moved backward.");

                    end();
                }
                
                catch(BeginningofListException be)
                {
                    System.out.println("\nYou have reached the beginning if the "
                            + "list. There are no more elements further behind. "
                            + "Please try again.\n");
                    
                    selectOption(list);
                }
            }
            break;
            
            case 'R': 
            {
                try
                {
                    temp = list.removeCursor();
                    temp = null;
                    System.out.println("The Delivery has been removed.");
                    
                    list.resetCursorToHead();
                    
                    System.out.println("The cursor has been reset to the head.");

                    end();
                }
                
                catch(EmptyListException en)
                {
                    System.out.println("The list is empty. Please try again.\n");
                    
                    selectOption(list);
                }
                
                catch(EndOfListException end)
                {
                    System.out.println("You have reached the end of the list. "
                            + "Please try again.\n");
                    
                    selectOption(list);
                }
            }
            break;
            
            case 'X': 
            {
                try
                {
                    temp = list.removeCursor();

                    System.out.println("\nThe delivery at cursor is cut.");

                    end();
                }
                
                catch(EmptyListException em)
                {
                    System.out.println("The list is empty. Please try again.\n");
                    
                    selectOption(list);
                }
                
                catch(EndOfListException end)
                {
                    System.out.println("\nYou have reached the end if the list. "
                            + "There are no more elements further ahead. "
                            + "Please try again\n");
                    
                    selectOption(list);
                }     
            }
            break;
            
            case 'V': 
            {
                try
                {
                    list.insertAfterCursor(temp);

                    System.out.println("\nThe delivery is pasted.");

                    System.out.println("If you pasted the cursor in a different "
                            + "list, the original list does not have a cursor "
                            + "anymore. \nIf you wish to use the original list with"
                            + " a cursor, please call Cursor to Head or Cursor to "
                            + "List option.");

                    end();
                }
                
                catch (IllegalArgumentException ill)
                {
                    System.out.println("The value you entered is incorrect. "
                            + "Please try again!\n");
                    
                    selectOption(list);
                }
            }
            break;
            
            case 'S': 
            {
                System.out.print("\nPlease select the list to go to (A-C): ");

                chooseList();

                break;
            }

            case 'P': 
            {
                System.out.println(list.toString());

                end();
            }
            break;
            
            case 'Q': 
            {
                System.out.println("\nNext time, try UPS!\nGoodbye!");
            }
            break;

            default: 
            {
                System.out.println("\nInvalid option! Please try again with a "
                        + "different option.\n");

                selectOption(list);
            }
        }
    }

    /**
     * Runs at the end of every method to ask the user if more tasks need to be
     * carried out.
     *
     */
    public static void end()
    {
        System.out.print("\nWould you like to carry out another task? (Y/N): ");
        String option = sc.next();

        char iOption = option.toUpperCase().charAt(0);
        
        switch (iOption) 
        {
            case 'Y':
            {
                System.out.print("\nWithin which list would you like to "
                        + "carry out the other task?: ");
                
                chooseList();
                
                break;
            }   
        
            case 'N':
            {
                System.out.println("\nIt was great working with you! Have a "
                        + "pleasant day!");
                
                break;
                
            }
  
            default:
            {
                
                System.out.println("\nIncorrect input! Please try again.");
                
                end();
                
                break;
            }
        }
    }
}