package com.sing3demons.products_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Product {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	private String name;
	private String desc;
	private String image;
	private int price;
	private String category;
}
