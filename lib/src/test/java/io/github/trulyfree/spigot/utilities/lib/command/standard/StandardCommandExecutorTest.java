package io.github.trulyfree.spigot.utilities.lib.command.standard;

import io.github.trulyfree.spigot.utilities.lib.command.standard.impl.SimpleCommandExecutionArguments;
import io.github.trulyfree.spigot.utilities.lib.command.standard.impl.SimpleStandardCommandExecutor;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardCommandExecutorTest {
    @Test
    public void onCommand() {
        StandardCommandExecutor standardCommandExecutor = new SimpleStandardCommandExecutor();
        standardCommandExecutor.setCommandHandlers(
                arguments -> true,
                SimpleCommandExecutionArguments::new
        );
        assertTrue(standardCommandExecutor.onCommand(
                null,
                null,
                null,
                null
        ));
        standardCommandExecutor.setCommandHandlers(
                arguments -> false,
                SimpleCommandExecutionArguments::new
        );
        assertFalse(standardCommandExecutor.onCommand(
                null,
                null,
                null,
                null
        ));
    }
}