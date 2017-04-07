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

/**
 * Collection of standard themes for headings.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public enum AH_StandardThemes implements AH_Theme {

	/** A style for ASCIIDOC headings using 2 line. */
	ASCIIDOC_2_LINE (
			new AH_AbstractTeme(
					false,
					false,
					true,
					AH_StandardStyles.ASCIIDOC_2_LINES_H1,
					AH_StandardStyles.ASCIIDOC_2_LINES_H2,
					AH_StandardStyles.ASCIIDOC_2_LINES_H3,
					AH_StandardStyles.ASCIIDOC_2_LINES_H4
			)
	),

	/** A style for ASCIIDOC headings using 1 line. */
	ASCIIDOC_1_LINE (
			new AH_AbstractTeme(
					AH_StandardStyles.ASCIIDOC_1_LINE_H1,
					AH_StandardStyles.ASCIIDOC_1_LINE_H2,
					AH_StandardStyles.ASCIIDOC_1_LINE_H3,
					AH_StandardStyles.ASCIIDOC_1_LINE_H4
			)
	),

	/** A style for a LaTeX book, starting with part going up to paragraph. */
	LATEX_BOOK_PART (
			new AH_AbstractTeme(
					AH_StandardStyles.LATEX_PART,
					AH_StandardStyles.LATEX_CHAPTER,
					AH_StandardStyles.LATEX_SECTION,
					AH_StandardStyles.LATEX_SUB_SECTION,
					AH_StandardStyles.LATEX_SUBSUB_SECTION,
					AH_StandardStyles.LATEX_PARAGRAPH
			)
	),

	/** A style for a LaTeX book, starting with chapter going up to sub-paragraph. */
	LATEX_BOOK_CHAPTER (
			new AH_AbstractTeme(
					AH_StandardStyles.LATEX_CHAPTER,
					AH_StandardStyles.LATEX_SECTION,
					AH_StandardStyles.LATEX_SUB_SECTION,
					AH_StandardStyles.LATEX_SUBSUB_SECTION,
					AH_StandardStyles.LATEX_PARAGRAPH,
					AH_StandardStyles.LATEX_SUB_PARAGRAPH
			)
	),

	/** A style for a LaTeX article, starting with section going up to level 5 sub-paragraph (no level 6). */
	LATEX_ARTICLE (
			new AH_AbstractTeme(
					AH_StandardStyles.LATEX_SECTION,
					AH_StandardStyles.LATEX_SUB_SECTION,
					AH_StandardStyles.LATEX_SUBSUB_SECTION,
					AH_StandardStyles.LATEX_PARAGRAPH,
					AH_StandardStyles.LATEX_SUB_PARAGRAPH
			)
	),

	/** A style using the LaTeX package SKB, using only a special command "skbheading" for all levels. */
	LATEX_SKB (
			new AH_AbstractTeme(
					AH_StandardStyles.LATEX_SKB,
					AH_StandardStyles.LATEX_SKB,
					AH_StandardStyles.LATEX_SKB,
					AH_StandardStyles.LATEX_SKB,
					AH_StandardStyles.LATEX_SKB,
					AH_StandardStyles.LATEX_SKB
			)
	),

	/** A style for plain text with no special text added to any level. */
	PLAIN_TEXT_EMPTY (
			new AH_AbstractTeme(
					true,
					true,
					false,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY
			)
	),

	/** A style for plain text with no special text added to any level. */
	PLAIN_TEXT_AD_2_LINES (
			new AH_AbstractTeme(
					true,
					true,
					true,
					AH_StandardStyles.ASCIIDOC_2_LINES_H1,
					AH_StandardStyles.ASCIIDOC_2_LINES_H2,
					AH_StandardStyles.ASCIIDOC_2_LINES_H3,
					AH_StandardStyles.ASCIIDOC_2_LINES_H4,
					AH_StandardStyles.PLAIN_TEXT_EMPTY,
					AH_StandardStyles.PLAIN_TEXT_EMPTY
			)
	),
	;

	/** The local theme object. */
	AH_Theme theme;

	/**
	 * Creates a new heading theme.
	 * @param theme the theme object
	 */
	AH_StandardThemes(AH_Theme theme){
		this.theme = theme;
	}

	@Override
	public boolean doesWrapLines() {
		return this.theme.doesWrapLines();
	}

	@Override
	public String getLevelPre(int level) {
		return this.theme.getLevelPre(level);
	}

	@Override
	public String getLevelPost(int level) {
		return this.theme.getLevelPost(level);
	}

	@Override
	public boolean useLevelNumber() {
		return this.theme.useLevelNumber();
	}

	@Override
	public boolean isTwoLineTheme() {
		return this.theme.isTwoLineTheme();
	}

}
