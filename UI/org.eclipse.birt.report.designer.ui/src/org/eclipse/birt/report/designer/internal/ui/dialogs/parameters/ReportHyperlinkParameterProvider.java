/*******************************************************************************
 * Copyright (c) 2010 Actuate Corporation.
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

package org.eclipse.birt.report.designer.internal.ui.dialogs.parameters;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.birt.report.designer.nls.Messages;
import org.eclipse.birt.report.model.api.ParameterHandle;
import org.eclipse.birt.report.model.api.ReportDesignHandle;

/**
 * ReportHyperlinkParameterProvider
 */
public class ReportHyperlinkParameterProvider implements IHyperlinkParameterProvider {

	// TODO localize
	public static final String CATEGORY_REPORT = Messages.getString("ReportHyperlinkParameterProvider.Category.Report"); //$NON-NLS-1$

	private static final String[] CATS = { CATEGORY_REPORT };

	private ReportDesignHandle design;

	ReportHyperlinkParameterProvider(ReportDesignHandle design) {
		this.design = design;
	}

	@Override
	public String[] getCategories() {
		return CATS;
	}

	@Override
	public IHyperlinkParameter[] getParameters(String category, String format) {
		if (design != null && CATEGORY_REPORT.equals(category)) {
			ArrayList<IHyperlinkParameter> params = new ArrayList<>();

			for (Iterator iter = design.getAllParameters().iterator(); iter.hasNext();) {
				Object obj = iter.next();

				if (obj instanceof ParameterHandle) {
					params.add(new ReportHyperlinkParameter((ParameterHandle) obj));
				}
			}

			if (params.size() > 0) {
				return params.toArray(new IHyperlinkParameter[params.size()]);
			}
		}

		return null;
	}

}
