package com.renanalmeida.pixeon.domain;

public class Exam {
	
	private HealthCareInstitution healthCareInstitution;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private String physicianName;
	private int physicianCRM;
	private String procedureName;
	private int examId;
	
	public Exam (HealthCareInstitution healthcareInstitution, String patientName, int patientAge, String patientGender, String physicianName,
                 int physicianCRM, String procedureName) {
		
		this.setHealthcareInstitution(healthcareInstitution);
		this.setPatientName(patientName);
		this.setPatientAge(patientAge);
		this.setPatientGender(patientGender);
		this.setPhysicianName(physicianName);
		this.setPhysicianCRM(physicianCRM);
		this.setProcedureName(procedureName);
	}
	
	public Exam () {}
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public HealthCareInstitution getHealthcareInstitution() {
		return healthCareInstitution;
	}
	public void setHealthcareInstitution(HealthCareInstitution healthcareInstitution) {
		healthCareInstitution = healthcareInstitution;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPhysicianName() {
		return physicianName;
	}
	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}
	public int getPhysicianCRM() {
		return physicianCRM;
	}
	public void setPhysicianCRM(int physicianCRM) {
		this.physicianCRM = physicianCRM;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
}
