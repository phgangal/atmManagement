package main.java.com.atm;

import java.util.HashMap;
import java.util.Map;

public class Bills {
	
	Map<String, Integer> billMap  = new HashMap<String, Integer>() {{
	    put("20", (Integer) 1000);
	    put("10", (Integer) 1000);
	    put("5", (Integer) 1000);
	    put("1", (Integer) 1000);
	}};
	
	public void setBillMap(Map<String, Integer> billMap) {
		this.billMap = billMap;
	}

	public HashMap getBillMap() {
		return (HashMap) this.billMap;
	}

}
