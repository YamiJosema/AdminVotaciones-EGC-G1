package converters; 

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.poll;

@Component 
@Transactional 
public class PollToStringConverter implements Converter<poll, String>{ 

	@Override 
	public String convert(poll poll){ 
		String result; 
		if(poll == null){ 
			result = null; 
		}else{ 
			result = String.valueOf(poll.getId()); 
		} 
		return result; 
	} 

} 
