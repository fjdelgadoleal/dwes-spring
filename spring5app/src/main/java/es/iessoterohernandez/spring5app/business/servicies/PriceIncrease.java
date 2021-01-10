package es.iessoterohernandez.spring5app.business.servicies;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PriceIncrease {
	
	/** Logger for this class an subclasses	 */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Min(0)
	@Max(50)
	private int percentage;
	
	public void setPercentage(int i) {
		percentage = i;
		logger.info("Percentage set to "+ i);
	}
	
	public int getPercentage() {
		return percentage;
	}
	

}
