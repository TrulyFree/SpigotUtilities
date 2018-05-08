package io.github.trulyfree.spigot.utilities.lib.command.standard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class StandardCommandExecutionArgumentsTest {
    private static StandardCommandExecutionArguments arguments;

    @BeforeClass
    public static void setUp() {
        arguments = new StandardCommandExecutionArguments();
    }

    @AfterClass
    public static void tearDown() {
        arguments = null;
    }

    @Test(expected = NullPointerException.class)
    public void setSender() {
        //noinspection ConstantConditions
        arguments.setSender(null);
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void setCommand() {
        //noinspection ConstantConditions
        arguments.setCommand(null);
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void setLabel() {
        //noinspection ConstantConditions
        arguments.setLabel(null);
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void setArgsNull() {
        //noinspection ConstantConditions
        arguments.setArgs(null);
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void setArgsWithNulls() {
        arguments.setArgs(new String[]{null});
        fail();
    }
}