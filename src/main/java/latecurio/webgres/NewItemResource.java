package latecurio.webgres;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class NewItemResource {

    private String description;

//    private Long assigneeId;
//
//    private Set<Long> tagIds;

}