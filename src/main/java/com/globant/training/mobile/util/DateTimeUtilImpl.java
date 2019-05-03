package com.globant.training.mobile.util;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateTimeUtilImpl implements DateTimeUtil {
    
    @Inject
    private SimpleDateFormat simpleDateFormat;
    
    @Override
    public String convertUnixDateToString(String pattern, long unixDate) {
        simpleDateFormat.applyPattern(pattern);
        
        return simpleDateFormat.format(new Date(unixDate * 1000));
    }
    
    @Override
    public String convertDateToString(String pattern, Date date) {
        simpleDateFormat.applyPattern(pattern);
    
        return simpleDateFormat.format(date);
    }
}
