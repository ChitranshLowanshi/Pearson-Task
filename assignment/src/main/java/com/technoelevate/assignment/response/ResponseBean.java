package com.technoelevate.assignment.response;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status_code", "message", "description" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean implements Serializable {
	private int status_code;
	private String message;
	private String description;
	private ArrayList json;
	private String json1;

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList getJson() {
		return json;
	}

	public void setJson(ArrayList json) {
		this.json = json;
	}

	public String getJson1() {
		return json1;
	}

	public void setJson1(String json1) {
		this.json1 = json1;
	}

	@Override
	public String toString() {
		return "ResponseBean [status_code=" + status_code + ", message=" + message + ", description=" + description
				+ ", json=" + json + ", json1=" + json1 + "]";
	}

}