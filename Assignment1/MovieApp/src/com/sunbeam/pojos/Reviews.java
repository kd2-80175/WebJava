package com.sunbeam.pojos;




import java.util.Date;

public class Reviews {
private int id;
private int movie_id;
private String review;
private int rating;
private int user_id;
private Date modified;
public Reviews() {
	id=0;
	movie_id=0;
	
	
}

public Reviews(int id, int movie_id, String review, int rating, int user_id, Date modified) {
	super();
	this.id = id;
	this.movie_id = movie_id;
	this.review = review;
	this.rating = rating;
	this.user_id = user_id;
	this.modified = modified;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getMovieid() {
	return movie_id;
}

public void setMovieid(int movie_id) {
	this.movie_id = movie_id;
}

public String getReview() {
	return review;
}

public void setReview(String review) {
	this.review = review;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public int getUserid() {
	return user_id;
}

public void setUserid(int user_id) {
	this.user_id = user_id;
}

public Date getModified() {
	return modified;
}

public void setModified(Date modified) {
	this.modified = modified;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((modified == null) ? 0 : modified.hashCode());
	result = prime * result + movie_id;
	result = prime * result + rating;
	result = prime * result + ((review == null) ? 0 : review.hashCode());
	result = prime * result + user_id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Reviews other = (Reviews) obj;
	if (id != other.id)
		return false;
	if (modified == null) {
		if (other.modified != null)
			return false;
	} else if (!modified.equals(other.modified))
		return false;
	if (movie_id != other.movie_id)
		return false;
	if (rating != other.rating)
		return false;
	if (review == null) {
		if (other.review != null)
			return false;
	} else if (!review.equals(other.review))
		return false;
	if (user_id != other.user_id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Reviews [id=" + id + ", movie_id=" + movie_id + ", review=" + review + ", rating=" + rating + ", user_id="
			+ user_id + ", modified=" + modified + "]";
}





}
