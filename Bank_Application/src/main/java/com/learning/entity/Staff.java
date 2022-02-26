/**
 * 
 */
package com.learning.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 2:07:30 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Staff extends User{
	private EnabledStatus status = EnabledStatus.ENABLED;
	@OneToMany
	private Set<Role> roles;

}
