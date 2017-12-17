package converters; 

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.question_option;

@Component 
@Transactional 
public class Question_OptionToStringConverter implements Converter<question_option, String>{ 

	@Override 
	public String convert(question_option question_option){ 
		String result; 
		if(question_option == null){ 
			result = null; 
		}else{ 
			result = String.valueOf(question_option.getId()); 
		} 
		return result; 
	} 

} 
