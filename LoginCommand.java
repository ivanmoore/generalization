/*
 * Created by IntelliJ IDEA.
 * User: bbutton
 * Date: Jul 31, 2002
 * Time: 11:30:29 PM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand {
    public static final byte[] commandChar = {0x01};
    private List<String> fields = new ArrayList<String>();

    public LoginCommand(String userName, String passwd) {
        fields.add(userName);
        fields.add(passwd);
    }

    public void write(OutputStream outputStream) throws Exception {
        new CommandWriter(outputStream, commandChar).write(fields);
    }
}


