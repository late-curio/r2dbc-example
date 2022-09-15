package latecurio.webgres;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemResource {

    private Long id;

    private String description;

//    private Long assigneeId;
//
//    private Set<Long> tagIds;

}