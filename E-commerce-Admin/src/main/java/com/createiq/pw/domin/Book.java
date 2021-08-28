package com.createiq.pw.domin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "book_tab")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message="Title should not blank")
	@Pattern(regexp = "([A-Z])\\w+",message="It should not allow Numbers")
	private String title;
	@NotEmpty(message="Author should not blank")
	private String author;
	@NotEmpty(message="Publisher should not blank")
	@Size(message="Publisher length should be min 10 char", min = 10)
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
	private int numberOfPages;
	private String format;
	private int isbn;
	private double shippingWeight;
	private double listPrice;
	private double ourPrice;
	private boolean active=true;
	
	@Column(columnDefinition="text")
	private String description;
	private int inStockNumber;
	
	@Transient
	private MultipartFile bookImage;
	
	
	
	
}
