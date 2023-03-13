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

package org.eclipse.birt.report.engine.internal.content.wrap;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.engine.content.IContainerContent;
import org.eclipse.birt.report.engine.content.IContentVisitor;

public class ContainerContent extends AbstractContentWrapper implements IContainerContent {
	public ContainerContent(IContainerContent container) {
		super(container);
	}

	@Override
	public Object accept(IContentVisitor visitor, Object value) throws BirtException {
		return visitor.visitContainer(this, value);
	}
}
