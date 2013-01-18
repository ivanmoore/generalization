/*
 * Created by IntelliJ IDEA.
 * User: bbutton
 * Date: Jul 31, 2002
 * Time: 11:30:29 PM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.io.OutputStream;

public class LoginCommand {
    private final CommandWriter commandWriter;

    public LoginCommand(String userName, String passwd) {
        commandWriter = new CommandWriter((byte) 0x01);
        commandWriter.add(userName);
        commandWriter.add(passwd);
    }

    public void write(OutputStream outputStream) throws Exception {
        commandWriter.writeOnto(outputStream);
    }
}


