package kz.kbtu.oop.projectv2.logs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class CustomLogsFormatter extends Formatter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * returns log message
     * @param record the log record to be formatted.
     * return log message String
     */
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(dateFormat.format(new Date(record.getMillis())));
        sb.append(" [").append(record.getLevel()).append("] ");
        sb.append(formatMessage(record)).append("\n");
        return sb.toString();
    }
}