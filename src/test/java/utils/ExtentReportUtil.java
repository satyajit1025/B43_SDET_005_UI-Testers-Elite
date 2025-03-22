package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static boolean isInitialized = false;

    public static void initReports() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        isInitialized = true;
    }

    public static boolean isReportInitialized() {
        return isInitialized;
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logTestStep(String message, String status) {
        if (status.equalsIgnoreCase("pass")) {
            test.pass(message);
        } else if (status.equalsIgnoreCase("fail")) {
            test.fail(message);
        } else if (status.equalsIgnoreCase("skip")) {
            test.skip(message);
        }
    }

    public static void flushReports() {
        extent.flush();
    }
}
