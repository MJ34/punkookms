package com.mujidev.punkookms.hr.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
    
    private String title;

    @Lob
    private String jobDetail;
    private String location;
    private Integer vacancy;
    private String gender;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String banner;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiredDate;

    private boolean isActivated;
}
