package converters; 

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.census;

@Component 
@Transactional 
public class CensusToStringConverter implements Converter<census, String>{ 

	@Override 
	public String convert(census census){ 
		String result; 
		if(census == null){ 
			result = null; 
		}else{ 
			result = String.valueOf(census.getId()); 
		} 
		return result; 
	} 

} 
