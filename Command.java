import java.io.IOException;
import java.io.OutputStream;

public class Command {
    public static final byte[] header = {(byte)0xde, (byte)0xad};
    public static final byte[] footer = {(byte)0xbe, (byte)0xef};
    public static final int SIZE_LENGTH = 1;
    public static final int CMD_BYTE_LENGTH = 1;

    public static void writeField(OutputStream outputStream, String name) throws IOException {
        outputStream.write(name.getBytes());
        outputStream.write(0x00);
    }
}
