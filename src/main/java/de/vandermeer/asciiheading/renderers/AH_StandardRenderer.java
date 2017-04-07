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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.WordUtils;

import de.vandermeer.asciiheading.AH_Context;
import de.vandermeer.asciiheading.AsciiHeading;
import de.vandermeer.asciiheading.themes.AH_Theme;

/**
 * Standard renderer for {@link AsciiHeading}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.3
 */
public class AH_StandardRenderer extends AH_AbstractRenderer {

	@Override
	public List<String> renderToList(AsciiHeading ah) {
		Validate.notNull(ah);

		List<String> ret = new ArrayList<>();
		AH_Context ctx = ah.getContext();
		AH_Theme theme = ctx.getTheme();

		//create the text using start line, end line and the actual heading with all extra white spaces removed (more than one space, tabs, LF, CR, CR+LF
		String text = new String();
		if(!StringUtils.isBlank(ctx.getHeadingStart())){
			text += ctx.getHeadingStart();
		}
		text += ah.getText().toString().replaceAll("\\s+", " ");
		if(!StringUtils.isBlank(ctx.getHeadingEnd())){
			text += ctx.getHeadingEnd();
		}

		//first add additional lines if required
		for(int i=0; i<ctx.getAddLinesBefore(); i++){
			ret.add("");
		}

		String[] textAr = null;
		if(theme.doesWrapLines()){
			int width = ctx.getWidth();
			if(theme.useLevelNumber()){
				//we need to calculate the heading number for line wrapping
				width -= ctx.getNumber().length() -1;
			}
			textAr = StringUtils.split(WordUtils.wrap(text, width, "\n", true), "\n");
		}
		else{
			textAr = new String[]{text};
		}
		Validate.notNull(textAr);
		Validate.noNullElements(textAr);

		int maxLineLength = 0;
		for(int k=0; k<textAr.length; k++){
			StrBuilder line = new StrBuilder(50);

			if(k==0){
				//first line, add the pre string from theme
				String pre = theme.getLevelPre(ctx.getLevel());
				if(!StringUtils.isBlank(pre)){
					line.append(pre);
				}
				if(theme.useLevelNumber()){
					line.append(ctx.getNumber()).append(' ');
				}
				line.append(textAr[k]);
			}

			if(k>0){
				if(theme.useLevelNumber()){
					line.appendPadding(ctx.getNumber().length()+1, ' ');
					line.append(textAr[k]);
				}
				else{
					line.append(textAr[k]);
				}
			}

			if(k==textAr.length-1){
				//last line, add the post string from theme
				String post = theme.getLevelPost(ctx.getLevel());
				if(!StringUtils.isBlank(post) && !theme.isTwoLineTheme()){
					line.append(post);
				}
			}

			if(maxLineLength < textAr[k].length()){
				maxLineLength = textAr[k].length();
			}

			//finally add the new line to the list
			ret.add(line.toString());

			//if we are at the last line and theme wants 2 lines
			if(k==textAr.length-1 && theme.isTwoLineTheme()){
				String post = theme.getLevelPost(ctx.getLevel());
				if(!StringUtils.isBlank(post)){
					if(theme.useLevelNumber()){
						//we need to calculate the heading number for line wrapping
						maxLineLength += ctx.getNumber().length() +1;
					}
					line.clear();
					line.appendPadding(maxLineLength, post.charAt(0));
					ret.add(line.toString());
				}
			}
		}

		//finally add additional lines if required
		for(int i=0; i<ctx.getAddLinesAfter(); i++){
			ret.add("");
		}

		return ret;
	}

}
