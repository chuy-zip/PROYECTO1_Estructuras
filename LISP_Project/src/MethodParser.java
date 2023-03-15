
public class MethodParser {
	private int CloseParQTty = 0;
	private int OpenParQty = 0;
	
	public boolean SameQtyOfParenthesis() {
		if(CloseParQTty == OpenParQty) {
			return true;
		}
		
		return false;
	}
	
	public int getCloseParQTty() {
		return CloseParQTty;
	}
	public void setCloseParQTty(int closeParQTty) {
		CloseParQTty = closeParQTty;
	}
	public int getOpenParQty() {
		return OpenParQty;
	}
	public void setOpenParQty(int openParQty) {
		OpenParQty = openParQty;
	}
	public void ResetCounters() {
		CloseParQTty = 0;
		OpenParQty = 0;
	}
	
}
