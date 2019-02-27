package org.iscas.web.view;

import java.util.List;



public class DiseaseImageClasses {
	public DiseaseImageClasses() {
		// TODO Auto-generated constructor stub
	}
	private String disease_class;
	
	private Long imageCount;
	private List<CountImage> image_classes;
	
	public String getDisease_class() {
		return disease_class;
	}
	public void setDisease_class(String disease_class) {
		this.disease_class = disease_class;
	}
	public List<CountImage> getImage_classes() {
		return image_classes;
	}
	public void setImage_classes(List<CountImage> image_classes) {
		this.image_classes = image_classes;
	}
	public Long getImageCount() {
		return imageCount;
	}
	public void setImageCount(Long imageCount) {
		this.imageCount = imageCount;
	}
	
	
	
}
