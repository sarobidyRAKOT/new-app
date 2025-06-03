package itu.mg.new_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api")
public class ApiProperties {
    
    private String cle;
    private String secret;
    private String baseUrl;
    private final String API_list = "/api/method/frappe.client.get_list";
    private final String API_once = "/api/method/frappe.client.get";
    private final String API_submit = "/api/method/frappe.desk.form.save.savedocs";

    // getters & setters
    public String getCle() { return cle; }
    public void setCle(String cle) { this.cle = cle; }
    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    public String getBaseUrl() { return baseUrl; }
    public String getToken() { return cle + ":" + secret;  }

    public String getAPI_list() {
        return API_list;
    }

    public String getAPI_submit() {
        return API_submit;
    }
    public String getAPI_once() {
        return API_once;
    }
}
