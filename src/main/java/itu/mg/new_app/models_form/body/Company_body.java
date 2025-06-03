package itu.mg.new_app.models_form.body;

import java.util.Objects;

public class Company_body {
    
    private String company_name;
    private String abbr;
    private String default_currency = "EUR";
    private String country = "Madagascar";


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

    public Company_body (String company_name, String abbr) {
        setAbbr(abbr);
        setCompany_name(company_name);
    }

    public String getAbbr() { return abbr; }
    public String getCompany_name() { return company_name; }
    public String getCountry() { return country; }
    public String getDefault_currency() { return default_currency; }

    public void setAbbr(String abbr) { this.abbr = abbr; }
    public void setCompany_name(String company_name) { this.company_name = company_name; }
    public void setCountry(String country) { this.country = country; }
    public void setDefault_currency(String default_currency) { this.default_currency = default_currency; }
}
