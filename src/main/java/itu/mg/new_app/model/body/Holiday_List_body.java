package itu.mg.new_app.model.body;

public class Holiday_List_body {
    
    // Holiday List
    private String holiday_list_name = "My HoliDay";
    private String from_date = "2020-01-15";
    private String to_date = "2020-01-15";


    public Holiday_List_body () {}

    public String getHoliday_list_name() {return holiday_list_name;}
    public String getFrom_date() {return from_date;}
    public String getTo_date() {return to_date;}

    public void setFrom_date(String from_date) {this.from_date = from_date;}
    public void setHoliday_list_name(String holiday_list_name) {this.holiday_list_name = holiday_list_name;}
    public void setTo_date(String to_date) {this.to_date = to_date;}
}
