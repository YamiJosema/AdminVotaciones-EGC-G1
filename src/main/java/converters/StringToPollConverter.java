package converters; 

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.PollRepository;
import domain.poll;

@Component 
@Transactional 
public class StringToPollConverter implements Converter<String, poll>{ 

	@Autowired 
	PollRepository pollRepository; 

	@Override 
	public poll convert(String text){ 
		poll result; 
		int id; 

		try{ 
			if(StringUtils.isEmpty(text)){ 
				result = null; 
			}else{ 
				id = Integer.valueOf(text); 
				result = pollRepository.findOne(id); 
			} 
		}catch (Throwable oops) { 
			throw new IllegalArgumentException(oops); 
		} 

		return result; 
	} 

} 
