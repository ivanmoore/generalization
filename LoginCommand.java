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
    private CommandWriter commandWriter;

    public LoginCommand(String userName, String passwd) {
        fields.add(userName);
        fields.add(passwd);
        commandWriter = new CommandWriter(commandChar, fields);
    }

    public void write(OutputStream outputStream) throws Exception {
        commandWriter.write(outputStream);
    }
}


