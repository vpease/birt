/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.parser;

import org.eclipse.birt.report.model.core.DesignElement;
import org.eclipse.birt.report.model.elements.olap.Hierarchy;
import org.eclipse.birt.report.model.elements.olap.OdaHierarchy;
import org.eclipse.birt.report.model.util.XMLParserException;
import org.xml.sax.Attributes;

/**
 * This class parses a hierarchy element within a dimension.
 *
 */

public class OdaHierarchyState extends ReportElementState {

	/**
	 * The hierarchy being created.
	 */

	protected Hierarchy element = null;

	/**
	 * Constructs hierarchy state with the design parser handler, the container
	 * element and the container property name of the report element.
	 *
	 * @param handler      the design file parser handler
	 * @param theContainer the element that contains this one
	 * @param prop         the slot in which this element appears
	 */

	public OdaHierarchyState(ModuleParserHandler handler, DesignElement theContainer, String prop) {
		super(handler, theContainer, prop);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.report.model.parser.ReportElementState#getElement()
	 */

	@Override
	public DesignElement getElement() {
		return element;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.birt.report.model.util.AbstractParseState#parseAttrs(org.xml.sax.
	 * Attributes)
	 */

	@Override
	public void parseAttrs(Attributes attrs) throws XMLParserException {
		element = new OdaHierarchy();
		initElement(attrs, false);
	}
}
