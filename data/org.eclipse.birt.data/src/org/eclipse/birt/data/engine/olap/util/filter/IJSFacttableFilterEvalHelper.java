
/*******************************************************************************
 * Copyright (c) 2004, 2007 Actuate Corporation.
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
package org.eclipse.birt.data.engine.olap.util.filter;

import org.eclipse.birt.data.engine.core.DataException;

/**
 *
 */

public interface IJSFacttableFilterEvalHelper {
	/**
	 * This method is used to evaluate the filter expression.
	 *
	 * @param facttableRow
	 * @return
	 * @throws DataException
	 */
	boolean evaluateFilter(IFacttableRow facttableRow) throws DataException;
}
