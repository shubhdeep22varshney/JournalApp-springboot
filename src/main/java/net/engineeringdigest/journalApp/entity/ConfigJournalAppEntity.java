package net.engineeringdigest.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.time.LocalDateTime;
import java.util.Date;

@Document(collection="cocnfig_journal_app")
@Data
@NoArgsConstructor
public class ConfigJournalAppEntity{


    private String key;
    private String value;

}
