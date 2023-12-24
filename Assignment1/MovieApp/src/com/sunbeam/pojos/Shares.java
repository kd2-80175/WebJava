package com.sunbeam.pojos;



import java.util.Date;

public class Shares {
	private int review_id;
	private int user_id;
	private Date release;
	
	public Shares() {
		
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Shares(int review_id, int user_id, Date release) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.release = release;
	}

	@Override
	public String toString() {
		return "Shares [review_id=" + review_id + ", user_id=" + user_id + ", release=" + release + "]";
	}
	
	public void accept() {
		
	}

}

