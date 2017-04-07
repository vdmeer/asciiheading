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

package de.vandermeer.asciiheading.renderers;

import java.util.List;

import de.vandermeer.asciiheading.AsciiHeading;

/**
 * Renders a heading.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public interface AH_Renderer {

	/**
	 * Renders the heading, generates a string representation of it.
	 * All extra white spaces (extra spaces, tabulators, line feed, carriage return, line feed with carriage return) will be removed before the heading is rendered.
	 * @param ah the heading to render
	 * @return rendered heading
	 */
	String render(AsciiHeading ah);

	/**
	 * Returns the rendered heading as an array of lines
	 * @param ah the heading to render
	 * @return array of lines for the rendered heading
	 */
	String[] renderToArray(AsciiHeading ah);

	/**
	 * Returns the rendered heading as a list of lines.
	 * @param ah the heading to render
	 * @return list of lines for the rendered heading
	 */
	List<String> renderToList(AsciiHeading ah);
}
