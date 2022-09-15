package latecurio.webgres;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Item {

    @Id
    private Long id;

    @Version
    private Long version;

    private String description;

//    @NotNull
//    private ItemStatus status = ItemStatus.TODO;

//    private Long assigneeId;

//    @Transient
//    private Person assignee;
//
//    @Transient
//    private List<Tag> tags;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}