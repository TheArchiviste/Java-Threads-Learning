public class VisibilityBufferDemo2 {
    private int currentFill;
    private volatile boolean newDataAvailable;
    private VisibilityBuffer buffer;

    public void addToBuffer(byte[] data) {
        newDataAvailable = true;
        buffer.addToBuffer(data, currentFill);
    }

    public byte[] takeFromBuffer(int nBytes) {
        newDataAvailable = false;
        return buffer.takeFromBuffer(nBytes, currentFill);
    }

    public boolean isNewDataAvailable() {
        return newDataAvailable;
    }
}
