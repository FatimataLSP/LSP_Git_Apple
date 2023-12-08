package org.howard.edu.lsp.exam.problem51;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class TestLogger {
	@Test
    public void testDisplayLog() {
        Logger logger = Logger.getInstance();
        logger.logMessage("Test message 1");
        logger.logMessage("Test message 2");
        assertEquals("Log:\nTest message 1\nTest message 2\n", logger.displayLog());
    }

    @Test
    public void testLoggerInstances() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assertSame(logger1, logger2); 
    }
}


