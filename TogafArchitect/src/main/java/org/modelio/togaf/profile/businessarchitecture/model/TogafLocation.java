/** 
 * Licensed to the Apache Software Foundation (ASF) under one 
 * or more contributor license agreements.  See the NOTICE file 
 * distributed with this work for additional information 
 * regarding copyright ownership.  The ASF licenses this file 
 * to you under the Apache License, Version 2.0 (the 
 * "License"); you may not use this file except in compliance 
 * with the License.  You may obtain a copy of the License at 
 * 
 *	http://www.apache.org/licenses/LICENSE-2.0 
 * 
 *	Unless required by applicable law or agreed to in writing, 
 *	software distributed under the License is distributed on an 
 *	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 *	KIND, either express or implied.  See the License for the 
 *	specific language governing permissions and limitations 
 *	under the License. 
 * 
 * 
 * @package    org.modelio.togaf. 
 * @author     Modelio 
 * @license    http://www.apache.org/licenses/LICENSE-2.0 
 * @version  1.0.00 
 **/
package org.modelio.togaf.profile.businessarchitecture.model;

import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Node;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.togaf.impl.TogafArchitectModule;
import org.modelio.togaf.profile.structure.model.BusinessArchitecture;
import org.modelio.togaf.profile.structure.model.TechnologyArchitecture;
import org.modelio.togaf.profile.utils.ModelUtils;
import org.modelio.togaf.profile.utils.ResourceManager;

public class TogafLocation {
	protected Node element;

	public TogafLocation() {
		this.element = TogafArchitectModule.getInstance().getModuleContext().getModelingSession().getModel().createNode();
		ModelUtils.setStereotype(this.element, "TogafArchitect","TogafLocation");
		this.element.setName(ResourceManager.getName("TogafLocation"));
	}

	public TogafLocation(Node element) {
		this.element = element;
	}

	public Node getElement() {
		return this.element;
	}

	public void setParent(ModelTree parent) {
		this.element.setOwner(parent);
	}

	public void setParent(TemplateParameter parent) {
		this.element.setOwnerTemplateParameter(parent);
	}

	public String getcategory() {
		String res = ModelUtils.getTaggedValue("TogafLocation_category", this.element);
		if (res.equals("")) {
			res = "";
		}
		return res;
	}

	public void setcategory(String value) {
		ModelUtils.addValue("TogafArchitect","TogafLocation_category", value, this.element);
	}

	public BusinessArchitecture getBusinessArchitecture() {
		return new BusinessArchitecture((Package) this.element.getOwner());
	}

	public void addBusinessArchitecture(BusinessArchitecture model) {
		this.element.setOwner(model.getElement());
	}

	public TechnologyArchitecture getTechnologyArchitecture() {
		return new TechnologyArchitecture((Package) this.element.getOwner());
	}

	public void addTechnologyArchitecture(TechnologyArchitecture model) {
		this.element.setOwner(model.getElement());
	}

}
