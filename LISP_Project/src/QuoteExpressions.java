import java.util.LinkedList;
import java.util.Queue;

public class QuoteExpressions {
	private int OPEN_PAR_QTY = 0;
	private int CLOSE_PAR_QTY = 0;
	Queue<Token> QuotedQueue = new LinkedList<>();
	
	
	public int getOPEN_PAR_QTY() {
		return OPEN_PAR_QTY;
	}
	public void setOPEN_PAR_QTY(int oPEN_PAR_QTY) {
		OPEN_PAR_QTY = oPEN_PAR_QTY;
	}
	public int getCLOSE_PAR_QTY() {
		return CLOSE_PAR_QTY;
	}
	public void setCLOSE_PAR_QTY(int cLOSE_PAR_QTY) {
		CLOSE_PAR_QTY = cLOSE_PAR_QTY;
	}
	public Queue<Token> getQuotedQueue() {
		return QuotedQueue;
	}
	public void setQuotedQueue(Queue<Token> quotedQueue) {
		QuotedQueue = quotedQueue;
	}
	
	
}
