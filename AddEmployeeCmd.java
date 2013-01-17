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
    private List<String> fields = new ArrayList<String>();

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        fields.add(name);
        fields.add(address);
        fields.add(city);
        fields.add(state);
        fields.add(Integer.toString(yearlySalary));
    }

    public void write(OutputStream outputStream) throws Exception {
        new CommandWriter(outputStream, commandChar).write(fields);
    }
}

