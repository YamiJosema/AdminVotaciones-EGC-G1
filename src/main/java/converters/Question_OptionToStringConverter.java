package converters; 

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Question_Option;

@Component 
@Transactional 
public class Question_OptionToStringConverter implements Converter<Question_Option, String>{ 

	@Override 
	public String convert(Question_Option question_option){ 
		String result; 
		if(question_option == null){ 
			result = null; 
		}else{ 
			result = String.valueOf(question_option.getId()); 
		} 
		return result; 
	} 

} 
