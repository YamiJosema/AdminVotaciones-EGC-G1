package converters; 

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Question_Option;

@Component 
@Transactional 
public class StringToQuestion_OptionConverter implements Converter<String, Question_Option>{ 

	@Autowired 
	Question_OptionRepository question_optionRepository; 

	@Override 
	public Question_Option convert(String text){ 
		Question_Option result; 
		int id; 

		try{ 
			if(StringUtils.isEmpty(text)){ 
				result = null; 
			}else{ 
				id = Integer.valueOf(text); 
				result = question_optionsRepository.findOne(id); 
			} 
		}catch (Throwable oops) { 
			throw new IllegalArgumentException(oops); 
		} 

		return result; 
	} 

} 
