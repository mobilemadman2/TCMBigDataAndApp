package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table

public class Image extends IdEntity{
	@Column(columnDefinition = "TEXT")
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(columnDefinition = "TEXT")
	private String diseaseClass;
	
	@Column(columnDefinition = "TEXT")
	private String imageClass;
	
	private String imagePath;
	
	@Column(columnDefinition = "TEXT")
	private String groundTruth;
	
	private String source;
	
	private String sourceLink;
	
	public String getSource() {
		return source;
	}
	
	@Column(columnDefinition = "TEXT")
	private String illustration;

	public String getDiseaseClass() {
		return diseaseClass;
	}

	public void setDiseaseClass(String diseaseClass) {
		this.diseaseClass = diseaseClass;
	}

	public String getImageClass() {
		return imageClass;
	}

	public void setImageClass(String imageClass) {
		this.imageClass = imageClass;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getGroundTruth() {
		return groundTruth;
	}

	public void setGroundTruth(String groundTruth) {
		this.groundTruth = groundTruth;
	}

	public String getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

	public void setSource(String source) {
		this.source = source;
	}



	
}
