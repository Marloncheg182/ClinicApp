package clinicspdata.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(generator = "increment", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date")
    private String birthDate;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "addition_notes")
    private String additionalNotes;

    // creating of relations between Card table and Patient.
    @OneToOne(optional = false, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    @OneToMany(mappedBy = "card")
    private List<Analysis> analysises;

    @OneToMany(mappedBy = "card")
    private List<Operation> operations;

    @OneToOne(optional = false, targetEntity = Insurance.class)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id", nullable = false)
    private Insurance insurance;

    @OneToMany(mappedBy = "card")
    private List<Procedure> procedure;

    public Card() {
    }

    public Card(String firstName, String lastName, String birthDate, String diagnosis, String symptoms, String additionalNotes, Patient patient) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.additionalNotes = additionalNotes;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Procedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(List<Procedure> procedure) {
        this.procedure = procedure;
    }

    public List<Analysis> getAnalysises() {
        return analysises;
    }

    public void setAnalysises(List<Analysis> analysises) {
        this.analysises = analysises;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", patient=" + patient +
                ", analysises=" + analysises +
                ", operations=" + operations +
                ", insurance=" + insurance +
                ", procedure=" + procedure +
                '}';
    }
}



