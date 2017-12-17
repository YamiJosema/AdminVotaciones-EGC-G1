package converters; 

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.Question_OptionRepository;
import domain.question_option;

@Component 
@Transactional 
public class StringToQuestion_OptionConverter implements Converter<String, question_option>{ 

	@Autowired 
	Question_OptionRepository question_optionRepository; 

	@Override 
	public question_option convert(String text){ 
		question_option result; 
		int id; 

		try{ 
			if(StringUtils.isEmpty(text)){ 
				result = null; 
			}else{ 
				id = Integer.valueOf(text); 
				result = question_optionRepository.findOne(id); 
			} 
		}catch (Throwable oops) { 
			throw new IllegalArgumentException(oops); 
		} 

		return result; 
	} 

} 
