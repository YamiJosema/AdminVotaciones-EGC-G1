package converters; 

import org.springframework.core.convert.converter.Converter; 
import org.springframework.stereotype.Component; 
import org.springframework.transaction.annotation.Transactional; 

import domain.question; 

@Component 
@Transactional 
public class QuestionToStringConverter implements Converter<question, String>{ 

	@Override 
	public String convert(question question){ 
		String result; 
		if(question == null){ 
			result = null; 
		}else{ 
			result = String.valueOf(question.getId()); 
		} 
		return result; 
	} 

} 
