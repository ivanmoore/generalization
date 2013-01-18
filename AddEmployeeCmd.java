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
    private final CommandWriter commandWriter;

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        commandWriter = new CommandWriter((byte) 0x02);
        commandWriter.add(name);
        commandWriter.add(address);
        commandWriter.add(city);
        commandWriter.add(state);
        commandWriter.add(Integer.toString(yearlySalary));
    }

    public void write(OutputStream outputStream) throws Exception {
        commandWriter.write(outputStream);
    }
}

