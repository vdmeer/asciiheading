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

package de.vandermeer.asciiheading;

import org.apache.commons.lang3.Validate;

import de.vandermeer.asciiheading.renderers.AH_Renderer;
import de.vandermeer.asciiheading.renderers.AH_StandardRenderer;
import de.vandermeer.asciiheading.themes.AH_Theme;
import de.vandermeer.asciiheading.themes.AH_StandardThemes;

/**
 * Context for an {@link AsciiHeading}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class AH_Context {

	/** Added empty lines after the heading. */
	protected int addLinesAfter;

	/** Added empty lines before the heading. */
	protected int addLinesBefore;

	/** The width of the heading. */
	protected int width;

	/** A string to be inserted before the heading text. */
	protected String headingStart;

	/** A string to be inserted after the heading text. */
	protected String headingEnd;

	/** The character to be used for in-line white spaces. */
	protected char inlineWS;

	/** The heading theme. */
	protected AH_Theme theme;

	/** The level of the heading, must be between 1 and 6. */
	protected int level;

	/** The heading number. */
	protected String number;

	/** The renderer for this context, default is {@link AH_StandardRenderer}. */
	protected AH_Renderer renderer = new AH_StandardRenderer();

	/**
	 * Creates a new heading context with default settings.
	 * The default values are as follows:
	 * <ul>
	 * 		<li>Level: 1</li>
	 * 		<li>Number: null</li>
	 * 		<li>Width: 80</li>
	 * 		<li>Added empty lines before heading: 2</li>
	 * 		<li>Added empty lines after heading: 1</li>
	 * 		<li>In-line whitespace character: ' ' (space)</li>
	 * 		<li>Heading start: null</li>
	 * 		<li>Heading end: null</li>
	 * 		<li>Theme: {@link AH_StandardThemes#PLAIN_TEXT_EMPTY}</li>
	 * </ul>
	 */
	public AH_Context(){
		this.level = 1;
		this.number = null;
		this.addLinesBefore = 2;
		this.addLinesAfter = 1;
		this.width = 80;
		this.inlineWS = ' ';
		this.headingStart = null;
		this.headingEnd = null;
		this.theme = AH_StandardThemes.PLAIN_TEXT_EMPTY;
	}

	/**
	 * Returns the number of added empty lines after the heading.
	 * @return number of added empty lines after the heading
	 */
	public int getAddLinesAfter() {
		return addLinesAfter;
	}

	/**
	 * Returns the number of added empty lines before the heading.
	 * @return number of added empty lines before the heading
	 */
	public int getAddLinesBefore() {
		return addLinesBefore;
	}

	/**
	 * Returns the in-line whitespace character.
	 * @return in-line whitespace character
	 */
	public char getInlineWS() {
		return inlineWS;
	}

	/**
	 * Returns the heading end string.
	 * @return heading end string, null if not set
	 */
	public String getHeadingEnd() {
		return headingEnd;
	}

	/**
	 * Returns the heading start string.
	 * @return heading start string, null if not set
	 */
	public String getHeadingStart() {
		return headingStart;
	}

	/**
	 * Returns the heading width.
	 * @return heading width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the number of empty lines that should be added after the heading.
	 * @param addLines number of added lines after the heading, only added if 0 or positive
	 * @return self to allow chaining
	 */
	public AH_Context setAddLinesAfter(int addLines) {
		if(addLines>=0){
			this.addLinesAfter = addLines;
		}
		return this;
	}

	/**
	 * Sets the number of empty lines that should be added before the heading.
	 * @param addLines number of added lines before the heading, only added if 0 or positive
	 * @return self to allow chaining
	 */
	public AH_Context setAddLinesBefore(int addLines) {
		if(addLines>=0){
			this.addLinesBefore = addLines;
		}
		return this;
	}

	/**
	 * Sets the in-line whitespace character.
	 * @param inlineWS new inline whitespace character
	 * @return self to allow chaining
	 */
	public AH_Context setInlineWS(char inlineWS) {
		this.inlineWS = inlineWS;
		return this;
	}

	/**
	 * Sets the heading end string.
	 * @param end new heading end string, should not be blank
	 * @return self to allow chaining
	 * @throws NullPointerException if the argument was null
	 * @throws IllegalArgumentException if the argument was blank
	 */
	public AH_Context setLineEnd(String end) {
		Validate.notBlank(end);
		this.headingEnd = end;
		return this;
	}

	/**
	 * Sets the heading start string.
	 * @param start new heading start string, should not be blank
	 * @return self to allow chaining
	 * @throws NullPointerException if the argument was null
	 * @throws IllegalArgumentException if the argument was blank
	 */
	public AH_Context setHeadingStart(String start) {
		Validate.notBlank(start);
		this.headingStart = start;
		return this;
	}

	/**
	 * Sets the heading width.
	 * @param width new width
	 * @return self to allow chaining
	 */
	public AH_Context setWidth(int width) {
		this.width = width;
		return this;
	}

	/**
	 * Sets the heading theme.
	 * @param theme heading theme, only set if not null
	 */
	public void setTheme(AH_Theme theme){
		if(theme!=null){
			this.theme = theme;
		}
	}

	/**
	 * Returns the heading theme.
	 * @return heading theme
	 */
	public AH_Theme getTheme(){
		return this.theme;
	}

	/**
	 * Sets the heading level.
	 * @param level heading level, only set if between 1 and 6
	 */
	public void setLevel(int level){
		if(level>=1 && level <=6){
			this.level = level;
		}
	}

	/**
	 * Returns the heading level.
	 * @return heading level
	 */
	public int getLevel(){
		return this.level;
	}

	/**
	 * Sets the heading number.
	 * @param number heading number, blank is accepted
	 */
	public void setNumber(String number){
		this.number = number;
	}

	/**
	 * Returns the heading number.
	 * @return heading number
	 */
	public String getNumber(){
		return this.number;
	}

	/**
	 * Returns the set renderer.
	 * @return renderer
	 */
	public AH_Renderer getRenderer(){
		return this.renderer;
	}

	/**
	 * Sets the renderer for the context.
	 * @param renderer new renderer, only set if not null
	 */
	public void setRenderer(AH_Renderer renderer){
		if(renderer!=null){
			this.renderer = renderer;
		}
	}
}
