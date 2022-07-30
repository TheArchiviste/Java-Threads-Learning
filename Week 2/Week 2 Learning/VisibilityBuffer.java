public class VisibilityBuffer {
    protected static final int BUFFER_SIZE = 100;

    private byte[] buffer = new byte[BUFFER_SIZE];

    public void addToBuffer(byte[] data, int currentFill) {
		if (currentFill + data.length < BUFFER_SIZE) {
			for (int i = 0; i < data.length; i++) {
				buffer[currentFill++] = data[i];
			}
		}
	}
	
	public byte[] takeFromBuffer(int nBytes, int currentFill) {
		
		byte[] taken = null;
		
		int bytesAvailable = BUFFER_SIZE - currentFill;
		
		if (bytesAvailable > nBytes) {
			taken = new byte[nBytes];
			for (int i = BUFFER_SIZE-1 - nBytes, j = 0;j < nBytes; i++, j++) {
				taken[j] = buffer[i];
			}
			
			currentFill = currentFill - nBytes;
		}
		
		return taken;
	}
}
