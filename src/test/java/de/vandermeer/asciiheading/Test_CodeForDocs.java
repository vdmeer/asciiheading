/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
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

import org.junit.Test;

import de.vandermeer.asciiheading.themes.AH_StandardThemes;

/**
 * Tests for ASCII Heading for code used in documentation.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.2
 */
public class Test_CodeForDocs {

	@Test
	public void test_SimpleExample(){
		this.output("simple paragraph");

		AsciiHeading ah = new AsciiHeading();
		ah.addHeadingText("heading test with some lenght that requires line wrapping");
		ah.getContext().setWidth(20);
		ah.getContext().setLevel(1);
		ah.getContext().setNumber("1.2");
		ah.getContext().setTheme(AH_StandardThemes.PLAIN_TEXT_AD_2_LINES);
		String rend = ah.render();
		System.out.println(rend);

		this.output();
	}

	protected void output(String str){
		System.out.println(str);
		System.out.println("----------------------------------------------------------------------------------------");
	}

	protected void output(){
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();
	}

}
