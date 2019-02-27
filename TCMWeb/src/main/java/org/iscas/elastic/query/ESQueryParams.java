package org.iscas.elastic.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ESQueryParams {
	public ESQueryParams(String targetIndex) {
		super();
		this.targetIndex = targetIndex;
		this.fields = new ArrayList<>();
		this.sources = new ArrayList<>();
	}
	
	public void appendESFiled(ESField field) {
		this.fields.add(field);
	}

	public void appendESSource(ESSource source) {
		this.sources.add(source);
	}
	
	public String targetIndex;
	public List<ESField> fields = null;
	public List<ESSource> sources = null;
	
	public static class ESField{
		public String field;
		public float weigth;
		public ESField(String field, float weigth) {
			super();
			this.field = field;
			this.weigth = weigth;
		}
		
	}
	
	public static class ESSource{
		public String source;

		public ESSource(String source) {
			super();
			this.source = source;
		}
	}
}
