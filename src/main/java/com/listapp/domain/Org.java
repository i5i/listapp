package com.listapp.domain;
//import java.io.Serializable;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table( name = "ORG" )
public class Org{
   // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    @NotEmpty
    private String name;
    private String type;
    private String location;
    private Float averageGrade;
    private Integer numberOfRatings;
    
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type =type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfRatings() {
		if (numberOfRatings != null) {
			  return numberOfRatings.intValue();}
			else
			  return 0;
	}

	public void setNumberOfRatings(Integer count) {
		this.numberOfRatings = count;
	}

	public Float getAverageGrade() {
		if(averageGrade != null){
			return averageGrade;
		}else{
			return (float) 0;
		}
        
	}

	public void setAverageGrade(Float average) {
		this.averageGrade = average;
	}

}
