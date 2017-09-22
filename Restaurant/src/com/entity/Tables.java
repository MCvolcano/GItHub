package com.entity;

public class Tables {
	
	private Integer t_id;
	private String t_name;
	private String t_state;
	private String t_time;
	
	@Override
	public String toString() {
		return "Tables [t_id=" + t_id + ", t_name=" + t_name + ", t_state=" + t_state + ", t_time=" + t_time + "]";
	}
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_state() {
		return t_state;
	}
	public void setT_state(String t_state) {
		this.t_state = t_state;
	}
	public String getT_time() {
		return t_time;
	}
	public void setT_time(String t_time) {
		this.t_time = t_time;
	}
	
	
}
