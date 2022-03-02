package edu.jsu.mcis.cs310.tas_sp22;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Punch {
    private int id, terminalid, eventtypeid, punchtypeid;
    private String adjustmenttype, badgeid;
    private LocalDateTime timestamp, adjustedTS;
    private Badge badge;
    
    public Punch(int terminalid, Badge badge, int punchtypeid) {
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        id = eventtypeid = 0;
        adjustmenttype = badgeid = null;
        timestamp = null;
    }
    
    public Punch(HashMap<String, String> params) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        id = Integer.valueOf(params.get("id"));
        terminalid = Integer.valueOf(params.get("terminalid"));
        eventtypeid = Integer.valueOf(params.get("eventtypeid"));
        badgeid = params.get("badgeid");
        timestamp = LocalDateTime.parse(params.get("timestamp"), dtf);
    }
    
    @Override
    public String toString() {
        return printOriginal();
    }
    
    public String printOriginal() {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(badgeid).append(" ");
        switch (eventtypeid) {
            case 0:
                sb.append(PunchType.CLOCK_OUT);
                break;
            case 1:
                sb.append(PunchType.CLOCK_IN);
                break;
            case 2:
                sb.append(PunchType.TIME_OUT);
                break;
        }
        sb.append(": ").append(timestamp.getDayOfWeek().toString().substring(0, 3)).append(" ");
        sb.append(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(timestamp));
        return sb.toString();
    }
}