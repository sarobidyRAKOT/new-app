package itu.mg.new_app.model.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Holiday_List {
    private String name;
    private String owner;
    
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String holiday_list_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate from_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate to_date;
    private int total_holidays;
    private String weekly_off;
    private String country;      // Nullable
    private String subdivision;  // Nullable
    private String color;        // Nullable

    public Holiday_List () {}

    // Getters and setters (or use Lombok @Data if preferred)
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    // public LocalDateTime getCreation() { return creation; }
    // public void setCreation(LocalDateTime creation) { this.creation = creation; }

    // public LocalDateTime getModified() { return modified; }
    // public void setModified(LocalDateTime modified) { this.modified = modified; }

    public String getModified_by() { return modified_by; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }

    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }

    public String getHoliday_list_name() { return holiday_list_name; }
    public void setHoliday_list_name(String holiday_list_name) { this.holiday_list_name = holiday_list_name; }

    public LocalDate getFrom_date() { return from_date; }
    public void setFrom_date(LocalDate from_date) { this.from_date = from_date; }

    public LocalDate getTo_date() { return to_date; }
    public void setTo_date(LocalDate to_date) { this.to_date = to_date; }

    public int getTotal_holidays() { return total_holidays; }
    public void setTotal_holidays(int total_holidays) { this.total_holidays = total_holidays; }

    public String getWeekly_off() { return weekly_off; }
    public void setWeekly_off(String weekly_off) { this.weekly_off = weekly_off; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getSubdivision() { return subdivision; }
    public void setSubdivision(String subdivision) { this.subdivision = subdivision; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
