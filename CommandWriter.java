import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class CommandWriter {
    public static final byte[] header = {(byte)0xde, (byte)0xad};
    public static final byte[] footer = {(byte)0xbe, (byte)0xef};
    public static final int SIZE_LENGTH = 1;
    public static final int CMD_BYTE_LENGTH = 1;

    private final OutputStream outputStream;

    public CommandWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static void writeField(OutputStream outputStream, String name) throws IOException {
        outputStream.write(name.getBytes());
        outputStream.write(0x00);
    }

    static int getSize(List<String> fields) {
        int size = header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length;
        for (String field : fields) {
            size = size + field.getBytes().length + 1;
        }
        return size;
    }

    public void write(byte[] commandChar, List<String> fields) throws IOException {
        outputStream.write(header);
        outputStream.write(getSize(fields));
        outputStream.write(commandChar);
        for (String field : fields) {
            writeField(outputStream, field);
        }
        outputStream.write(footer);
    }
}
