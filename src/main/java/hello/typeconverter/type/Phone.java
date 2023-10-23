package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Phone {

    // 전화번호 앞자리 3글자
    private String tel1;

    // 전화번호 중간자리 4글자
    private int tel2;

    // 전화번호 끝자리 4글자
    private int tel3;

    public Phone(String tel1, int tel2, int tel3) {
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
    }
}
