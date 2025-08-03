package com.example;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("[Before] Method execution started.");
    }

    public void logAfterReturning() {
        System.out.println("[AfterReturning] Method executed successfully.");
    }

    public void logAfterThrowing(Exception ex) {
        System.out.println("[AfterThrowing] Exception occurred: " + ex.getMessage());
    }

    public Object logAround(org.aopalliance.intercept.MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[Around] Before method: " + invocation.getMethod().getName());
        try {
            Object result = invocation.proceed();
            System.out.println("[Around] After method: " + invocation.getMethod().getName());
            return result;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("[Around] Execution time: " + (end - start) + " ms");
        }
    }
}
