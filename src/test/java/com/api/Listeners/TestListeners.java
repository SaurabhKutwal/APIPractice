package com.api.Listeners;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListeners.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test \"{}\" execution started.",result.getName());
        logger.info("Test Description : \"{}\"",result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: \"{}\"",result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: \"{}\"",result.getName());
        logger.error("Exception: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test Skipped : \"{}\"",result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test suite execution started......");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite execution finished......");
    }
}
