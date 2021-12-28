package movie.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseObject {

	@Override
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
