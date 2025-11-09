import CLI.CLI;
import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import domainLogic.Administration;
import domainLogic.AudioImpl;
import domainLogic.UploaderImpl;

import java.math.BigDecimal;
import java.util.Collections;

public class CLIMain {
    public static void main(String[] args) {

        CLI cli = new CLI();

        cli.start();
    }
}
