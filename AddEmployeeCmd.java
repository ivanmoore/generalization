/*
 * Created by IntelliJ IDEA.
 * User: bbutton
 * Date: Aug 1, 2002
 * Time: 9:34:33 AM
 * To change template for new class use 
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddEmployeeCmd {
    private static final byte[] commandChar = {0x02};

    List<String> fields = new ArrayList<String>();

    private int getSize() {
        int size = CommandWriter.header.length + CommandWriter.SIZE_LENGTH + CommandWriter.CMD_BYTE_LENGTH + CommandWriter.footer.length;
        for (String field : fields) {
            size = size + field.getBytes().length + 1;
        }
        return size;
    }

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        fields.add(name);
        fields.add(address);
        fields.add(city);
        fields.add(state);
        fields.add(Integer.toString(yearlySalary));
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(CommandWriter.header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        for (String field : fields) {
            CommandWriter.writeField(outputStream, field);
        }
        outputStream.write(CommandWriter.footer);
    }
}

