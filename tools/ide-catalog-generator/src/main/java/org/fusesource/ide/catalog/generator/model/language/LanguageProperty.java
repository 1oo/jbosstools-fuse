/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 

package org.fusesource.ide.catalog.generator.model.language;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lhein
 *
 */
public class LanguageProperty {
	private String kind;
	private String required;
	private String type;
	private String javaType;
	private String deprecated;
	private String description;
	private String defaultValue;
	private String name;
	@JsonProperty("enum")
	private String[] choice;
	private String secret;
	
	/**
	 * @return the choice
	 */
	public String[] getChoice() {
		return this.choice;
	}
	
	/**
	 * @param choice the choice to set
	 */
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	/**
	 * @return the deprecated
	 */
	public String getDeprecated() {
		return this.deprecated;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return the javaType
	 */
	public String getJavaType() {
		return this.javaType;
	}
	
	/**
	 * @return the required
	 */
	public String getRequired() {
		return this.required;
	}
	
	/**
	 * @return the kind
	 */
	public String getKind() {
		return this.kind;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		this.defaultValue = this.defaultValue.replace("\"", "&quot;");
		this.defaultValue = this.defaultValue.replace("\r", "\\r");
		this.defaultValue = this.defaultValue.replace("\n", "\\n");
	}
	
	/**
	 * @param deprecated the deprecated to set
	 */
	public void setDeprecated(String deprecated) {
		this.deprecated = deprecated;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
		this.description = this.description.replace("\"", "&quot;");
		this.description = this.description.replace("\r", "\\r");
		this.description = this.description.replace("\n", "\\n");
	}
	
	/**
	 * @param javaType the javaType to set
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
		this.javaType = this.javaType.replaceAll("<", "&lt;");
		this.javaType = this.javaType.replaceAll(">", "&gt;");
	}
	
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	/**
	 * @param required the required to set
	 */
	public void setRequired(String required) {
		this.required = required;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public String getChoiceString() {
		if (this.choice == null || this.choice.length<1) {
			return null;
		}
		StringBuilder retVal = new StringBuilder();
		for (String c : this.choice) {
			if (retVal.length()>0) {
				retVal.append(","); 
			}
			retVal.append(c);
		}
		return retVal.toString();
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
