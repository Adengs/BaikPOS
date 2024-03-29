package com.codelabs.konspirasisnack.service;

import android.content.Context;

import androidx.annotation.NonNull;

import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import java.util.EnumMap;

public class CrashSender implements ReportSender {


    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        EnumMap<ReportField, String> report = new CrashReportData();
        report.put(ReportField.ANDROID_VERSION, errorContent.get(ReportField.ANDROID_VERSION));
        report.put(ReportField.APP_VERSION_CODE, errorContent.get(ReportField.APP_VERSION_CODE));
        report.put(ReportField.APP_VERSION_NAME, errorContent.get(ReportField.APP_VERSION_NAME));
        report.put(ReportField.BRAND, errorContent.get(ReportField.BRAND));
        report.put(ReportField.PHONE_MODEL, errorContent.get(ReportField.PHONE_MODEL));
        report.put(ReportField.STACK_TRACE, errorContent.get(ReportField.STACK_TRACE));


    }
}
