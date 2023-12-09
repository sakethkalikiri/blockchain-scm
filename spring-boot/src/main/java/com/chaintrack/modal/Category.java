package com.chaintrack.modal;

import java.util.HashSet;
import java.util.Set;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Property()
    private Long categoryId;

    @NotNull
    @Size(max = 50)
	@Property()
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_category_id")
	@Property()
    private Category parentCategory;

	@Property()
    private int level;

}
