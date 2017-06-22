/*
 * Copyright (C) 2017 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dacstpi.beans.converters;

import dacstpi.dao.ComisionFijaDao;
import dacstpi.dao.ComisionPorcentualDao;
import dacstpi.dao.DaoException;
import dacstpi.model.ComisionFija;
import dacstpi.model.ComisionPorcentual;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ComisionPorcentualConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(ComisionPorcentualConverter.class);
	
	// Dependencies -----------------------------------------------------------
	
    @EJB
    private ComisionPorcentualDao dao;
	
	// Overrides --------------------------------------------------------------

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (context == null || component == null) {
			throw new NullPointerException();
		}

		// If the specified value is null or zero-length, return null
		if (value == null || "null".equals(value)) {
			return (null);
		}
		value = value.trim();
		if (value.length() < 1) {
			return (null);
		}

		Long id;
		try {
			if (logger.isTraceEnabled())
				logger.trace("Converting Entity with id: " + value);

			id = Long.parseLong(value);

			ComisionPorcentual entity = dao.findById(id);

			if (logger.isTraceEnabled())
				logger.trace("Entity converted: " + entity);

			return entity;
		} catch (NumberFormatException e) {
			logger.error(e.getMessage());
		} catch (DaoException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
		try {
			return String.valueOf(((ComisionPorcentual) value).getId());
		} catch (ClassCastException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
