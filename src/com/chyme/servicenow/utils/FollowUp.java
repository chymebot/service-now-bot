package com.chyme.servicenow.utils;

public class FollowUp {
	
	private String suggestionText;
	
	private String text;
	
	public FollowUp(String suggestionText, String text) {
		super();
		this.suggestionText = suggestionText;
		this.text = text;
	}

	public String getSuggestionText() {
		return suggestionText;
	}

	public String getText() {
		return text;
	}
}
