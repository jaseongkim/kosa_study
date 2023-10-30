package java_base_모듈_12장;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LombokMember {
	
	private String id;
	private String name;
	private int age;
	private final int age2;
	private final int age3;
	
	

}
