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
    public static final byte[] commandChar = {0x01};

    private String userName;
    private String passwd;

    public LoginCommand(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    private int getSize() {
        return CommandWriter.header.length +  CommandWriter.SIZE_LENGTH +  CommandWriter.CMD_BYTE_LENGTH + CommandWriter.footer.length +
                userName.getBytes().length + 1 +
                passwd.getBytes().length + 1;
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(CommandWriter.header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        CommandWriter.writeField(outputStream, userName);
        CommandWriter.writeField(outputStream, passwd);
        outputStream.write(CommandWriter.footer);
    }
}


