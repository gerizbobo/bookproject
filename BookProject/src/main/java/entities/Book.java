package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bookId;
    @Column
    public String author;
    @Column
    public String title;
    @Column
    public String summary;
    @Column
    public int publisher_Year;
    @Column
    public String publisher_House;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "library_book",
            joinColumns = {@JoinColumn(name = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "libraryId")}
    )
    private List<Library> library;

    @OneToMany(mappedBy = "book")
    List<OrderLine> orderLine;






}
