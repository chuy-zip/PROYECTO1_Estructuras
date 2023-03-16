/**
 * This class provides functionality to parse a method and check if it has the same quantity of open and close parentheses.
 */
public class MethodParser {
	private int CloseParQTty = 0;
	private int OpenParQty = 0;
	
	/**
	 * 	Returns true if the number of open and close parentheses are the same, otherwise returns false.
	 * 	@return boolean indicating whether the number of open and close parentheses are the same
	 */
	public boolean SameQtyOfParenthesis() {
		if(CloseParQTty == OpenParQty) {
			return true;
		}
		
		return false;
	}
	/**
	 * Returns the quantity of close parentheses counted by this object.
	 * @return the quantity of close parentheses counted by this object
	 */
	public int getCloseParQTty() {
		return CloseParQTty;
	}
	
	/**
	 * Sets the quantity of close parentheses counted by this object.
	 * @param closeParQTty the new quantity of close parentheses to set
	 */
	public void setCloseParQTty(int closeParQTty) {
		CloseParQTty = closeParQTty;
	}
	
	/**
	 * Returns the quantity of open parentheses counted by this object.
	 * @return the quantity of open parentheses counted by this object
	 */
	public int getOpenParQty() {
		return OpenParQty;
	}
	
	/**
	 * Sets the quantity of open parentheses counted by this object.
	 * @param openParQty the new quantity of open parentheses to set
	 */
	public void setOpenParQty(int openParQty) {
		OpenParQty = openParQty;
	}
	
	/**
	 * 	Resets the count of open and close parentheses to zero.
	 */
	public void ResetCounters() {
		CloseParQTty = 0;
		OpenParQty = 0;
	}
	
}
