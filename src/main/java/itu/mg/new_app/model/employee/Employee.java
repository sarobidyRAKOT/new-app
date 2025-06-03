package itu.mg.new_app.model.employee;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.*;

public class Employee {

    private String name;
    private String owner;
    private String modified_by;
    private int docstatus;
    private int idx;
    private String employee;
    private String naming_series;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String employee_name;
    private String gender;
    private String image;
    private String status;
    private String user_id;
    private int create_user_permission;
    private String company;
    private String department;
    private String employment_type;
    private String employee_number;
    private String designation;
    private String reports_to;
    private String branch;
    private String grade;
    private String job_applicant;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;
    private String salutation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_joining;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;
    


    public Employee() {}


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }
    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    public String getModified_by() { return modified_by; }
    public void setModified_by(String modified_by) { this.modified_by = modified_by; }

    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }
    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }
    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getBranch() { return branch; }
    public String getCompany() { return company; }
    public int getCreate_user_permission() { return create_user_permission; }
    public LocalDate getDate_of_birth() { return date_of_birth; }
    public LocalDate getDate_of_joining() { return date_of_joining; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public String getEmployee_name() { return employee_name; }
    public String getEmployee_number() { return employee_number; }
    public String getEmployment_type() { return employment_type; }
    public String getFirst_name() { return first_name; }
    public String getGender() { return gender; }
    public String getGrade() { return grade; }
    public String getImage() { return image; }
    public String getJob_applicant() { return job_applicant; }
    public String getLast_name() { return last_name; }
    public String getMiddle_name() { return middle_name; }
    public String getNaming_series() { return naming_series; }
    public String getReports_to() { return reports_to; }
    public String getSalutation() { return salutation; }
    public String getStatus() { return status; }
    public String getUser_id() { return user_id; }

    public void setBranch(String branch) { this.branch = branch; }
    public void setCompany(String company) { this.company = company; }
    public void setCreate_user_permission(int create_user_permission) { this.create_user_permission = create_user_permission; }
    public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }
    public void setDate_of_joining(LocalDate date_of_joining) { this.date_of_joining = date_of_joining; }
    public void setDepartment(String department) { this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }
    public void setEmployee_number(String employee_number) { this.employee_number = employee_number; }
    public void setEmployment_type(String employment_type) { this.employment_type = employment_type; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setImage(String image) { this.image = image; }
    public void setJob_applicant(String job_applicant) { this.job_applicant = job_applicant; }
    public void setLast_name(String last_name) { this.last_name = last_name; }
    public void setMiddle_name(String middle_name) { this.middle_name = middle_name; }
    public void setNaming_series(String naming_series) { this.naming_series = naming_series; }
    public void setReports_to(String reports_to) { this.reports_to = reports_to; }
    public void setSalutation(String salutation) { this.salutation = salutation; }
    public void setStatus(String status) { this.status = status; }
    public void setUser_id(String user_id) { this.user_id = user_id; }

}
