/**
 * The <code>DeliveryList</code> class implements a class of 
 * <code>DeliveryList</code> objects that hold Delivery objects.
 * 
 * @author Avik Kadakia
 * email: avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 **/

public class DeliveryList 
{
    private DeliveryListNode head; // head of the list
    private DeliveryListNode tail; // tail of the list
    private DeliveryListNode cursor; // cursor to go throwugh the list
    private int count;
    
    private DeliveryListNode temp; // temperory node to assist during functions.

    /**
     * Postconditions:
     *      This DeliveryList has been initialized with head, tail, and cursor 
     *      all set to null.
     */
    public DeliveryList()
    {
        head = null;
        tail = null;
        cursor = null;
        count = 0;
    }
    
    /**
     * 
     * @return 
     *      Returns the total number of Deliveries in the list.
     */ 
    public int numDeliveries()
    {
        return this.count;
    }
    
    /**
     *  Gets the reference to the Delivery wrapped by the DeliveryListNode 
     * currently referenced by cursor.
     * 
     * @return 
     *      Returns the reference by the Delivery wrapped by the 
     * DeliveryListNode currently referenced by cursor. 
     */
    public Delivery getCursor()
    {
        return cursor.getData();
    }
    
    /**
     * Resets the cursor to the head of the list
     * 
     * Postconditions:
     *      If head is not null, cursor references the first DeliveryListNode 
     *      in this list.
     *      If head is null, the cursor is set to null as well
     */
    public void resetCursorToHead()
    {
        if(head != null)
        {
            cursor = head;
        }
        
        else
        {
            cursor = null;
        }
    }
    
    public void resetCursorToTail()
    {
        if(tail != null)
        {
            cursor = tail;
        }
        
        else
        {
            cursor = null;
        }
    }
    
    /**
     * 
     * @throws EndOfListException 
     */
    public void cursorForward() throws EndOfListException
    {
        if(cursor == tail || head == null)
        {
            throw new EndOfListException();
        }
        
        else
        {
            cursor = cursor.getNext();
        }
    }
    
    public void cursorBackward() throws BeginningofListException
    {
        if(cursor == head || head == null)
        {
            throw new BeginningofListException();
        }
        
        else
        {
            cursor = cursor.getPrev();
        }
    }
    
    public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException
    {
        DeliveryListNode add = new DeliveryListNode(newDelivery);
        
        if(newDelivery != null)
        {
            if(cursor == null)
            {
                tail = add;
                head = add;
                cursor = add;
            }
            
            else
            {
                add.setNext(cursor.getNext());
                
                add.setPrev(cursor);
                
                cursor.setNext(add);
                
                cursor.getNext().setPrev(add);

                
                if (cursor.getNext() == null)
                {
                    tail = cursor;
                }
            }
            
            count++;
        }
        
        else
        {
            throw new IllegalArgumentException();
        }
    }
    
    public void appendToTail(Delivery newDelivery) throws IllegalArgumentException
    {
        DeliveryListNode add = new DeliveryListNode(newDelivery);
        
        if(tail == null)
        {
            tail = add;
            head = add;
            cursor = add;
            
            count++;
        }
        
        if(newDelivery != null)
        {
            tail.setNext(add);
            
            add.setPrev(tail);
            
            tail = add;
            
            count++;
        }
        
        else
        {
            throw new IllegalArgumentException();
        }
    }
    
    public Delivery removeCursor() throws EndOfListException, EmptyListException
    {
        if(head == null && tail == null)
        {
            throw new EmptyListException();
        }
        
        if(cursor == null)
        {
            throw new EndOfListException();
        }
        
        else
        {
            if(cursor == head)
            {
                temp = head;
                head = cursor.getNext();
                cursor = head;
            }
            
            else if(cursor == tail)
            {
                temp = tail;
                tail = cursor.getPrev();
                cursor = tail;
                cursor.setNext(null);
            }
            
            else if(cursor == head && cursor == tail)
            {
                cursor = null;
                return null;
            }
            
            else
            {
                temp = cursor;
                
                cursor.getPrev().setNext(cursor.getNext());
                
                cursor.getNext().setPrev(cursor.getPrev());
            }
        }
        count--;
        return temp.getData();
    }
    
    @Override
    public String toString()
    {
        String print = "---------------------------------------------------------\n";
        
        temp = head;
        
        while(temp != null)
        {
            if(temp == cursor)
            {
                print += "->";
                
                print += "\n" + temp.toString() + "\n";
            }
            
            else
            {
                print += "~";
                
                print += "\n" + temp.toString() + "\n";
            }
            
            temp = temp.getNext();
        }
        
        print += "---------------------------------------------------------\n";
        
        return print;
    }
}