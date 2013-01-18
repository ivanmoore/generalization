import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CommandWriter {
    public static final byte[] header = {(byte)0xde, (byte)0xad};
    public static final byte[] footer = {(byte)0xbe, (byte)0xef};
    public static final int SIZE_LENGTH = 1;
    public static final int CMD_BYTE_LENGTH = 1;

    private final byte[] commandChar;
    private final List<String> fields = new ArrayList<String>();

    public CommandWriter(byte commandChar) {
        this.commandChar = new byte[]{commandChar};
    }

    public void add(String field) {
        fields.add(field);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(header);
        outputStream.write(getSize(fields));
        outputStream.write(commandChar);
        for (String field : fields) {
            writeField(field, outputStream);
        }
        outputStream.write(footer);
    }

    private void writeField(String name, OutputStream outputStream) throws IOException {
        outputStream.write(name.getBytes());
        outputStream.write(0x00);
    }

    private static int getSize(List<String> fields) {
        int size = header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length;
        for (String field : fields) {
            size = size + field.getBytes().length + 1;
        }
        return size;
    }
}
