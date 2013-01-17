/*
 * Created by IntelliJ IDEA.
 * User: bbutton
 * Date: Aug 1, 2002
 * Time: 9:34:33 AM
 * To change template for new class use 
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.io.OutputStream;

public class AddEmployeeCmd {
    private static final byte[] commandChar = {0x02};

    String name;
    String address;
    String city;
    String state;
    String yearlySalary;

    private int getSize() {
        return CommandWriter.header.length +  CommandWriter.SIZE_LENGTH +  CommandWriter.CMD_BYTE_LENGTH + CommandWriter.footer.length +
                name.getBytes().length + 1 +
                address.getBytes().length + 1 +
                city.getBytes().length + 1 +
                state.getBytes().length + 1 +
                yearlySalary.getBytes().length + 1;
    }

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.yearlySalary = Integer.toString(yearlySalary);
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(CommandWriter.header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        CommandWriter.writeField(outputStream, name);
        CommandWriter.writeField(outputStream, address);
        CommandWriter.writeField(outputStream, city);
        CommandWriter.writeField(outputStream, state);
        CommandWriter.writeField(outputStream, yearlySalary);
        outputStream.write(CommandWriter.footer);
    }
}

