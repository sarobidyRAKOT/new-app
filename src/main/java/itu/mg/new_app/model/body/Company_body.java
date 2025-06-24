package itu.mg.new_app.model.body;

import java.util.Objects;

public class Company_body {
    
    private String company_name;
    private String abbr;
    private String default_currency = "EUR";
    private String country = "Madagascar";
    private String default_holiday_list;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Company_body c = (Company_body) obj;

        return Objects.equals(this.company_name, c.company_name) &&
            Objects.equals(this.abbr, c.abbr) &&
            Objects.equals(this.country, c.country) &&
            Objects.equals(this.default_currency, c.default_currency) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(company_name, abbr, country, default_currency);
    }

    public Company_body (String company_name, String abbr, String holiday_List_name) {
        setAbbr(abbr);
        setDefault_holiday_list(holiday_List_name);
        setCompany_name(company_name);
    }


    public String getDefault_holiday_list() {
        return default_holiday_list;
    }
    public String getAbbr() { return abbr; }
    public String getCompany_name() { return company_name; }
    public String getCountry() { return country; }
    public String getDefault_currency() { return default_currency; }

    public void setDefault_holiday_list(String default_holiday_list) {
        this.default_holiday_list = default_holiday_list;
    }
    public void setAbbr(String abbr) { this.abbr = abbr; }
    public void setCompany_name(String company_name) { this.company_name = company_name; }
    public void setCountry(String country) { this.country = country; }
    public void setDefault_currency(String default_currency) { this.default_currency = default_currency; }
}
