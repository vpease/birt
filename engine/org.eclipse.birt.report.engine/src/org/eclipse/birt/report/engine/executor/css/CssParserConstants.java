/*******************************************************************************
 * Copyright (c) 2021 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   See git history
 *******************************************************************************/
/* Generated By:JavaCC: Do not edit this line. CssParserConstants.java */
package org.eclipse.birt.report.engine.executor.css;

public interface CssParserConstants {

	int EOF = 0;
	int S = 1;
	int INHERIT = 2;
	int CDO = 3;
	int CDC = 4;
	int LBRACE = 5;
	int RBRACE = 6;
	int DASHMATCH = 7;
	int INCLUDES = 8;
	int PREFIXMATCH = 9;
	int SUFFIXMATCH = 10;
	int SUBSTRINGMATCH = 11;
	int TILDE = 12;
	int EQ = 13;
	int PLUS = 14;
	int MINUS = 15;
	int COMMA = 16;
	int SEMICOLON = 17;
	int PRECEDES = 18;
	int DIV = 19;
	int LBRACKET = 20;
	int RBRACKET = 21;
	int ANY = 22;
	int DOT = 23;
	int LPARAN = 24;
	int RPARAN = 25;
	int COLON = 26;
	int AND = 27;
	int MEDIARESTRICTOR = 28;
	int NONASCII = 29;
	int H = 30;
	int UNICODE = 31;
	int ESCAPE = 32;
	int NMSTART = 33;
	int NMCHAR = 34;
	int STRINGCHAR = 35;
	int D = 36;
	int NAME = 37;
	int STRING = 38;
	int NUMBER = 39;
	int _URL = 40;
	int URL = 41;
	int PERCENTAGE = 42;
	int LENGTH = 43;
	int EMS = 44;
	int EXS = 45;
	int ANGLE = 46;
	int TIME = 47;
	int FREQ = 48;
	int RESOLUTION = 49;
	int DATE = 50;
	int ABSOLUTE_SIZE = 51;
	int RELATIVE_SIZE = 52;
	int COLOR = 53;
	int NORMAL = 54;
	int AUTO = 55;
	int FONT_TAG = 56;
	int FONT_VAL = 57;
	int FONT_STYLE = 58;
	int FONT_VARIANT = 59;
	int FONT_WEIGHT = 60;
	int BACKGROUND_TAG = 61;
	int BACKGROUND_REPEAT = 62;
	int BACKGROUND_ATTACHMENT = 63;
	int BACKGROUND_POSITION = 64;
	int BORDER_TAG = 65;
	int BORDER_WIDTH_TAG = 66;
	int BORDER_STYLE_TAG = 67;
	int BORDER_TOP_TAG = 68;
	int BORDER_RIGHT_TAG = 69;
	int BORDER_BOTTOM_TAG = 70;
	int BORDER_LEFT_TAG = 71;
	int BORDER_STYLE = 72;
	int BORDER_WIDTH = 73;
	int MARGIN_TAG = 74;
	int PADDING_TAG = 75;
	int IDENT = 76;
	int DIMEN = 77;
	int HASH = 78;
	int RANGE0 = 79;
	int RANGE1 = 80;
	int RANGE2 = 81;
	int RANGE3 = 82;
	int RANGE4 = 83;
	int RANGE5 = 84;
	int RANGE6 = 85;
	int RANGE = 86;
	int UNI = 87;
	int UNICODERANGE = 88;
	int FUNCTION = 89;
	int UNKNOWN = 90;

	int DEFAULT = 0;
	int IN_COMMENT = 1;

	String[] tokenImage = { "<EOF>", //$NON-NLS-1$
			"<S>", //$NON-NLS-1$
			"\"inherit\"", //$NON-NLS-1$
			"\"<!--\"", //$NON-NLS-1$
			"\"-->\"", //$NON-NLS-1$
			"\"{\"", //$NON-NLS-1$
			"\"}\"", //$NON-NLS-1$
			"\"|=\"", //$NON-NLS-1$
			"\"~=\"", //$NON-NLS-1$
			"\"^=\"", //$NON-NLS-1$
			"\"$=\"", //$NON-NLS-1$
			"\"*=\"", //$NON-NLS-1$
			"\"~\"", //$NON-NLS-1$
			"\"=\"", //$NON-NLS-1$
			"\"+\"", //$NON-NLS-1$
			"\"-\"", //$NON-NLS-1$
			"\",\"", //$NON-NLS-1$
			"\";\"", //$NON-NLS-1$
			"\">\"", //$NON-NLS-1$
			"\"/\"", //$NON-NLS-1$
			"\"[\"", //$NON-NLS-1$
			"\"]\"", //$NON-NLS-1$
			"\"*\"", //$NON-NLS-1$
			"\".\"", //$NON-NLS-1$
			"\")\"", //$NON-NLS-1$
			"\"(\"", //$NON-NLS-1$
			"\":\"", //$NON-NLS-1$
			"<AND>", //$NON-NLS-1$
			"<MEDIARESTRICTOR>", //$NON-NLS-1$
			"<NONASCII>", //$NON-NLS-1$
			"<H>", //$NON-NLS-1$
			"<UNICODE>", //$NON-NLS-1$
			"<ESCAPE>", //$NON-NLS-1$
			"<NMSTART>", //$NON-NLS-1$
			"<NMCHAR>", //$NON-NLS-1$
			"<STRINGCHAR>", //$NON-NLS-1$
			"<D>", //$NON-NLS-1$
			"<NAME>", //$NON-NLS-1$
			"<STRING>", //$NON-NLS-1$
			"<NUMBER>", //$NON-NLS-1$
			"<_URL>", //$NON-NLS-1$
			"<URL>", //$NON-NLS-1$
			"<PERCENTAGE>", //$NON-NLS-1$
			"<LENGTH>", //$NON-NLS-1$
			"<EMS>", //$NON-NLS-1$
			"<EXS>", //$NON-NLS-1$
			"<ANGLE>", //$NON-NLS-1$
			"<TIME>", //$NON-NLS-1$
			"<FREQ>", //$NON-NLS-1$
			"<RESOLUTION>", //$NON-NLS-1$
			"<DATE>", //$NON-NLS-1$
			"<ABSOLUTE_SIZE>", //$NON-NLS-1$
			"<RELATIVE_SIZE>", //$NON-NLS-1$
			"<COLOR>", //$NON-NLS-1$
			"\"normal\"", //$NON-NLS-1$
			"\"auto\"", //$NON-NLS-1$
			"\"font\"", //$NON-NLS-1$
			"<FONT_VAL>", //$NON-NLS-1$
			"<FONT_STYLE>", //$NON-NLS-1$
			"\"small-caps\"", //$NON-NLS-1$
			"<FONT_WEIGHT>", //$NON-NLS-1$
			"\"background\"", //$NON-NLS-1$
			"<BACKGROUND_REPEAT>", //$NON-NLS-1$
			"<BACKGROUND_ATTACHMENT>", //$NON-NLS-1$
			"<BACKGROUND_POSITION>", //$NON-NLS-1$
			"\"border\"", //$NON-NLS-1$
			"\"border-width\"", //$NON-NLS-1$
			"\"border-style\"", //$NON-NLS-1$
			"\"border-top\"", //$NON-NLS-1$
			"\"border-right\"", //$NON-NLS-1$
			"\"border-bottom\"", //$NON-NLS-1$
			"\"border-left\"", //$NON-NLS-1$
			"<BORDER_STYLE>", //$NON-NLS-1$
			"<BORDER_WIDTH>", //$NON-NLS-1$
			"\"margin\"", //$NON-NLS-1$
			"\"padding\"", //$NON-NLS-1$
			"<IDENT>", //$NON-NLS-1$
			"<DIMEN>", //$NON-NLS-1$
			"<HASH>", //$NON-NLS-1$
			"<RANGE0>", //$NON-NLS-1$
			"<RANGE1>", //$NON-NLS-1$
			"<RANGE2>", //$NON-NLS-1$
			"<RANGE3>", //$NON-NLS-1$
			"<RANGE4>", //$NON-NLS-1$
			"<RANGE5>", //$NON-NLS-1$
			"<RANGE6>", //$NON-NLS-1$
			"<RANGE>", //$NON-NLS-1$
			"<UNI>", //$NON-NLS-1$
			"<UNICODERANGE>", //$NON-NLS-1$
			"<FUNCTION>", //$NON-NLS-1$
			"<UNKNOWN>", //$NON-NLS-1$
	};

}
