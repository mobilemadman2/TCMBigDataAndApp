package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "expert_medical_case")
public class MedicalCase extends IdEntity {
	private String case_title;
	
	private String doctor_name;
	
	private String department;
	
	private String patient_name;
	
	private String gender;
	
	private String birth_day;
	
	private String treatment_time;
	
	private String solar_term;
	
	@Column(columnDefinition = "TEXT")
	private String patient_description;
	
	@Column(columnDefinition = "TEXT")
	private String current_illness_history;
	
	private String tongue_symptom;
	
	private String pulse_symptom;
	
	@Column(columnDefinition = "TEXT")
	private String current_symptom;
	
	@Column(columnDefinition = "TEXT")
	private String illness_history;
	
	
	@Column(columnDefinition = "TEXT")
	private String personal_history;
	
	
	
	@Column(columnDefinition = "TEXT")
	private String allergy_history;
	
	
	@Column(columnDefinition = "TEXT")
	private String marriage_history;
	
	
	@Column(columnDefinition = "TEXT")
	private String family_history;
	
	@Column(columnDefinition = "TEXT")
	private String assist_exam;
	
	
	@Column(columnDefinition = "TEXT")
	private String symptom_analysis;
	
	private String tcm_diagnosis;
	
	private String wm_diagnosis;
	
	
	@Column(columnDefinition = "TEXT")
	private String tcm_syndrome;
	
	
	@Column(columnDefinition = "TEXT")
	private String therapeutic;
	
	private String prescription;
	
	@Column(columnDefinition = "TEXT")
	private String composition;
	
	@Column(columnDefinition = "TEXT")
	private String usages;
	
	@Column(columnDefinition = "TEXT")
	private String doctor_comments;
	
	
	@Column(columnDefinition = "TEXT")
	private String acupuncture;
	
	public String getCase_title() {
		return case_title;
	}

	public void setCase_title(String case_title) {
		this.case_title = case_title;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public String getTreatment_time() {
		return treatment_time;
	}

	public void setTreatment_time(String treatment_time) {
		this.treatment_time = treatment_time;
	}

	public String getSolar_term() {
		return solar_term;
	}

	public void setSolar_term(String solar_term) {
		this.solar_term = solar_term;
	}

	public String getPatient_description() {
		return patient_description;
	}

	public void setPatient_description(String patient_description) {
		this.patient_description = patient_description;
	}

	public String getCurrent_illness_history() {
		return current_illness_history;
	}

	public void setCurrent_illness_history(String current_illness_history) {
		this.current_illness_history = current_illness_history;
	}

	public String getTongue_symptom() {
		return tongue_symptom;
	}

	public void setTongue_symptom(String tongue_symptom) {
		this.tongue_symptom = tongue_symptom;
	}

	public String getPulse_symptom() {
		return pulse_symptom;
	}

	public void setPulse_symptom(String pulse_symptom) {
		this.pulse_symptom = pulse_symptom;
	}

	public String getCurrent_symptom() {
		return current_symptom;
	}

	public void setCurrent_symptom(String current_symptom) {
		this.current_symptom = current_symptom;
	}

	public String getIllness_history() {
		return illness_history;
	}

	public void setIllness_history(String illness_history) {
		this.illness_history = illness_history;
	}

	public String getPersonal_history() {
		return personal_history;
	}

	public void setPersonal_history(String personal_history) {
		this.personal_history = personal_history;
	}

	public String getAllergy_history() {
		return allergy_history;
	}

	public void setAllergy_history(String allergy_history) {
		this.allergy_history = allergy_history;
	}

	public String getMarriage_history() {
		return marriage_history;
	}

	public void setMarriage_history(String marriage_history) {
		this.marriage_history = marriage_history;
	}

	public String getFamily_history() {
		return family_history;
	}

	public void setFamily_history(String family_history) {
		this.family_history = family_history;
	}

	public String getAssist_exam() {
		return assist_exam;
	}

	public void setAssist_exam(String assist_exam) {
		this.assist_exam = assist_exam;
	}

	public String getSymptom_analysis() {
		return symptom_analysis;
	}

	public void setSymptom_analysis(String symptom_analysis) {
		this.symptom_analysis = symptom_analysis;
	}

	public String getTcm_diagnosis() {
		return tcm_diagnosis;
	}

	public void setTcm_diagnosis(String tcm_diagnosis) {
		this.tcm_diagnosis = tcm_diagnosis;
	}

	public String getWm_diagnosis() {
		return wm_diagnosis;
	}

	public void setWm_diagnosis(String wm_diagnosis) {
		this.wm_diagnosis = wm_diagnosis;
	}

	public String getTcm_syndrome() {
		return tcm_syndrome;
	}

	public void setTcm_syndrome(String tcm_syndrome) {
		this.tcm_syndrome = tcm_syndrome;
	}

	public String getTherapeutic() {
		return therapeutic;
	}

	public void setTherapeutic(String therapeutic) {
		this.therapeutic = therapeutic;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getUsages() {
		return usages;
	}

	public void setUsages(String usages) {
		this.usages = usages;
	}

	public String getDoctor_comments() {
		return doctor_comments;
	}

	public void setDoctor_comments(String doctor_comments) {
		this.doctor_comments = doctor_comments;
	}

	public String getAcupuncture() {
		return acupuncture;
	}

	public void setAcupuncture(String acupuncture) {
		this.acupuncture = acupuncture;
	}

	public String getPoint_select() {
		return point_select;
	}

	public void setPoint_select(String point_select) {
		this.point_select = point_select;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	@Column(columnDefinition = "TEXT")
	private String point_select;
	
	@Column(columnDefinition = "TEXT")
	private String massage;
}
