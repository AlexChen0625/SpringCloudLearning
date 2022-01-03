package movie.pojo;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseObject implements Serializable {
	private Integer id;
	private String userName;
	private String password;
	private String sex;
	private Double money;

}
