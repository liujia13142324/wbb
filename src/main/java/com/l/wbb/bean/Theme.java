package com.l.wbb.bean;

public class Theme {

	private Integer themeId ;
	private String themeName;
	@Override
	public String toString() {
		return "Theme [themeId=" + themeId + ", themeName=" + themeName + "]";
	}
	public Theme(Integer themeId, String themeName) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
	}
	public Theme() {
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
}
