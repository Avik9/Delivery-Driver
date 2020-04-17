/**
 * The <code>DeliveryListNode</code> class implements a class of 
 * <code>DeliveryListNode</code> objects.
 * 
 * @author Avik Kadakia
 * email: avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 **/
public class DeliveryListNode 
{
    private Delivery data; // The data within the delivery.
    private DeliveryListNode next; // Indicates the link to the next node
    private DeliveryListNode prev; // Indicates the link the the previous node
    
    /**
     * Constructor creates a DeliveryListNode object
     * 
     * @param initData 
     * 
     * Preconditions:
     *      initData is not null.
     * 
     * Postconditions:
     *      This DeliveryListNode has been initialized to wrap the indicated 
     *      Delivery, and prev and next have been set to null.
     * 
     * @throws IllegalArgumentException
     *      Indicates initData is null.
     */
    public DeliveryListNode(Delivery initData) throws IllegalArgumentException
    {
        if(initData == null)
        {
            throw new IllegalArgumentException();
        }
        
        else
        {
            this.data = initData;
            prev = null;
            next = null;
        }
    }
    
    /**
     * 
     * @return 
     *      Returns the data from the Delivery.
     */
    public Delivery getData()
    {
        return this.data;
    }
    
    /**
     * 
     * @param newData
     *      Changes the data of the delivery to the data entered by the user. 
     */
    public void set Data(Delivery newData)
    {
        this.data = newData;
    }
    
    /**
     * 
     * @return 
     *      Returns the information on the next link.
     */
    public DeliveryListNode getNext()
    {
        return this.next;
    }
    
    /**
     * 
     * @param newNext
     *      Sets the next value entered by the user.
     */
    public void setNext(DeliveryListNode newNext)
    {
        this.next = newNext;
    }
    
    /**
     * 
     * @return 
     *      Returns the previous value by the user.
     */
    public DeliveryListNode getPrev()
    {
        return this.prev;
    }
    
    /**
     * 
     * @param newPrev
     *      Changes the value of the previous value as added by the user.
     */
    public void setPrev(DeliveryListNode newPrev)
    {
        this.prev = newPrev;
    }
    
    /**
     * 
     * @return 
     *      Returns the list of Delivery List Nodes.
     */
    @Override
    public String toString()
    {
        return "To: " + this.getData().getDestination() + " | From: " + 
                this.getData().getSource() + " \nInstruction: " + 
                this.getData().getInstruction();
    }
}