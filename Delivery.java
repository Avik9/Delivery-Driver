/**
 * The <code>Delivery</code> class implements a class of <code>Delivery</code> 
 * objects.
 * 
 * @author Avik Kadakia
 * email: avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 **/
public class Delivery 
{
    private String source; // Source of the delivery.
    private String dest; // Destination of the delivery.
    private String instruction; // Special instuctions for the delivery.
    
   /**
    *   A constructor that creates a Delivery object
    *
    *   @param nSource
    *       The source entered by the user.
    *
    *    @param nDest
    *        The destination entered by the user.
    *
    *   @param nInstruction
    *       The instructions entered by the user.
    *       
    */
    public Delivery(String nSource, String nDest, String nInstruction)
    {
        this.source = nSource;
        this.dest = nDest;
        this.instruction = nInstruction;
    }
    
    /**
     * 
     * @param nSource
     *      The new source entered by the user.
     */
    public void setSource(String nSource)
    {
        this.source = nSource;
    }
    
    /**
     * 
     * @return
     *      Returns the source of the Delivery.
     */
    public String getSource()
    {
        return this.source;
    }
    
    /**
     * 
     * @param nDest
     *      Sets the destination to the new destination entered by the user.
     */
    public void setDestination(String nDest)
    {
        this.dest = nDest;
    }
    
    /**
     * 
     * @return 
     *      Returns the destination of the Delivery.
     */
    public String getDestination()
    {
        return this.dest;
    }
    
    /**
     * 
     * @param nInstruction
     *      Changes the special instructions for the delivery to the new 
     * instructions provided by the user.
     */
    public void setInstruction(String nInstruction)
    {
        this.instruction = nInstruction;
    }
    
    /**
     * 
     * @return
     *      Returns the instructions set with delivery.
     */
    public String getInstruction()
    {
        return this.instruction;
    }
    
    /**
     * 
     * @return 
     *      Prints the Delivery.
     */
    @Override
    public String toString()
    {
        return "To: " + this.dest + " | From: " + this.source + 
                " \nInstruction: " + this.instruction;
    }
}