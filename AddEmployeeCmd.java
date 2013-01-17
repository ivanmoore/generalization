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
        return Command.header.length +  Command.SIZE_LENGTH +  Command.CMD_BYTE_LENGTH + Command.footer.length +
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
        outputStream.write(Command.header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        Command.writeField(outputStream, name);
        Command.writeField(outputStream, address);
        Command.writeField(outputStream, city);
        Command.writeField(outputStream, state);
        Command.writeField(outputStream, yearlySalary);
        outputStream.write(Command.footer);
    }
}

