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
 * Collection of standard styles for headings.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public enum AH_StandardStyles implements AH_Style {

	/** A 1-line ASCIIDOC heading level 1. */
	ASCIIDOC_1_LINE_H1 ("=", "="),

	/** A 1-line ASCIIDOC heading level 2. */
	ASCIIDOC_1_LINE_H2 ("==", "=="),

	/** A 1-line ASCIIDOC heading level 3. */
	ASCIIDOC_1_LINE_H3 ("===", "==="),

	/** A 1-line ASCIIDOC heading level 4. */
	ASCIIDOC_1_LINE_H4 ("====", "===="),



	/** A 2-line ASCIIDOC heading level 1, renderer needs to use post string in a second line with same width as the heading. */
	ASCIIDOC_2_LINES_H1 (null, "="),

	/** A 2-line ASCIIDOC heading level 2, renderer needs to use post string in a second line with same width as the heading. */
	ASCIIDOC_2_LINES_H2 (null, "-"),

	/** A 2-line ASCIIDOC heading level 3, renderer needs to use post string in a second line with same width as the heading. */
	ASCIIDOC_2_LINES_H3 (null, "~"),

	/** A 2-line ASCIIDOC heading level 4, renderer needs to use post string in a second line with same width as the heading. */
	ASCIIDOC_2_LINES_H4 (null, "+"),



	/** An HTML heading level 1. */
	HTML_H1 ("<h1>", "</h1>"),

	/** An HTML heading level 2. */
	HTML_H2 ("<h2>", "</h2>"),

	/** An HTML heading level 3. */
	HTML_H3 ("<h3>", "</h3>"),

	/** An HTML heading level 4. */
	HTML_H4 ("<h4>", "</h4>"),

	/** An HTML heading level 5. */
	HTML_H5 ("<h5>", "</h5>"),

	/** An HTML heading level 5. */
	HTML_H6 ("<h6>", "</h6>"),



	/** An HTML heading level 1 without the start tag. */
	HTML_H1_END (null, "</h1>"),

	/** An HTML heading level 2 without the start tag. */
	HTML_H2_END (null, "</h2>"),

	/** An HTML heading level 3 without the start tag. */
	HTML_H3_END (null, "</h3>"),

	/** An HTML heading level 4 without the start tag. */
	HTML_H4_END (null, "</h4>"),

	/** An HTML heading level 5 without the start tag. */
	HTML_H5_END (null, "</h5>"),

	/** An HTML heading level 6 without the start tag. */
	HTML_H6_END (null, "</h6>"),



	/** A LaTeX heading part. */
	LATEX_PART ("\\part{", "}"),

	/** A LaTeX heading chapter. */
	LATEX_CHAPTER ("\\chapter{", "}"),

	/** A LaTeX heading section. */
	LATEX_SECTION ("\\section{", "}"),

	/** A LaTeX heading sub-section. */
	LATEX_SUB_SECTION ("\\subsection{", "}"),

	/** A LaTeX heading sub-sub-section. */
	LATEX_SUBSUB_SECTION ("\\subsubsection{", "}"),

	/** A LaTeX heading paragraph. */
	LATEX_PARAGRAPH ("\\paragraph{", "}"),

	/** A LaTeX heading sub-paragraph. */
	LATEX_SUB_PARAGRAPH ("\\subparagraph{", "}"),



	/** A LaTeX heading for the LaTeX package SKB. */
	LATEX_SKB ("\\skbheading{", "}"),



	/** A Plain text heading with no special text for neither pre nor post. */
	PLAIN_TEXT_EMPTY (null, null),
	;


	/** String before the heading. */
	protected String pre;

	/** String after the heading. */
	protected String post;

	/**
	 * Creates a new heading style.
	 * @param pre text right before the actual heading, null if not set
	 * @param post text right after the actual heading, null if not set
	 */
	AH_StandardStyles(String pre, String post){
		this.pre = pre;
		this.post = post;
	}

	@Override
	public String getPre() {
		return this.pre;
	}

	@Override
	public String getPost() {
		return this.post;
	}

}
