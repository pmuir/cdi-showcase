package org.jboss.cdi.showcase.documents;

public class Document {
	
	private MetaData observed = new MetaData();
	private MetaData updated = new MetaData();

	public static class MetaData {
		private int observeCount = 0;

	    public void ack() {
	        observeCount++;
	    }

	    public boolean isObserved() {
	        return observeCount > 0;
	    }

	    public int getNumberTimesObserved() {
	        return observeCount;
	    }
	}
	
	public MetaData getObserved() {
		return observed;
	}
	
	public MetaData getUpdated() {
		return updated;
	}

}
