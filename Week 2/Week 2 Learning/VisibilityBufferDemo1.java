public class VisibilityBufferDemo1 {
    private int currentFill;
    private volatile boolean newDataAvailable;
    private VisibilityBuffer buffer;

    public void addToBuffer(byte[] data) {
        buffer.addToBuffer(data, currentFill);
        newDataAvailable = true;
    }

    public byte[] takeFromBuffer(int nBytes) {
        newDataAvailable = false;
        return buffer.takeFromBuffer(nBytes, currentFill);
    }

    public boolean isNewDataAvailable() {
        return newDataAvailable;
    }
}
