package kz.kbtu.oop.projectv2.logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LogsAspect {
    public static final Logger globalLogger = Logger.getLogger("global_logs");
    public static final Logger userLogger = Logger.getLogger("user_logs");

    static {
        FileHandler userFileHandler, globalFileHandler;
        try {
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            userFileHandler = new FileHandler("logs/user.log", true);
            globalFileHandler = new FileHandler("logs/global.log", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userFileHandler.setFormatter(new CustomLogsFormatter());
        globalFileHandler.setFormatter(new CustomLogsFormatter());
        userLogger.addHandler(userFileHandler);
        globalLogger.addHandler(globalFileHandler);
    }

    /**
     * logs every method's call
     */
    @Pointcut("execution(* *(..)) " +
            "&& !execution(String ILogged.logMessage()) " +
            "&& !within(LogsAspect+) " +
            "&& !execution(* *.toString()) " +
            "&& !within(CustomLogsFormatter+)")
    private void anyMethod() {
    }
/*
    *//**
     * Aspect that cover every method
     * Except ILogged.*, LogsAspect.*, *.toString, CustomLogsFormatter.*
     *//*
    @Around("anyMethod()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        String logMessage = "class=" + className + "~method=" + methodName + "~args=" + arguments;

        globalLogger.log(Level.INFO, "call~" + logMessage);
        if (joinPoint.getTarget() instanceof ILogged target) {
            userLogger.log(Level.INFO, "call~" + logMessage + '~' + target.logMessage());
        }

        Object result = joinPoint.proceed();

        globalLogger.log(Level.INFO, "callback~" + logMessage + "~res=" + result);
        if (joinPoint.getTarget() instanceof ILogged target) {
            userLogger.log(Level.INFO, "callback~" + logMessage + '~' + target.logMessage() + "~res=" + result);
        }
        return result;
    }*/
}
