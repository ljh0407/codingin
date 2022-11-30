package codingin.domain.entity;

import codingin.domain.BaseEntity;
import codingin.domain.dto.BoardDto;
import codingin.domain.dto.RereplyDto;
import lombok.*;

import javax.persistence.*;


@Entity // 엔티티 정의
@Table(name = "board") // 테이블명 정의
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder@ToString
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    @Column( nullable = false ) // not null
    private String btitle; //제목
    @Column( nullable = false ) // not null
    private String  bcontent; //3. 내용
    @Column( nullable = false ) // not null
    private String bwriter; // 4. 작성자
    private String bfile; //; 5. 첨부파일
    private String bview; // 8. 조회수
    private String bgood; //9. 추천수
    private String bbad; //10. 비추천

    // 연관관계1 [ 회원번호[pk : mno] <--양방향--> 게시물번호[fk : bno]
    @ManyToOne
    @JoinColumn(name="mno") // 테이블에서 사용할 fk의 필드명 정의
    @ToString.Exclude
    private MemberEntity memberEntity;  // PK에 엔티티 객체

    @ManyToOne // [ 1:n] FK에 해당 어노테이션
    @JoinColumn(name="bcno")
    @ToString.Exclude
    private CategoryEntity categoryEntity;

    public BoardDto toDto(){
        return BoardDto
                .builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bcontent( this.bcontent )
                .bwriter( this.bwriter)
                .bfile( this.bfile)
                .bview( this.bview)
                .bgood( this.bgood)
                .bbad( this.bbad)
                .build();
    }
}
