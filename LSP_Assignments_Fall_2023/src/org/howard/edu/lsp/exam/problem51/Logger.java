package org.howard.edu.lsp.exam.problem51;

/**
 * Logger class represents a simple logging utility that maintains a log of messages.
 * This version is implemented as a Singleton pattern ensuring that only one instance of Logger exists.
 */
public class Logger {
	private static Logger instance;
    private String log;

    private Logger() {
        this.log = "";
    }

    /**
     * Gets the instance of the Logger class.
     * If no instance exists, it creates a new one; or, it returns the existing instance.
     * @return The Logger instance
     */
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * This adds a message to the log.
     * @param message The message to be added to the log
     */
    public void logMessage(String message) {
        this.log += message + "\n";
    }
    
    /**
     * This displays the current log content.
     * @return The log content as a string
     */
    public String displayLog() {
        return "Log:\n" + log;
    }
}
	


