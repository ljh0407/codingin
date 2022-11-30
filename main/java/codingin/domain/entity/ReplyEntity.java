package codingin.domain.entity;

import codingin.domain.BaseEntity;
import codingin.domain.dto.ReplyDto;
import lombok.*;

import javax.persistence.*;

@Entity // 엔티티 정의
@Table(name = "reply") // 테이블명 정의
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;

    @Column
    private String rcomment; //댓글

    // 연관관계1 [ 회원번호[pk : mno] <--양방향--> 게시물번호[fk : rno]
    @ManyToOne
    @JoinColumn(name="mno") // 테이블에서 사용할 fk의 필드명 정의
    @ToString.Exclude
    private MemberEntity memberEntity;  // PK에 엔티티 객체

    public ReplyDto toDto(){
        return ReplyDto
                .builder()
                .rno( this.rno )
                .rcomment( this.rcomment)
                .build();
    }
}
