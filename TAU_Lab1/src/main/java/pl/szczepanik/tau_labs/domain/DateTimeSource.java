package pl.szczepanik.tau_labs.domain;
import pl.szczepanik.tau_labs.interfaces.TimeSource;

import java.util.Date;

public class DateTimeSource implements TimeSource{
    public long getCurrentDate() {
        return new Date().getTime();
    }
}
