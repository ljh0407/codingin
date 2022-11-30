package codingin.domain.entity;
import codingin.domain.BaseEntity;
import codingin.domain.dto.LetterDto;
import lombok.*;

import javax.persistence.*;

@Entity // 엔티티 정의
@Table(name = "letter") // 테이블명 정의
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class LetterEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lno;

    @Column( nullable = false )
    private String  ltitle; //제목

    @Column( nullable = false )
    private String  lcontent;   //내용

    // 연관관계1 [ 회원번호[pk : mno] <--양방향--> 보내는 사람[fk : lfrom]
    @ManyToOne
    @JoinColumn(name="lfrom") // 테이블에서 사용할 fk의 필드명 정의
    @ToString.Exclude
    private MemberEntity lfrom;  // FK에 엔티티 객체 생성

    // 연관관계1 [ 회원번호[pk : mno] <--양방향--> 받는 사람[fk : lto]
    @ManyToOne
    @JoinColumn(name="lto") // 테이블에서 사용할 fk의 필드명 정의
    @ToString.Exclude
    private MemberEntity lto;  // PK에 엔티티 객체

    public LetterDto toDto(){
        return LetterDto
                .builder()
                .lno( this.lno )
                .ltitle( this.ltitle)
                .lcontent( this.lcontent)
                .build();
    }
}
