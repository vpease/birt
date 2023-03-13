/*******************************************************************************
 * Copyright (c) 2008 Actuate Corporation.
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

package org.eclipse.birt.report.engine.emitter.config.impl;

import org.eclipse.birt.report.engine.emitter.config.IEmitterConfigurationManager;
import org.eclipse.birt.report.engine.emitter.config.IEmitterConfigurationManagerFactory;

/**
 * EmitterConfigurationManagerFactory
 */
public class EmitterConfigurationManagerFactory implements IEmitterConfigurationManagerFactory {

	private static EmitterConfigurationManager instance = new EmitterConfigurationManager();

	/*
	 * (non-Javadoc)
	 *
	 * @seeorg.eclipse.birt.report.engine.emitter.config.
	 * IEmitterConfigurationManagerFactory#createManager()
	 */
	@Override
	public IEmitterConfigurationManager createManager() {
		return instance;
	}
}
