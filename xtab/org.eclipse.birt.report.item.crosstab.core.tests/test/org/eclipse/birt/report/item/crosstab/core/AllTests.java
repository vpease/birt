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

package org.eclipse.birt.report.item.crosstab.core;

import org.eclipse.birt.report.item.crosstab.core.de.AllDeTests;
import org.eclipse.birt.report.item.crosstab.core.parser.AllParserTests;
import org.eclipse.birt.report.item.crosstab.core.re.AllReTests;
import org.eclipse.birt.report.item.crosstab.core.util.AllUtilTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * All tests.
 *
 */

public class AllTests {
	/**
	 * @return the test
	 */

	public static Test suite() {
		TestSuite test = new TestSuite();

		test.addTest(AllDeTests.suite());
		test.addTest(AllParserTests.suite());
		test.addTest(AllReTests.suite());
		test.addTest(AllUtilTests.suite());
		// add all test classes here

		return test;
	}
}
