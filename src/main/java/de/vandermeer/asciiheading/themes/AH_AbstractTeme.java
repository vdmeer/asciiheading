/* Copyright 2016 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.asciiheading.themes;

import org.apache.commons.lang3.Validate;

/**
 * Abstract yet fully functional implementation of {@link AH_Theme}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class AH_AbstractTeme implements AH_Theme {

	/** The styles for each level, index 0 means level 1 et cetera. */
	protected AH_Style[] levelStyles;

	/** The wrap lines flag, default is false. */
	protected boolean wrapLines;

	/** The flag for using level number. */
	protected boolean useLevelNumer;

	/** Flag for a 2 line theme, such as a 2 line ASCIIDOC heading. */
	protected boolean twoLineTheme;

	/**
	 * Creates a new theme implementation.
	 * Wrap lines and use level number are set to false.
	 * @param styles the styles to be used for the levels
	 * @throws NullPointerException if the style array was null
	 * @throws IllegalArgumentException if any style was null
	 */
	public AH_AbstractTeme(AH_Style ... styles){
		this(false, false, false, styles);
	}

	/**
	 * Creates a new theme implementation.
	 * @param wrapLines wrap true if the theme requries line wrapping of the heading text, false otherwise
	 * @param useLevelNumer true if the theme wants to use a level number, false otherwise
	 * @param twoLineTheme true if theme wants 2 lines, false if only 1 is required
	 * @param styles the styles to be used for the levels
	 * @throws NullPointerException if the style array was null
	 * @throws IllegalArgumentException if any style was null
	 */
	public AH_AbstractTeme(boolean wrapLines, boolean useLevelNumer, boolean twoLineTheme, AH_Style ... styles){
		Validate.notNull(styles);
		Validate.noNullElements(styles);
		this.levelStyles = styles;

		this.wrapLines = wrapLines;
		this.useLevelNumer = useLevelNumer;
		this.twoLineTheme = twoLineTheme;
	}

	@Override
	public boolean doesWrapLines() {
		return this.wrapLines;
	}

	@Override
	public String getLevelPre(int level) {
		if(level<1){
			return null;
		}
		int actual = level -1;
		if(actual > this.levelStyles.length){
			return null;
		}
		return this.levelStyles[actual].getPre();
	}

	@Override
	public String getLevelPost(int level) {
		if(level<1){
			return null;
		}
		int actual = level -1;
		if(actual > this.levelStyles.length){
			return null;
		}
		return this.levelStyles[actual].getPost();
	}

	@Override
	public boolean useLevelNumber() {
		return this.useLevelNumer;
	}

	@Override
	public boolean isTwoLineTheme() {
		return this.twoLineTheme;
	}

}
