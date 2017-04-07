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

import de.vandermeer.asciiheading.AsciiHeading;

/**
 * Interface for providing a theme for an {@link AsciiHeading} - coordinated heading styles from level 1 to 6.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public interface AH_Theme {

	/**
	 * Returns the flag for wrapping lines.
	 * If the theme wants to wrap lines, a renderer must break the lines to the maximum requested width (heading context).
	 * If a theme does not want to wrap lines, no line wrapping should be done by a renderer.
	 * @return true if the theme wraps lines for a heading, false otherwise
	 */
	boolean doesWrapLines();

	/**
	 * Returns the flag for using the level number.
	 * If a theme wants to use the level number (e.g. for manual controlled heading numbering), a renderer must use the provided number from the heading context.
	 * If a theme does not want to use the level number (e.g. for automated heading numbering by a later system), a renderer must not use the heading context number.
	 * @return true if the theme uses level numbers, false otherwise
	 */
	boolean useLevelNumber();

	/**
	 * Flag for a two line heading theme.
	 * If a theme needs two lines (a heading text line and some formatting line), then the renderer needs to add the post string (first character) to the length of the heading line.
	 * If a theme does not want two lines, no special processing is required.
	 * @return true if the theme uses 2 lines, false otherwise
	 */
	boolean isTwoLineTheme();

	/**
	 * Returns the pre string for the given level.
	 * @param level heading level, should be a positive integer larger than 0
	 * @return the pre string, blank is allows meaning nothing to be used as pre string
	 */
	String getLevelPre(int level);

	/**
	 * Returns the post string for the given level.
	 * @param level heading level, should be a positive integer larger than 0
	 * @return the post string, blank is allows meaning nothing to be used as post string
	 */
	String getLevelPost(int level);
}
